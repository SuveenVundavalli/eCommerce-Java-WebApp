package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;

	// crud category
	@RequestMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) {
		ModelAndView mv = new ModelAndView("Home");

		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		if (categoryDAO.getCategoryById(id) != null) {
			mv.addObject("message", "Category already exists with id : "+id);
			return mv;
		} else {
			categoryDAO.save(category);
			mv.addObject("message", "Category creation success with id : "+id);

		}
		// Before calling save method, check whether category_id already exists
		// in db
		// if it does not exist, then only call save method.

		return mv;

	}

}
