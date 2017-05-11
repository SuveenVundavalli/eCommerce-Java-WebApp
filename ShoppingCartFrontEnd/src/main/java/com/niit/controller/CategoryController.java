package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CategoryController {

	// Logger Statements
	// SLF4J - Simple Logging Facade for Java
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	HttpSession session;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;

	// crud category
	@RequestMapping("/manage-category-add")
	public ModelAndView createCategory(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) {
		log.debug("Starting of create category");
		ModelAndView mv = new ModelAndView("Home");

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		if (categoryDAO.getCategoryById(id) != null) {
			mv.addObject("cMessage", "Category already exists with id : " + id);
			return mv;
		} else {
			categoryDAO.save(category);
			mv.addObject("cMessage", "Category creation success with id : " + id);

		}

		// get all categories
		List<Category> categoryList = categoryDAO.list();
		// attach to session
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);
		session.setAttribute("isUserLoggedIn", "false");

		// Before calling save method, check whether category_id already exists in db
		// if it does not exist, then only call save method.
		session.setAttribute("isAdminClickedManageCategoryEdit", "false");
		log.debug("Ending of create category");
		return mv;

	}

	// attach data to url we use @PathVariable
	@RequestMapping("/manage-category-delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) {
		
		log.debug("Starting of delete Category");
		log.info("You are about to delete a category with id : " + id);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		//Check whether products are there for this category or not
		int noOfProducts = productDAO.getAllProductsByCategoryId(id).size();
		if(noOfProducts != 0){
			log.debug("Few products are there under this category, you cannot delete!");
			session.setAttribute("categoryMessage", "There are "+noOfProducts+" products under this "+id+" category, you cannot delete!");
			return mv;
		}
		
		
		if (categoryDAO.delete(id) == true) {
			mv.addObject("categoryMessage", "Successfullly deleted");
		} else {
			mv.addObject("categoryMessage", "Failed to delete");
		}
		log.debug("Ending of delete Category");
		
		return mv;
	}
	
	//Edit category
	@RequestMapping("/manage-category-edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id){
		log.debug("Starting of editCategory");
		log.info("You are about to edit a category with id : " + id);
		
		category = categoryDAO.getCategoryById(id);
		
		//Selected category details we have to store in another instance
		//i.e., ModelAndView instance
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");

		session.setAttribute("isAdminClickedManageCategoryEdit", "true");
		mv.addObject("selectedCategory", category);		
		session.setAttribute("selectedCategory", category);	
		
		log.debug("Ending of editCategory");

		return mv;
	}
	
	@RequestMapping("/manage-category-update")
	public ModelAndView updateCategory(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) {
		log.debug("Starting of updateCategory");
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		session.setAttribute("isAdminClickedManageCategoryEdit", "false");	

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		if (categoryDAO.getCategoryById(id) == null) {
			mv.addObject("cMessage", "Category does not exists with id : " + id);
			return mv;
		} else {
			categoryDAO.update(category);
			mv.addObject("cMessage", "Category updated success with id : " + id);

		}
		//session.setAttribute("selectedCategory", newCategory());
		// Before calling save method, check whether category_id already exists
		// in db
		// if it does not exist, then only call save method.
		
		session.setAttribute("isAdminClickedManageCategoryEdit", "false");
		log.debug("Ending of updateCategory");
		
		return mv;
	}

}
