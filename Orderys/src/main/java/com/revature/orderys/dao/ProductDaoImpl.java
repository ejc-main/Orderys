package com.revature.orderys.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.Station;
import com.revature.orderys.util.EasyLogger;

@Transactional
public class ProductDaoImpl {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		List<Product> products = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			products = (List<Product>) session.createCriteria(Product.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return products;
	}
	
	public void createProduct(Product p) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		
	}
	
	public Product getProductById(int id) {
		Product p = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return p;
	}
	
	public List<Product> getProductsByBusiness(Business b) {
		List<Product> products = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return products;
	}
	
	public List<Product> getProductsByStation(Station s) {
		List<Product> products = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return products;
	}
	
	public List<Product> getProductsByOrder(Station s) {
		List<Product> products = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return products;
	}
	
	public void updateProduct() {
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
	
	public void deleteProduct(int id) {
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
