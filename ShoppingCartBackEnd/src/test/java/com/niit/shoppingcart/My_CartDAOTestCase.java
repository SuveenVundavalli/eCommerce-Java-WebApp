package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.My_CartDAO;
import com.niit.shoppingcart.domain.My_Cart;

public class My_CartDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static My_CartDAO my_CartDAO;
	@Autowired
	static My_Cart my_Cart;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		my_CartDAO =  (My_CartDAO) context.getBean("my_CartDAO");
		
		//get the category from context
		
		my_Cart = (My_Cart)context.getBean("my_Cart");
		
	}
	
	
	@Test
	public void createMy_CartTestCase()
	{
		my_Cart.setId("cart001");
		my_Cart.setUser_id("Suveen");
		my_Cart.setProduct_name("Iphone 6s 64gb");
		my_Cart.setPrice("50000");
		my_Cart.setQuantity("2");
		
		
		boolean flag =  my_CartDAO.save(my_Cart);

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createMy_CartTestCase",true,flag);
		
	}
	@Test
	public void updateMy_CartTestCase()
	{
		my_Cart.setId("cart001");
		my_Cart.setUser_id("Suveen");
		my_Cart.setProduct_name("Iphone 6s 64gb");
		my_Cart.setPrice("50000");
		my_Cart.setQuantity("2");
		
		
		boolean flag =  my_CartDAO.update(my_Cart);
		
		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("updateMy_CartTestCase",true,flag);
		
	}
	
	@Test
	public void listAllMy_CartTestCase()
	{
		int actualSize = my_CartDAO.list().size();
		assertEquals(1, actualSize);
	} 

}
