package com.niit.usermodule.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.usermodule.dao.UserDAO;
import com.niit.usermodule.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean save(User user) {
		log.debug("Starting of save method");
		try {
			log.debug("Starting of save method");
			getCurrentSession().save(user);
		} catch (Exception e) {
			log.debug("Exception Arised! Now in save method Exception Handling");
			e.printStackTrace();
			log.debug("End of save method Exception Handling");
			return false;
		}
		log.debug("End of save method! Save success.");
		return true;
	}

	public boolean update(User user) {
		log.debug("Starting of update method");
		try {
			log.debug("Starting of update method");
			getCurrentSession().update(user);
		} catch (Exception e) {
			log.debug("Exception Arised! Now in update method Exception Handling");
			e.printStackTrace();
			log.debug("End of update method Exception Handling");
			return false;
		}
		log.debug("End of update method! update success.");
		return true;
	}

	public boolean validate(String id, String password) {
		log.debug("Starting of validate method");
		log.debug("Creating query in validate method");
		Query query = getCurrentSession().createQuery(" from User where id = ? and password = ?");
		query.setString(0, id);
		query.setString(1, password);
		log.debug("End of creating query in validate method");

		if (query.uniqueResult() == null) {
			log.debug("User Not available in DB");
			return false;
		} else {
			log.debug("Ending of validate method");
			return true;
		}

	}

	public List<User> list() {
		log.debug("Initiating User list method");
		return getCurrentSession().createQuery("from User").list();
	}

	public User get(String id) {
		log.debug("Initiating User get user by id method");
		return (User) getCurrentSession().get(User.class, id);
	}

	public boolean delete(String id) {
		log.debug("Starting of delete user method");
		try {
			log.debug("Deleting user");
			User user = get(id);
			getCurrentSession().delete(user);
			log.debug("User Deleted");
		} catch (Exception e) {
			log.debug("Exception arised");
			e.printStackTrace();
			return false;
		}
		log.debug("Ending of delete user method");
		return true;
	}

}
