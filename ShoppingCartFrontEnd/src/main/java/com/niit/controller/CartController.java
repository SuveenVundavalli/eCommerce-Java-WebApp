package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	@GetMapping("mycart/add/{id}")
	public ModelAndView addToCart(@PathVariable("id") String id){
		
		//This way it will redirect to Home.jsp
		ModelAndView mv = new ModelAndView("redirect:/");
		
		
		
		return mv;
		
	}
}
