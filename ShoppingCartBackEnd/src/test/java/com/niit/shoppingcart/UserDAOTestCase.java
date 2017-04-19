package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static UserDAO userDAO;
	
	@Autowired static User user;
	
	//The above objects need to initialize
	/*
	 * This method is going to execute before calling any one of the test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		userDAO = (UserDAO) context.getBean("userDAO");
		
		//get the user from context
		user = (User) context.getBean("user");
	}
	
	@Test
	public void createUserTestCase() {
		user.setId("Abbas");
		user.setName("Abbas");
		user.setPassword("Abbas");
		user.setRole("ROLE_USER");
		boolean flag = userDAO.save(user);
		
		/*
		 * This assertEquals method
		 * 1. error		- If there is runtime errors 			- Red mark
		 * 2. success	- If expected and actual is same		- Green mark
		 * 3. fail		- If expected and actual is different	- Blue mark
		 */
	
		assertEquals("createUserTestCase",true,flag);
	}
	
	
	
	
	
	
	
	
}
