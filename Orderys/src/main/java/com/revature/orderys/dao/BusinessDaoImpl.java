package com.revature.orderys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.User;
import com.revature.orderys.util.EasyLogger;

@Transactional
public class BusinessDaoImpl {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Business> getAllBusinesses() {
		List<Business> businesses = new ArrayList<Business>();
		Session session = sessionFactory.getCurrentSession();
		try {
			businesses = (List<Business>) session.createCriteria(Business.class).list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return businesses;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createBusiness(Business b) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(b);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public Business getBusinessById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Business) session.get(Business.class,id);
	}
	
	public Business getBusinessByManager(User m) {
		return null;
	}
	
	public void updateBusiness(Business b) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(b);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public void deleteBusiness(Business b) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(b);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

}
