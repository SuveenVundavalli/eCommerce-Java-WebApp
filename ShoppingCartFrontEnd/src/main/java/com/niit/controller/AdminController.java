package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		
		return mv;
	}
	
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView manageSuppliers() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");

		return mv;
	}

	@RequestMapping("/manageProducts")
	public ModelAndView manageProducts() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");

		return mv;
	}
}
