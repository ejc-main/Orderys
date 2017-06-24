package com.revature.orderys.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Rating;

@Transactional
public class RatingDaoImpl implements RatingDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly=false)
	public void createRating(Rating rating){
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(rating);
	}
}
