package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {

	public boolean saveOrUpdate(Product product);


	// delete category
	public boolean delete(String id);

	public List<Product> list();

	public Product getProductById(String id);
	
	//get all products pertaining to particular category
	public List<Product> getAllProductsByCategoryId(String categoryId);
	public List<Product> getAllProductsBySupplierId(String supplierId);
	
	public Product getProductByName(String name);
	
	
}
