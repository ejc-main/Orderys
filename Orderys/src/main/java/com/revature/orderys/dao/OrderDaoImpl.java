package com.revature.orderys.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.orderys.bean.Order;
import com.revature.orderys.util.ConnectionUtil;
import com.revature.orderys.util.EasyLogger;

public class OrderDaoImpl {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.ex.dao.DAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = null;
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return orders;
	}
	
	public void createOrder(Order o) {
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
	
	public Order getOrderById(int id) {
		Order o = null;
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException ex) {
			logger.catching(ex);
		} finally {
			session.close();
		}
		return o;
	}
	
	public void updateOrder(Order o) {
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
	
	public void deleteOrder(int id) {
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
