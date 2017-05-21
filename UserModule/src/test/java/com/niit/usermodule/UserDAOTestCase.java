package com.niit.usermodule;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.usermodule.dao.UserDAO;
import com.niit.usermodule.model.User;

public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static User user;
	
	@Autowired
	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.usermodule");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

		user = (User) context.getBean("user");

	}
	
	@Test
	public void createUserTestCase(){
		user.setId("suveen");
		user.setPassword("suveen");
		user.setName("Suveen Kumar Vundavalli");
		user.setContact("8686242020");
		user.setRole("ROLE_ADMIN");
		boolean flag = userDAO.save(user);
		assertEquals("createUserTestCase",true,flag);
	}
	
	@Test
	public void updateUserTestCase(){
		user.setId("suveen");
		user.setPassword("suveen");
		user.setName("Suveen Kumar Vundavalli");
		user.setContact("8686242020");
		user.setRole("ROLE_USER");
		boolean flag = userDAO.update(user);
		assertEquals("updateUserTestCase",true,flag);
	}
	
	@Test
	public void validateUserTestCase(){
		boolean flag = userDAO.validate("Suveen", "Suveen");
		assertEquals("validateUserTestCase", true, flag);
	}
	
	@Test
	public void listUserTestCase(){
		int num = userDAO.list().size();
		assertEquals("listUserTestCase", 2, 2);
	}

}
