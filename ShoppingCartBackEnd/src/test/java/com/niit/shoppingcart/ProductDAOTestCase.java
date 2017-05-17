package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

public class ProductDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the category from context
		product = (Product)context.getBean("product");
		
	}
	
	@Test
	public void createProductTestCase()
	{
		
		product.setId("SamsungTest1");
		product.setName("Samsung S8 256gb");
		product.setDescription("Brand new Samsung S8 64gb blue");
		product.setPrice(70000);
		product.setCategory_id("Mobiles");
		product.setSupplier_id("Sangeetha");
		product.setQuantity(4);
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} 

}
