package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	//@Autowired User

	@RequestMapping("/")
	public ModelAndView goToHome(){
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting Shopping Cart! <br>");
		//model.addAttribute("message", "Thank you for visiting Shopping Cart! <br>");
		return mv;
		//return "Home";
	}

	@RequestMapping("/LoginPage")
	public String loginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");
		return "Home";
	}
	@RequestMapping("/RegistrationPage")
	public String registerPage(Model model) {
		model.addAttribute("isUserClickedRegistration", "true");
		return "Home";
	}
	@RequestMapping("/MainPage")
	public String mainPage(Model model) {
		model.addAttribute("isUserClickedMain", "true");
		return "Home";
	}
}
