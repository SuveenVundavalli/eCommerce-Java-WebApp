package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {
	
	//declare the methods
	
	//what type of operations you are going to do for user.
	
	
	//Operations
	//1) create/register  - save
	//2) update the user details  - update
	//3) validate the credentials  -  validate
	//4) get all users   - list
	
	
	//declare the methods with proper signature
	//access_specifier return_tye methodName( parameter_list)  throws exception_list
	
	
	
	// create/register  - save
	
	public  boolean save(User user);
	
	// update the user details  - update
	public boolean update(User user);
	
	// validate the credentials  -  validate
	//WE are going to use spring security in future.
	//we can delete this method. after using spring security.
	public boolean validate(String id, String password);
	
	// get all users   - list
	
	public List<User>     list();
	
	
	//get user details based on userID
	
	public User get(String id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
