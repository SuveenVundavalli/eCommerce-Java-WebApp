package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {

	public boolean save(Product product);

	public boolean update(Product product);

	// delete category
	public boolean delete(String id);

	public List<Product> list();

	public Product getProductById(String id);
	
	public Product getProductByName(String name);
	
}
