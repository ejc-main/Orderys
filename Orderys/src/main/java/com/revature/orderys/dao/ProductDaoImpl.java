package com.revature.orderys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Product;

import com.revature.orderys.util.EasyLogger;

@Transactional
public class ProductDaoImpl implements ProductDao {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;


	@Override
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
