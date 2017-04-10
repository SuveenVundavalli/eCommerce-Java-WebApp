package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {
	
	public static void main(String[] args) {
		
		/*
		 * context below is called Bean Factory - which product from beans / instance
		 * context doesn't know which instances should create.
		 * context.scan(package-name) -- like dispatcher servlet
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit"); //Scan this package and find out where the (@Component) annotations are
		
		context.refresh();
		
		/*
		 * from now on, if you need any instance, do not create.
		 * You can ask context to get a particular bean getBean()
		 * You need to add @Component for the class for this to work
		 */
		context.getBean("category"); //The bean will be same as class name but first character will be lower case
		
		System.out.println("The user instance is created successfully");
	}
}
