package com.niit.Mobitel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {
    public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Mobiltel");
		context.refresh();
		
		System.out.println("Hello from App Test");
	}
}
