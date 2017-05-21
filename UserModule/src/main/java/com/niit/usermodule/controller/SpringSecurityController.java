package com.niit.usermodule.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.usermodule.dao.UserDAO;
import com.niit.usermodule.model.User;


@Controller
public class SpringSecurityController {

	public static Logger log = LoggerFactory.getLogger(SpringSecurityController.class);

	@Autowired
	private HttpSession session;
	
	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
		log.debug("Ending of the method loginError");
		return "redirect:/Login";

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");

		log.debug("Ending of the method accessDenied");
		return "Home";

	}

	
	@RequestMapping(value = "/checkRole", method = RequestMethod.GET)
	public ModelAndView checkRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("starting of the method validate");
		ModelAndView mv = new ModelAndView("Home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userID = auth.getName();
		session.setAttribute("loggedInUser", userID);
		session.setAttribute("successMessage", "Welcome "+userID+". ");
		session.setAttribute("user", user);
		session.setAttribute("userList", userDAO.list());
		if (request.isUserInRole("ROLE_ADMIN")) {
			log.debug("Logged in as Admin");
			session.setAttribute("isAdmin", "true");
			session.setAttribute("isUser", "false");
		} else {
			log.debug("Loggedin as User");
			mv.addObject("isUserAtHome", "true");
			session.setAttribute("isAdmin", "false");
			session.setAttribute("isUser", "true");
		}
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping("/secure_logout")
	public ModelAndView secureLogout() {
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:/Login");
		return mv;
	}

}
