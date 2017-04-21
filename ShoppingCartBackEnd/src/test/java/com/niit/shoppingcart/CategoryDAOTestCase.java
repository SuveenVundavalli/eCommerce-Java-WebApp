package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static CategoryDAO  categoryDAO;
	
	@Autowired  static Category category;
	

	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		
		//get the category from context
		
		category = (Category)context.getBean("category");
		
	}
	
	@Test
	public void createCategoryTestCase()
	{
		category.setId("Laptop");
		category.setName("Mobile");
		category.setDescription("This category contains laptops");
		
		boolean flag =  categoryDAO.save(category);
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createCategoryTestCase",true,flag);
		
	}
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("Laptop");
		category.setName("Laptop");
		category.setDescription("This category contains laptops");
		
		boolean flag =  categoryDAO.update(category);
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("updateCategoryTestCase",true,flag);
		
	}
	
	
	@Test
	public void listAllCategoryTestCase()
	{
		int actualSize = categoryDAO.list().size();
		assertEquals(2, actualSize);
	}

}
