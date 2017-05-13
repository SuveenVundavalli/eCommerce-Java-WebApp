package com.niit.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.My_CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.My_Cart;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CartController {

	private static Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	My_Cart myCart;

	@Autowired
	My_CartDAO myCartDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	HttpSession session;

	@RequestMapping("/myCart")
	public String myCart(Model model) {
		log.debug("Starting of myCart in CartController");

		//model.addAttribute("myCart", myCart);

		String loggedInUserID = (String) session.getAttribute("loggedInUserID");

		if (loggedInUserID != null) {
			int cartSize = myCartDAO.list(loggedInUserID).size();

			if (cartSize == 0) {
				model.addAttribute("errorMessage", "You do not have any products in your cart!");
			} else {
				model.addAttribute("cart", myCart);
				model.addAttribute("cartList", myCartDAO.list(loggedInUserID));
				model.addAttribute("isUserClickedCart", "true");
				model.addAttribute("totalAmount", myCartDAO.getTotalAmount(loggedInUserID));
				long totalAmount = (long) myCartDAO.getTotalAmount(loggedInUserID);
				session.setAttribute("totalAmount", totalAmount);
				session.setAttribute("cartSize", cartSize);
				session.setAttribute("isAdmin", "false");
				session.setAttribute("cart", myCart);
				// session.setAttribute("isUserAtHomePage", "false");
				// System.out.println(totalAmount);
			}

		}

		log.debug("Ending of myCart in CartController");
		return "Home";
	}

	@RequestMapping("/myCart-add/{id}")
	public ModelAndView addToCart(@PathVariable("id") String id) {
		log.debug("Starting of addToCart in CartController");

		Product product = productDAO.getProductById(id);

		myCart.setProduct_name(product.getName());
		myCart.setPrice(product.getPrice());

		String loggedInUserID = (String) session.getAttribute("loggedInUserID");

		myCart.setUser_id(loggedInUserID);
		myCart.setStatus("N");
		myCart.setQuantity(1);
		myCart.setDate_added(new Date(System.currentTimeMillis()));
		session.setAttribute("isAdmin", "false");
		myCartDAO.save(myCart);

		// This way it will redirect to Home.jsp
		ModelAndView mv = new ModelAndView("redirect:/Home");
		mv.addObject("successMessage", "Successfully added product to your cart");
		session.setAttribute("successMessage", "Successfully added product to your cart");
		int cartSize = myCartDAO.list(loggedInUserID).size();
		session.setAttribute("cartSize", cartSize);

		log.debug("Ending of addToCart in CartController");
		return mv;

	}

	@RequestMapping("/myCart-delete/{id}")
	public ModelAndView removeFromCart(@PathVariable("id") int id) {
		log.debug("Starting of removeFromCart in CartController");

		ModelAndView mv = new ModelAndView("redirect:/myCart");
		// Check whether products are there for this category or not

		if (myCartDAO.delete(id) == true) {
			mv.addObject("cartMessage", "Successfullly deleted from cart");
		} else {
			mv.addObject("cartMessage", "Failed to delete from cart");
		}
		
		String loggedInUserID = (String) session.getAttribute("loggedInUserID");
		int cartSize = myCartDAO.list(loggedInUserID).size();
		session.setAttribute("cartSize", cartSize);

		log.debug("Ending of removeFromCart in CartController");
		return mv;

	}

	@RequestMapping("/myCart-deleteAll/{user_id}")
	public ModelAndView removeAllProductsFromCart(@PathVariable("user_id") String id) {
		log.debug("Starting of removeAllProductsFromCart in CartController");

		ModelAndView mv = new ModelAndView("redirect:/Home");
		// Check whether products are there for this category or not

		if (myCartDAO.deleteAllProductsInCart(id) == true) {
			mv.addObject("cartMessage", "Successfully deleted cart");
			String loggedInUserID = (String) session.getAttribute("loggedInUserID");

			int cartSize = myCartDAO.list(loggedInUserID).size();
			session.setAttribute("cartSize", cartSize);
		} else {
			mv.addObject("cartMessage", "Failed to delete cart");
		}

		log.debug("Ending of removeFromCart in CartController");
		return mv;

	}
/*
	@RequestMapping("myCart-checkOut/{user_id}")
	public ModelAndView cartCheckout(@PathVariable("user_id") String id) {
		log.debug("Starting of cartCheckout in CartController");

		ModelAndView mv = new ModelAndView("redirect:/myCart-checkOut");
		// Check whether products are there for this category or not
		if (myCartDAO.deleteAllProductsInCart(id) == true) {
			session.setAttribute("isUserCheckedOut", "true");
			mv.addObject("isUserCheckedOut", "true");
			session.setAttribute("isUserAtHomePage", "false");
			String loggedInUserID = (String) session.getAttribute("loggedInUserID");

			int cartSize = myCartDAO.list(loggedInUserID).size();
			session.setAttribute("cartSize", cartSize);
		} else {
			mv.addObject("cartMessage", "Failed to checkout");
		}

		log.debug("Ending of cartCheckout in CartController");
		return mv;

	}
	*/
	@RequestMapping("/myCart-checkOut/{user_id}")
	public String cartCheckout(@PathVariable("user_id") String id, Model model) {
		log.debug("Starting of cartCheckout in CartController");

		// Check whether products are there for this category or not
		if (myCartDAO.deleteAllProductsInCart(id) == true) {
			//session.setAttribute("isUserCheckedOut", "true");
			model.addAttribute("isUserCheckedOut", "true");
			session.setAttribute("isUserAtHomePage", "false");
			String loggedInUserID = (String) session.getAttribute("loggedInUserID");

			int cartSize = myCartDAO.list(loggedInUserID).size();
			session.setAttribute("cartSize", cartSize);
		} else {
			model.addAttribute("cartMessage", "Failed to checkout");
		}

		log.debug("Ending of cartCheckout in CartController");
		return "redirect:/checkout";
	}
	
	@RequestMapping("/checkout")
	public String viewProductHome(Model model) {
		model.addAttribute("isUserCheckedOut", "true");
		return "Home";
		
	}
	

}
