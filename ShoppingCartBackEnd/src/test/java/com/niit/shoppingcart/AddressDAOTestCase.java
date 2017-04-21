package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.AddressDAO;
import com.niit.shoppingcart.domain.Address;

public class AddressDAOTestCase {


	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static AddressDAO  addressDAO;
	
	@Autowired  static Address address;
	
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
			addressDAO =  (AddressDAO) context.getBean("addressDAO");
			
			//get the category from context
			
			address = (Address)context.getBean("address");
			
		}
		
		
		@Test
		public void createAddressTestCase()
		{
			address.setId("SuveenAddress");
			address.setUser_id("Suveen");
			address.setH_no("2-46-11");
			address.setStreet("Villa Vari Street, Venkat Nagar");
			address.setCity("Kakinada");
			address.setCountry("India");
			address.setPin("533003");
			
			boolean flag =  addressDAO.save(address);
			
		

			//error - if there is in runtime errors  -  Red mark
			//success  - if expected and actual is same  - green mark
			//fail  - if expected and actual is different  -  blue mark
			assertEquals("createAddressTestCase",true,flag);
			
		}
		
		@Test
		public void updateAddressTestCase()
		{
			address.setId("SwethaAddress");
			address.setUser_id("Suveen");
			address.setH_no("2-46-11");
			address.setStreet("Villa Vari Street, Venkat Nagar");
			address.setCity("Kakinada");
			address.setCountry("India");
			address.setPin("533003");
			
			boolean flag =  addressDAO.update(address);
			
		

			//error - if there is in runtime errors  -  Red mark
			//success  - if expected and actual is same  - green mark
			//fail  - if expected and actual is different  -  blue mark
			assertEquals("createAddressTestCase",true,flag);
			
		}
		
		@Test
		public void listAllAddressTestCase()
		{
			int actualSize = addressDAO.list().size();
			assertEquals(2, actualSize);
		}
	

}
