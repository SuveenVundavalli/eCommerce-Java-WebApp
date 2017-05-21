package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.validator.PublicClassValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {

	private static Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	HttpSession session;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;

	// crud supplier
	@RequestMapping("/manage-supplier-add")
	public ModelAndView createSupplier(@RequestParam("sId") String id, @RequestParam("sName") String name,
			@RequestParam("sDescription") String description) {
		ModelAndView mv = new ModelAndView("Home");

		supplier.setId(id);
		supplier.setName(name);
		supplier.setDescription(description);

		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("isUserLoggedIn", "false");

		if (supplierDAO.getSupplierById(id) != null) {
			mv.addObject("errorMessage", "Supplier already exists with id : " + id);
			session.setAttribute("errorMessage", "Supplier already exists with id : " + id);
			return mv;
		} else {
			supplierDAO.save(supplier);
			mv.addObject("successMessage", "Supplier creation success with id : " + id);
			session.setAttribute("successMessage", "Supplier creation success with id : " + id);

		}

		// get all categories
		List<Supplier> supplierList = supplierDAO.list();
		// attach to session
		session.setAttribute("supplierList", supplierList);
		session.setAttribute("supplier", supplier);

		log.debug("Ending of create supplier");
		return mv;

	}

	@RequestMapping("/manage-supplier-delete/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") String id) {

		log.debug("Starting of delete Supplier");
		log.info("You are about to delete a supplier with id : " + id);

		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");

		int noOfProducts = productDAO.getAllProductsBySupplierId(id).size();
		if (noOfProducts != 0) {
			log.debug("Few products are there by this seller, you cannot delete!");
			session.setAttribute("errorMessage", "There are " + noOfProducts + " products under this " + id + " seller, you cannot delete!");
			return mv;
		}
		if (supplierDAO.delete(id) == true) {
			mv.addObject("successMessage", "Successfullly deleted. ");
			session.setAttribute("successMessage", "Successfullly deleted. ");
		} else {
			mv.addObject("errorMessage", "Failed to delete. ");
			session.setAttribute("errorMessage", "Failed to delete. ");
		}
		log.debug("Ending of delete Supplier");

		return mv;
	}

	@RequestMapping("/manage-supplier-edit/{id}")
	public ModelAndView editSupplier(@PathVariable("id") String id) {
		log.debug("Starting of editSupplier");
		log.info("You are about to edit a supplier with id : " + id);

		supplier = supplierDAO.getSupplierById(id);

		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		mv.addObject("selectedSupplier", supplier);
		session.setAttribute("selectedSupplier", supplier);
		session.setAttribute("isAdminClickedManageSupplierEdit", "true");

		log.debug("Ending of editSupplier");

		return mv;
	}

	@RequestMapping("/manage-supplier-update")
	public ModelAndView updateSupplier(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) {
		log.debug("Starting of updateSupplier");
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		session.setAttribute("isAdminClickedManageSupplierEdit", "false");

		supplier.setId(id);
		supplier.setName(name);
		supplier.setDescription(description);

		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");

		if (supplierDAO.getSupplierById(id) == null) {
			mv.addObject("errorMessage", "Supplier does not exists with id : " + id);
			session.setAttribute("errorMessage", "Supplier does not exists with id : " + id);
			return mv;
		} else {
			supplierDAO.update(supplier);
			mv.addObject("successMessage", "Supplier updated success with id : " + id);
			session.setAttribute("successMessage", "Supplier updated success with id : " + id);

		}

		session.setAttribute("isAdminClickedManageSupplierEdit", "false");
		log.debug("Ending of updateSupplier");
		return mv;
	}

}
