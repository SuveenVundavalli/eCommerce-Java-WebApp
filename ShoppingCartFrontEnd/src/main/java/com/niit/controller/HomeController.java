package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


	@RequestMapping("/")
	public String goToHome(Model model){
		model.addAttribute("message", "Thank you for visiting Shopping Cart! <br>");
		return "Home";
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
