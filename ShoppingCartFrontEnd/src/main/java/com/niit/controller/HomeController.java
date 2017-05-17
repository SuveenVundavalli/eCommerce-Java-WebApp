package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.My_CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.My_Cart;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class HomeController {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	// @Autowired User

	@Autowired
	HttpSession session;

	@Autowired
	Category category;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Product product;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	My_Cart myCart;

	@Autowired
	My_CartDAO myCartDAO;

	@RequestMapping("/")
	public ModelAndView goToHome() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting Shopping Cart! <br>");
		mv.addObject("isUserAtHomePage", "true");
		// model.addAttribute("message", "Thank you for visiting Shopping Cart!
		// <br>");

		// get all categories
		List<Category> categoryList = categoryDAO.list();

		// attach category to session
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);

		// get products
		List<Product> productList = productDAO.list();

		// attach products to session
		session.setAttribute("productList", productList);
		session.setAttribute("product", product);

		// get products
		List<Supplier> supplierList = supplierDAO.list();

		// attach supplier to session
		session.setAttribute("supplierList", supplierList);
		session.setAttribute("supplier", supplier);
		

		return mv;
		// return "Home";
	}

	

	@RequestMapping("/Home")
	public ModelAndView goToHomeButton() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting Shopping Cart! <br>");
		mv.addObject("isUserAtHomePage", "true");
		
		// get all categories
		List<Category> categoryList = categoryDAO.list();

		// attach category to session
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);

		// get products
		List<Product> productList = productDAO.list();

		// attach products to session
		session.setAttribute("productList", productList);
		session.setAttribute("product", product);

		// get products
		List<Supplier> supplierList = supplierDAO.list();

		// attach supplier to session
		session.setAttribute("supplierList", supplierList);
		session.setAttribute("supplier", supplier);

		return mv;
		// return "Home";
	}

	@RequestMapping("/Login")
	public String loginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");
		model.addAttribute("isUserAtHomePage", "false");

		Long currentTime = System.currentTimeMillis();
		Date currentDate = new Date(currentTime);
		return "Home";
	}
	
	@RequestMapping("/SignOut")
	public ModelAndView userSignOut() {
		log.debug("Signout Initiated");
		ModelAndView mv = new ModelAndView("redirect:/");
		session.setAttribute("isUserLoggedIn", "false");
		session.setAttribute("isAdmin", "false");

		return mv;
	}
	
	@RequestMapping("/RegistrationPage")
	public String registerPage(Model model) {
		model.addAttribute("isUserClickedRegistration", "true");
		model.addAttribute("isUserAtHomePage", "false");
		return "Home";
	}

	@RequestMapping("/MainPage")
	public String mainPage(Model model) {
		model.addAttribute("isUserClickedMain", "true");
		return "Home";
	}

	@RequestMapping("/ContactUs")
	public String contactUsPage(Model model) {
		model.addAttribute("isUserClickedContactUs", "true");
		model.addAttribute("isUserAtHomePage", "false");
		return "Home";
	}
}
