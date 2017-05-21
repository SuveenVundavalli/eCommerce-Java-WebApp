package com.niit.usermodule.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.usermodule.dao.UserDAO;
import com.niit.usermodule.model.User;


@Controller
public class HomeController {

	private static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired HttpSession session;

	@RequestMapping({"/","/Home"})
	public ModelAndView goToHome(){
		log.debug("Starting of default request mapping");
		ModelAndView mv = new ModelAndView("Home");
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		mv.addObject("message", "Welcome to User Module");
		mv.addObject("isUserAtHome", "true");
		
		log.debug("Ending of default request mapping");
		return mv;
	}
	
	@RequestMapping("/AboutUs")
	public ModelAndView aboutUs(){
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isUserClickedAboutUs", "true");
		return mv;
	}
}
