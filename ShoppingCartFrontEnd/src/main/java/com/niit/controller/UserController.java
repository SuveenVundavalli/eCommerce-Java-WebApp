package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {

	// Logger Statements
	// SLF4J - Simple Logging Facade for Java
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	// To connect to user in backend
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;

	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	

	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView("/Home");
		log.debug("Starting of the method login");
		
		log.info("You are login with id : "+id);
		if (userDAO.validate(id, password) == true) {
			log.debug("Valid credentials");
			user = userDAO.get(id);
			mv.addObject("message", "Welcome " + user.getName() + "!");

			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", categoryDAO);

			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplierDAO);
			
			session.setAttribute("loggedInUserID", id);


			// check whether user role is admin or user

			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("You are admin");
				mv.addObject("isAdmin", "true");
				 session.setAttribute("role", "ROLE_ADMIN");

			} else {
				log.debug("You are a customer");
				mv.addObject("isAdmin", "false");
				session.setAttribute("role", "ROLE_USER");
				session.setAttribute("isUserLoggedIn", "true");
			}
		} else {
			log.debug("Invalid user");
			mv.addObject("message", "invalid credentials");
		}
		log.debug("Ending of the method login");
		return mv;

	}
	
	@RequestMapping("/Register")
	public ModelAndView register(@RequestParam("uId") String id, @RequestParam("uPassword") String password, @RequestParam("uName") String name, @RequestParam("uContact") String contact) {

		ModelAndView mv = new ModelAndView("/Home");
		log.debug("Starting of the method register");
		log.debug("Assigning values");
		
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setContact(contact);
		user.setRole("ROLE_USER");
		
		
		log.info("You are signing up with username : "+id);
		
		if (userDAO.save(user) == true) {
			log.debug("saving credentials");
			user = userDAO.get(id);
			mv.addObject("message", "Welcome " + user.getName() + "! Please Login to Continue");

			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", categoryDAO);

			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplierDAO);
			

			
		} else {
			log.debug("Error");
			mv.addObject("message", "invalid credentials");
		}
		log.debug("Ending of the method login");
		return mv;

	}

}
