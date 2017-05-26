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
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(My_Cart my_Cart) {
		try {
			sessionFactory.getCurrentSession().update(my_Cart);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<My_Cart> list(String userID) {
		return  sessionFactory.getCurrentSession().createQuery("from My_Cart where user_id=? and status = 'N'").setString(0, userID).list();
	}

	public double getTotalAmount(String userID) {
		return (Double) sessionFactory.getCurrentSession().createQuery("select sum(price) from My_Cart where user_Id=? and status = 'N'").setString(0, userID).uniqueResult();
	}

	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getCartById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public My_Cart getCartById(int id) {
		
		return 	(My_Cart)  sessionFactory.getCurrentSession().createQuery("from My_Cart where id = ?").setInteger(0, id).uniqueResult();
	}

	public boolean deleteAllProductsInCart(String user_id) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from My_Cart where user_id = ? and status = 'N'").setString(0, user_id).executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public boolean checkOut(String user_id) {
		try {
			sessionFactory.getCurrentSession().createQuery("update My_Cart set status = 'S' where user_id = ? and status = 'N'").setString(0, user_id).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

}
