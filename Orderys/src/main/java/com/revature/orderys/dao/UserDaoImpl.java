package com.revature.orderys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.User;
import com.revature.orderys.util.EasyLogger;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.getCurrentSession();
		try{
		users = (List<User>) session.createQuery("from User").list();
		}catch(HibernateException ex){
			logger.catching(ex);
		}
		
		return users;
	}
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createUser(User u) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(u);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
		
	@Override
	public User getUserById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class,id);
	}
	
	@Override
	public User getUserByEmail(String email){
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class,email);
	}

	@Override
	public void updateUser(User u) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(u);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

	@Override
	public void deleteUser(User u) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(u);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

}
