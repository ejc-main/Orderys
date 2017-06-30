package com.revature.orderys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Station;
import com.revature.orderys.util.EasyLogger;

@Transactional
public class StationDaoImpl implements StationDao {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Station> getAllStations() {
		List<Station> stations = new ArrayList<Station>();
		Session session = sessionFactory.getCurrentSession();
		try {
			stations =(List<Station>)session.createQuery("from Station").list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return stations;
	}
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createStation(Station s) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(s);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	@Override
	public Station getStationById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Station) session.get(Station.class,id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Station> getAllStationsByBusiness(Business b) {
		List<Station> stations = new ArrayList<Station>();
		Session session = sessionFactory.getCurrentSession();
		try {
			stations = (List<Station>) session.createQuery("from Station s where s.business.id="+b.getId()).list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return stations;
	}
	
	@Override
	public void updateStation(Station s) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(s);
		}catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	@Override
	public void deleteStation(Station s) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(s);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

}
