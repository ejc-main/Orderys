package com.revature.orderys.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Rating;
import com.revature.orderys.util.ConnectionUtil;
import com.revature.orderys.util.EasyLogger;

@Transactional
public class RatingDaoImpl implements RatingDao {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.ex.dao.DAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
  	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	@Transactional(readOnly=false)
//	public void createRating(Rating r){
//		Session s = sessionFactory.getCurrentSession();
//		s.saveOrUpdate(rating);
//	}
	
	public ArrayList<Rating> getAllRatings() {
		ArrayList<Rating> ratings = null;
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return ratings;
	}
	
	public void createRating(Rating r) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		
	}
	
	public Rating getRatingById(int id) {
		Rating r = null;
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return r;
	}
	
	public void updateRating(Rating r) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		
	}
	
	public void deleteRating(int id) {
		Session session = ConnectionUtil.getSession();
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
