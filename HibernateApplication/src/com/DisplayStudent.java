package com;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class DisplayStudent {

	public static void main(String[] args) {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sessionfac = cfg.buildSessionFactory();
			Session session = sessionfac.openSession();
			
			Query query = session.createQuery("from Student");
			
			List<Student> list=query.getResultList();
			
			for(Student s:list){
				System.out.println(s);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enception Arised "+e);

		}
	}

}
