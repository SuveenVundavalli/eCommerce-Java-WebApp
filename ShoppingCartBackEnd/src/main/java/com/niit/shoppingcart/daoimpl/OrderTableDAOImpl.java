package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.OrderTableDAO;
import com.niit.shoppingcart.domain.OrderTable;

@Repository("orderTableDAO")
@Transactional
public class OrderTableDAOImpl implements OrderTableDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public OrderTableDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean save(OrderTable orderTable) {
		try {
			sessionFactory.getCurrentSession().save(orderTable);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<OrderTable> list(String userId) {
		
		return  sessionFactory.getCurrentSession().createQuery("from OrderTable where user_id=?").setString(0, userId).list();

	}

}
