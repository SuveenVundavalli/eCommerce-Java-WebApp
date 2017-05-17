package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ContactDAO;
import com.niit.shoppingcart.domain.Contact;

public class ContactDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ContactDAO contactDAO;
	@Autowired
	static Contact contact;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the categoryDAO from context
		contactDAO = (ContactDAO) context.getBean("contactDAO");

		// get the category from context

		contact = (Contact) context.getBean("contact");

	}

	@Test
	public void createContactTestCase() {
		contact.setName("Suveen Kumar Vundavalli");
		contact.setEmail("suveenkumar.vundavalli@gmail.com");
		contact.setContact("8686242020");
		contact.setMessage("Original : You designed a very good web application");

		boolean flag = contactDAO.save(contact);

		assertEquals("createContactTestCase", true, flag);

	}

	@Test
	public void updateContactTestCase() {

		boolean flag = contactDAO.delete(0);

		assertEquals("updateContactTestCase", true, flag);

	}

	@Test
	public void listAllContactTestCase() {
		int actualSize = contactDAO.list().size();
		assertEquals(1, actualSize);
	}

}
