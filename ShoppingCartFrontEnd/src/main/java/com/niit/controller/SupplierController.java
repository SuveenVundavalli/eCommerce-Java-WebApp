package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;

	// crud category
	@RequestMapping("/manage_supplier_add")
	public ModelAndView createCategory(@RequestParam("sId") String id, @RequestParam("sName") String name,
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
		// Before calling save method, check whether category_id already exists
		// in db
		// if it does not exist, then only call save method.

		return mv;

	}

}
