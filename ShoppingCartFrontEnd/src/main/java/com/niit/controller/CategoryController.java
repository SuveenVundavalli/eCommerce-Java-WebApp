package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {

	// Logger Statements
	// SLF4J - Simple Logging Facade for Java
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	HttpSession session;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;

	// crud category
	@RequestMapping("/manage_category_add")
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

		// Before calling save method, check whether category_id already exists
		// in db
		// if it does not exist, then only call save method.
		log.debug("Ending of create category");
		return mv;

	}

	// attach data to url we use @PathVariable
	@RequestMapping("/manage-category-delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) {
		
		log.debug("Starting of delete Category");
		log.info("You are about to delete a category with id : " + id);
		
		ModelAndView mv = new ModelAndView("/Home");
		if (categoryDAO.delete(id) == true) {
			mv.addObject("message", "Successfullly deleted");
		} else {
			mv.addObject("message", "Failed to delete");
		}
		log.debug("Ending of delete Category");

		// get all categories
		List<Category> categoryList = categoryDAO.list();
		// attach to session
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);
		return mv;
	}

}
