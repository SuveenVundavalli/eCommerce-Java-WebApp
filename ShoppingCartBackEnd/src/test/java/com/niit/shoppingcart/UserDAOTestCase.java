package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

		user = (User) context.getBean("user");

	}

	@Test
	public void createUserTestCase() {
		user.setId("s");
		user.setName("s");
		user.setPassword("s");
		user.setRole("ROLE_USER");
		user.setContact("8686");
		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);

	}

	@Test
	public void updateUserTestCase() {
		user.setId("Rakesh");
		user.setName("Rakesh");
		user.setPassword("Rakesh");
		user.setRole("ROLE_USER");
		user.setContact("8099748101");
		boolean flag = userDAO.update(user);

		assertEquals("updateUserTestCase", true, flag);

	}

	@Test
	public void validateUserTestCase() {

		boolean flag = userDAO.validate("Rakesh", "Rakesh");
		assertEquals(true, flag);

	}

	@Test
	public void listAllUserTestCase() {
		int actualSize = userDAO.list().size();
		assertEquals(5, actualSize);
	}

}
