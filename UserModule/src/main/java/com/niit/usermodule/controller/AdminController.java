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
public class AdminController {

	private static Logger log = LoggerFactory.getLogger(AdminController.class); 

	@Autowired
	HttpSession session;
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("manageUsers")
	public ModelAndView manageUsers(){
		log.debug("Starting of manageUsers method");
		ModelAndView mv = new ModelAndView("Home");
		
		session.setAttribute("user", user);
		session.setAttribute("userList", userDAO.list());
		
		log.debug("Ending of manageUsers method");
		return mv;
	}
}
