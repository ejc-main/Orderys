package com.revature.orderys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
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
		List<Station> stations = new ArrayList<Station>();
		Session session = sessionFactory.getCurrentSession();
		try {
			stations = (List<Station>) session.createCriteria(Station.class).list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return stations;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createStation(Station s) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(s);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public Station getStationById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Station) session.get(Station.class,id);
	}
	
	public void updateStation(Station s) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(s);
		}catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public void deleteStation(Station s) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(s);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

}
