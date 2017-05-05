package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean save(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try
		{
		sessionFactory.getCurrentSession().update(category);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Category> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category getCategoryById(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to Category class
		//like select * from category where id = ?
	  return 	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
		
	}
	
	
	public Category getCategoryByName(String name) {
		
		//Since name is not a primary key, we cannot use the procedure used in getCategoryById(id).
		//We write query as follow.
		return 	(Category)  sessionFactory.getCurrentSession().createQuery("from Category where name = ?").setString(0, name).uniqueResult();
		/*
		 * return 	(Category)  sessionFactory.getCurrentSession().createQuery("from Category where name = ?").setString(0, name).uniqueResult(); is same as
		 * 
		 * Query query = getCurrentSession().createQuery("from Category where name = ?");
		 * query.setString(0,name);
		 * query.uniqueResult();
		 */
		
		
	}

	

}
