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

import com.revature.orderys.bean.Rating;
import com.revature.orderys.util.EasyLogger;

@Transactional
@Repository
public class RatingDaoImpl implements RatingDao,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7389265332017457536L;
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Rating> getAllRatings() {
		List<Rating> ratings = new ArrayList<Rating>();
		Session session = sessionFactory.getCurrentSession();
		try {
			ratings = (List<Rating>) session.createQuery("from Rating").list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return ratings;
	}
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createRating(Rating r) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(r);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	@Override
	public Rating getRatingById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Rating) session.get(Rating.class,id);
	}
	
	@Override
	public void updateRating(Rating r) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(r);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	@Override
	public void deleteRating(Rating r) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(r);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
}
