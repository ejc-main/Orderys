package com.revature.orderys.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.User;
import com.revature.orderys.util.EasyLogger;

@Transactional
@Repository
public class BusinessDaoImpl implements BusinessDao, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6135498789649615155L;
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;
	
	
	public BusinessDaoImpl() {
		super();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@Override
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
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createBusiness(Business b) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(b);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	@Override
	public Business getBusinessById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Business) session.get(Business.class,id);
	}
	
	@Override
	public Business getBusinessByManager(User m) {
		return null;
	}
	
	@Override
	public void updateBusiness(Business b) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(b);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	@Override
	public void deleteBusiness(Business b) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(b);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
}
