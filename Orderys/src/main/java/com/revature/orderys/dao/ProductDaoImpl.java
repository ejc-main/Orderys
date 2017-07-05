package com.revature.orderys.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Product;
import com.revature.orderys.util.EasyLogger;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5173102510745286323L;
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;



	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		Session session = sessionFactory.getCurrentSession();
		try {
			products = (List<Product>) session.createQuery("from Product").list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return products;
	}

	// TODO: Untested
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllProductsByBusiness(Business business) {
		List<Product> products = new ArrayList<Product>();
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from Product p where p.station.business.id = :businessId");
			query.setLong("businessId", business.getId());
			products = (ArrayList<Product>) query.list();
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return products;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createProduct(Product p) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(p);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
		

	@Override
	public Product getProductById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Product) session.get(Product.class,id);
	}


	@Override
	public void updateProduct(Product p) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(p);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}


	@Override
	public void deleteProduct(Product p) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(p);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

}
