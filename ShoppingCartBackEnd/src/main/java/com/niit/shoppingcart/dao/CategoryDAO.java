package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {
	
	//create category
	public boolean save(Category category);
	
	//update category
	public boolean update(Category category);
	
	
	//get all categories
	public List<Category> list();
	
	//get category by id
	public Category getCategoryById(String id);
	
	//delete category
	public boolean delete(String id);
	

	//get category by id
	public Category getCategoryByName(String name);

}
