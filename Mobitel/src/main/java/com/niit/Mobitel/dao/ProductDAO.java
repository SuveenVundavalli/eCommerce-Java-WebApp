package com.niit.Mobitel.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	//Constructor
	public ProductDAO(SessionFactory sessionfactory){
		this.sessionfactory = sessionfactory;
	}
	
}
