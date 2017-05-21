package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ContactDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Contact;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class AdminController {
	@Autowired HttpSession session;
	@Autowired Category category;
	@Autowired CategoryDAO categoryDAO;
	@Autowired Supplier supplier;
	@Autowired SupplierDAO supplierDAO;
	@Autowired Product product;
	@Autowired ProductDAO productDAO;
	@Autowired Contact contact;
	@Autowired ContactDAO contactDAO;
	@Autowired User user;
	@Autowired UserDAO userDAO;
	
	//Logger Statements
	//SLF4J - Simple Logging Facade for Java
	private static Logger log = LoggerFactory.getLogger(AdminController.class); 
	

	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories() {
		log.debug("Starting of the method manageCategories");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);
		session.setAttribute("isUserLoggedIn", "false");
		log.debug("Ending of the method manageCategories");
		//mv.addObject("isAdminClickedManageCategoryEdit", "false");
		return mv;
	}
	
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView manageSuppliers() {
		log.debug("Ending of the method manageSuppliers");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("supplier", supplier);
		session.setAttribute("isUserLoggedIn", "false");
		log.debug("Ending of the method manageSuppliers");

		return mv;
	}
	
	@RequestMapping("/manageUsers")
	public ModelAndView manageUsers() {
		log.debug("Starting of the method manageUsers");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedUsers", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("userList", userDAO.list());
		session.setAttribute("user", user);
		log.debug("Ending of the method manageUsers");
		
		return mv;
	}
	@RequestMapping("/manageContactUs")
	public ModelAndView manageContactUs() {
		log.debug("Starting of the method manageContactUs");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedContactUs", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("contactUsList", contactDAO.list());
		session.setAttribute("contact", contact);
		log.debug("Ending of the method manageContactUs");
		
		return mv;
	}
}
