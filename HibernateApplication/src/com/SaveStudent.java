package com;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class SaveStudent {
	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sessionfac = cfg.buildSessionFactory();
			Session session = sessionfac.openSession();
			Transaction tx = session.beginTransaction();
			com.Student obj = new com.Student();
			obj.setsId(1004);
			obj.setsName("Suveen");
			obj.setsAdd("Dilsukhnagar");
			
			session.persist(obj);
			
			System.out.println("Object Persisted");
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enception Arised "+e);
		}
	}
}
