package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {
	
	//declare the methods
	
	//what type of operations you are going to do for user
	
	/*
	 * operations
	 * 1. Create/ register 			- save
	 * 2. Update the user details 	- update
	 * 3. Validate the credentials 	- validate
	 * 4. Get all users				- list
	 */
	/*
	 * declare the methods with proper signatures
	 * Access Specifier return-type methodName(parameters_list) throws exception_list
	 */
	
	//create/register - save
	public boolean save(User user);
	
	//Update the user details - update
	public boolean update(User user);
	
	//validate the credentials - validate
	public boolean validate(String id, String password);
	
	//get all users
	public List<User> list();
	
	//get user details based on user id
	public User get(String id);
	

}
