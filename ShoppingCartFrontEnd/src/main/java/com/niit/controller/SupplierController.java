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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
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

	// crud supplier
	@RequestMapping("/manage_supplier_add")
	public ModelAndView createSupplier(@RequestParam("sId") String id, @RequestParam("sName") String name,
			@RequestParam("sDescription") String description) {
		ModelAndView mv = new ModelAndView("Home");

		supplier.setId(id);
		supplier.setName(name);
		supplier.setDescription(description);
		
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");

		if (supplierDAO.getSupplierById(id) != null) {
			mv.addObject("sMessage", "Supplier already exists with id : "+id);
			return mv;
		} else {
			supplierDAO.save(supplier);
			mv.addObject("sMessage", "Supplier creation success with id : "+id);

		}
		// Before calling save method, check whether supplier_id already exists
		// in db
		// if it does not exist, then only call save method.

		// get all categories
		List<Supplier> supplierList = supplierDAO.list();
		// attach to session
		session.setAttribute("supplierList", supplierList);
		session.setAttribute("supplier", supplier);

		// Before calling save method, check whether supplier_id already exists
		// in db
		// if it does not exist, then only call save method.
		log.debug("Ending of create supplier");
		return mv;

	}

	// attach data to url we use @PathVariable
	@RequestMapping("/manage-supplier-delete/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") String id) {
		
		log.debug("Starting of delete Supplier");
		log.info("You are about to delete a supplier with id : " + id);
		
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		if (supplierDAO.delete(id) == true) {
			mv.addObject("message", "Successfullly deleted");
		} else {
			mv.addObject("message", "Failed to delete");
		}
		log.debug("Ending of delete Supplier");

		return mv;
	}
	
	@RequestMapping("/manage-supplier-edit/{id}")
	public ModelAndView editSupplier(@PathVariable("id") String id) {
		log.debug("Starting of editSupplier");
		log.info("You are about to edit a supplier with id : " + id);
		
		supplier = supplierDAO.getSupplierById(id);
		
		//Selected category details we have to store in another instance
		//i.e., ModelAndView instance
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		mv.addObject("selectedSupplier", supplier);
		session.setAttribute("selectedSupplier", supplier);
		
		log.debug("Ending of editSupplier");

		return mv;
	}
	
	@PostMapping("/manage_supplier_update")
	public ModelAndView updateSupplier(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) {
		log.debug("Starting of updateSupplier");
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");

		supplier.setId(id);
		supplier.setName(name);
		supplier.setDescription(description);

		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");

		if (supplierDAO.getSupplierById(id) == null) {
			mv.addObject("cMessage", "Supplier does not exists with id : " + id);
			return mv;
		} else {
			supplierDAO.update(supplier);
			mv.addObject("cMessage", "Supplier updated success with id : " + id);

		}


		// Before calling save method, check whether supplier_id already exists
		// in db
		// if it does not exist, then only call save method.
		log.debug("Ending of updateSupplier");
		return mv;
	}

}
