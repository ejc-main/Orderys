package com.revature.orderys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.User;
import com.revature.orderys.util.EasyLogger;

@Transactional
public class OrderDaoImpl {
	
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		Session session = sessionFactory.getCurrentSession();
		try {
			orders = (List<Order>) session.createCriteria(Order.class).list();
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return orders;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void createOrder(Order o) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(o);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public Order getOrderById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Order) session.get(Order.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrdersByCustomer(User c) {
		List<Order> orders = new ArrayList<Order>();
		Session session = sessionFactory.getCurrentSession();
		try {
			orders = (List<Order>) session.createCriteria(User.class)
					.add(Restrictions.eq("user.id", c.getId())).list();
			
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
		return orders;
	}
	
	public List<Order> getOrdersByBusiness(Business b) {
		return null;
	}
	
	// TODO add methods for OrderItems
	// TODO add getOrderItemsByStation
	// TODO add getOrderItemsByOrder
	// TODO add getOrderItemsByProduct
	
	public void updateOrder(Order o) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(o);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}
	
	public void deleteOrder(Order o) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(o);
		} catch (HibernateException ex) {
			logger.catching(ex);
		}
	}

}
