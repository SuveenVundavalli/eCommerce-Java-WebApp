package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}


	public boolean delete(String id) {try {
		sessionFactory.getCurrentSession().delete(getSupplierById(id));
	} catch (Exception e) {
		// if any excpetion comes during execute of try block, catch will
		// excute
		e.printStackTrace();
		return false;
	}
	return true;}

	public Supplier getSupplierById(String id) {
		// get method get the date from user table based on primary key i.e., id
		// and set it to Category class
		// like select * from category where id = ?
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	public Supplier getSupplierByName(String name) {
		return 	(Supplier)  sessionFactory.getCurrentSession().createQuery("from Supplier where name = ?").setString(0, name).uniqueResult();
	}

}
