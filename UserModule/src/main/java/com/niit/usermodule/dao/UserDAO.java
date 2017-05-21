package com.niit.usermodule.dao;

import java.util.List;

import com.niit.usermodule.model.User;

public interface UserDAO {

	// create/register - save
	public boolean save(User user);

	// update the user details - update
	public boolean update(User user);
	// delete the user details - update
	public boolean delete(String id);

	//validate user to login
	public boolean validate(String id, String password);

	// get all users - list
	public List<User> list();

	// get user details based on userID
	public User get(String id);
}
