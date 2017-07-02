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

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.OrderItem;
import com.revature.orderys.bean.OrderItemPrimaryKey;
import com.revature.orderys.bean.User;
import com.revature.orderys.util.EasyLogger;

@Transactional
@Repository
public class OrderItemDaoImpl implements OrderItemDao,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 566808802376368270L;
	private EasyLogger logger = new EasyLogger();
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	}
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> getAllOrderItems() {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			orderItems = (List<OrderItem>) session	
											.createQuery("from OrderItem")
											.list();
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return orderItems;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItemsByBusiness(Business business) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			orderItems = (List<OrderItem>) session
						.createQuery("from OrderItem item where item.orderedAt.id = " + business.getId())
						.list();
					
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return orderItems;
	}
	
	// TODO: Untested
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItemsByStatus(Business business, OrderItem.Status status) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			orderItems = (List<OrderItem>) session
					.createQuery("from OrderItem oi where oi.station.business.id = "
							+ business.getId() + " and oi.status = " 
							+ status.ordinal())
					.list();
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return orderItems;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItemsByOrder(Order order) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			orderItems = (List<OrderItem>) session
						.createQuery("from OrderItem item where item.orderItemKey.order = " + order.getId())
						.list();
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return orderItems;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItemsByEmployee(User user) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			orderItems = (List<OrderItem>) session
						.createQuery("from OrderItem item where item.completedBy.id = " + user.getId())
						.list();
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
		
		return orderItems;
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void createOrderItem(OrderItem orderItem) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(orderItem);
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
	}
	
	@Override
	public OrderItem getOrderItemByKey(OrderItemPrimaryKey key) {
		Session session = sessionFactory.getCurrentSession();
		return (OrderItem) session.get(OrderItem.class, key);
	}
	
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(orderItem);
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
	}
	
	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(orderItem);
		}
		catch(HibernateException e) {
			logger.catching(e);
		}
	}
}
