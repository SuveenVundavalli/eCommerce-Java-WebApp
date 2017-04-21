package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.My_CartDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.My_Cart;

@Repository("my_CartDAO")
@Transactional
public class My_CartDAOImpl implements My_CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public My_CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(My_Cart my_Cart) {
		try {
			sessionFactory.getCurrentSession().save(my_Cart);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(My_Cart my_Cart) {
		try {
			sessionFactory.getCurrentSession().update(my_Cart);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<My_Cart> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from My_Cart").list();
	}

	public My_Cart get(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to Category class
		//like select * from category where id = ?
	  return 	(My_Cart)  sessionFactory.getCurrentSession().get(My_Cart.class, id);
		
	}

}
