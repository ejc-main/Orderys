package com.revature.orderys.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Station;
import com.revature.orderys.util.EasyLogger;

@Transactional
public class StationDaoImpl {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Station> getAllStations() {
		List<Station> stations = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			stations = (List<Station>) session.createCriteria(Station.class).list();
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return stations;
	}
	
	public void createStation(Station s) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(s);
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		
	}
	
	public Station getStationById(int id) {
		Station s = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return s;
	}
	
	public void updateStation(Station s) {
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
	
	public void deleteStation(int id) {
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
