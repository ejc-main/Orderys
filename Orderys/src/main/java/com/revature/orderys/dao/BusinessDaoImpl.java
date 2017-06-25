package com.revature.orderys.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.User;
import com.revature.orderys.util.ConnectionUtil;
import com.revature.orderys.util.EasyLogger;

public class BusinessDaoImpl {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	public ArrayList<User> getAllBusinesses() {
		ArrayList<User> businesses = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return businesses;
	}
	
	public void createBusiness(User u) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		
	}
	
	public Business getBusinessById(int id) {
		Business b = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return b;
	}
	
	public Business getBusinessByManager(User m) {
		Business b = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return b;
	}
	
	public void updateBusiness(Business b) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		
	}
	
	public void deleteBusiness(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		
	}

}
