package com.revature.orderys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.User;
import com.revature.orderys.util.EasyLogger;

@Transactional
public class UserDaoImpl {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.getCurrentSession();
		try {
			users = (List<User>) session.createCriteria(User.class).list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return users;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createUser(User u) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(u);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public User getUserById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class,id);
	}
	
	public void updateUser(User u) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(u);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public void deleteUser(User u) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(u);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

}
