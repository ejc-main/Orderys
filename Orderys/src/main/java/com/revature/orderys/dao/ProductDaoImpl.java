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
import com.revature.orderys.bean.Station;
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



	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	

	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#getAllProducts()
	 */
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
	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#getAllProductsByBusiness(com.revature.orderys.bean.Business)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllProductsByBusiness(Business business) {
		List<Product> products = new ArrayList<Product>();
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from Product p, Station s where p.station=s and s.business.id=:businessId");
			query.setLong("businessId", business.getId());
			products = (List<Product>) query.list();
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return products;
	}
	
	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#getProductsByStation(com.revature.orderys.bean.Station)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByStation(Station station) {
		List<Product> products = new ArrayList<Product>();
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from Product p where p.station.id=:stationId");
			query.setLong("stationId", station.getId());
			products = (List<Product>) query.list();
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return products;
	}

	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#createProduct(com.revature.orderys.bean.Product)
	 */
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
		

	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#getProductById(long)
	 */
	@Override
	public Product getProductById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Product) session.get(Product.class,id);
	}


	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#updateProduct(com.revature.orderys.bean.Product)
	 */
	@Override
	public void updateProduct(Product p) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(p);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}


	/* (non-Javadoc)
	 * @see com.revature.orderys.dao.ProductDao#deleteProduct(com.revature.orderys.bean.Product)
	 */
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
