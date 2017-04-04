package com.niit.loginapp.dao;

public class LoginDAO {

	//write simple method which takes two parameters and return boolean

	public boolean isValidCredentials(String id, String password){

		//Get the connection
		//write query
		//execute query


		//Temporarily assuming that id and password is niit

		if(id.equals("niit") && password.equals("niit")) 
		{
			return true;
		}
		else
		{ 
			return false;
		}
	}

}
