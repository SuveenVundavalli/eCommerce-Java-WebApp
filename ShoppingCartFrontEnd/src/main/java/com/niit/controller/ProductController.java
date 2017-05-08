package com.niit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.util.FileUtil;


@Controller
public class ProductController {

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	Supplier supplier;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;
	
	
	// Setting Path to store images
	private String path = "//Users//Suveen//Documents//java//workspace//SLT//SLTProject//ShoppingCartFrontEnd//src//main//webapp//resources//img";

	// Add or Update Product
	@PostMapping("/manage_product_add")
	public String addPorduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file,
			Model model) {
		log.debug("Starting of method addProduct");
		Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
		Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());

		product.setCategory(category);
		product.setSupplier(supplier);

		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());
		product.setId(Util.removeComman(product.getId()));
		productDAO.saveOrUpdate(product);
		
		
		FileUtil.upload(path, file, product.getId() + ".jpg");

		model.addAttribute("isAdminClickedProducts", "true");
		model.addAttribute("isAdmin", "true");

		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("product", new Product());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("category", new Category());

		log.debug("Ending of the method add Product");
		return "Home";
	}

	// Delete Product
	@RequestMapping("/manage_product_delete/{id}")
	public String deleteProduct(@PathVariable("id") String id, ModelMap model) {
		log.debug("Starting of the method deleteProduct");
		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		log.debug("ending of method deleteProduct");
		return "redirect:/manageProducts";
		
	}
	
	//Edit Products
	@RequestMapping("/manage_product_edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		log.debug("Starting of the method editProduct");
		product = productDAO.getProductById(id);
		model.addAttribute("selectedProduct", product);
		log.debug("Ending of the method editProduct");
		return "redirect:/manageProducts";
	}
	
	//Get select product details
	@RequestMapping("/manage_product_get/{id}")
	public ModelAndView getSelectedProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
		log.debug("Starting of the method getSelectedProduct");
		ModelAndView mv = new ModelAndView("redirect:/");
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.getProductById(id));
		log.debug("ending of method getSelectedProduct");
		return mv;
	}
	
	@RequestMapping("/search_product/{search_string}")
	public ModelAndView getAllProductsBySearchString(@PathVariable("search_string") String search_string) {
		
		List<Product> products = productDAO.getSimilarProducts("search_string");
		ModelAndView mv = new ModelAndView("/Home");
		
		if(products.isEmpty()) {
			mv.addObject("message", "No products are available with the search test :"+search_string);
		} else {
			mv.addObject("productList", products);
		}
		return mv;
		
		
	}
	
	

}


