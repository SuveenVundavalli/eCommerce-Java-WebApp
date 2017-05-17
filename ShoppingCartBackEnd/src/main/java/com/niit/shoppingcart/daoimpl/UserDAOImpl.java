package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

//Note : we will get errors  - will solve tomorrow

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	//Transaction tx;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	

	public boolean save(User user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		//tx = sessionFactory.getCurrentSession().getTransaction();
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(User user) {
		try
		{
		sessionFactory.getCurrentSession().update(user);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean validate(String id, String password) {
		
		
	Query query=	 sessionFactory.getCurrentSession().createQuery(" from User where id = ? and password = ?");
	query.setString(0, id);     //actually the index will start from zero  - will get once exception.
	query.setString(1, password);
	
	 if(  query.uniqueResult()  == null)
	 {
		 //means no row exist i.e., invalid credentials
		 return false;
	 }
	 else
	 {
		 //means row exist i.e., valid credentials
		 return true;
	 }
	
	}

	public List<User> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User get(String id) {
		
		
	  return 	(User)  sessionFactory.getCurrentSession().get(User.class, id);
		
	}

}
