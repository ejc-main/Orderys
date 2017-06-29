package com.revature.orderys.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.OrderDao;
import com.revature.orderys.dao.UserDao;

public class OrderDaoTests {

	@Test
	public void testCreateOrder() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		
		Order order = new Order();
		order.setCustomerId(user);
		order.setPaymentMethod((short)0);
		
		Order copy = new Order();
		copy.setCustomerId(order.getCustomer());
		copy.setPaymentMethod(order.getPaymentMethod());
		
		orderDao.createOrder(order);
		copy.setId(order.getId());
		
		assertTrue(haveSamePropertyValues(copy, order));
	}
	
	private static boolean haveSamePropertyValues(Order expected, Order actual) {
		boolean result = true;
		
		if(expected.getId() != actual.getId()) {
			result = false;
		}
		if(expected.getCustomer().getId() != actual.getCustomer().getId()) {
			result = false;
		}
		if(expected.getPaymentMethod() != actual.getPaymentMethod()) {
			result = false;
		}
		
		return result;
	}
	
	@Test
	public void testGetOrderById() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		
		Order order = new Order();
		order.setCustomerId(user);
		order.setPaymentMethod((short)0);
		
		orderDao.createOrder(order);
		
		order = orderDao.getOrderById(order.getId());
		
		assertNotNull(order);
	}
	
	// TODO: Test getOrdersByBusiness method once it is implemented.
	
	@Test
	public void testGetOrdersByCustomer() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		
		Order order1 = new Order();
		order1.setCustomerId(user);
		order1.setPaymentMethod((short)0);
		
		orderDao.createOrder(order1);
		
		Order order2 = new Order();
		order2.setCustomerId(user);
		order2.setPaymentMethod((short) 1);
		
		orderDao.createOrder(order2);
		
		User user2 = new User();
		user.setEmail("aa@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		ArrayList<Order> allOrders = (ArrayList<Order>) orderDao.getOrdersByCustomer(user);
		
		assertEquals(2, allOrders.size());
	}
	
	@Test
	public void testGetAllOrders() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		
		Order order1 = new Order();
		order1.setCustomerId(user);
		order1.setPaymentMethod((short)0);
		
		orderDao.createOrder(order1);
		
		Order order2 = new Order();
		order2.setCustomerId(user);
		order2.setPaymentMethod((short) 1);
		
		orderDao.createOrder(order2);
		
		ArrayList<Order> allOrders = (ArrayList<Order>) orderDao.getOrdersByCustomer(user);
		
		assertEquals(2, allOrders.size());
	}
	
	@Test
	public void testUpdateOrder() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		
		Order order = new Order();
		order.setCustomerId(user);
		order.setPaymentMethod((short)0);
		
		orderDao.createOrder(order);
		
		short newPaymentMethod = 3;
		order.setPaymentMethod(newPaymentMethod);
		
		orderDao.updateOrder(order);
		order = orderDao.getOrderById(order.getId());
		
		assertTrue(order.getPaymentMethod() == newPaymentMethod);
	}
	
	@Test
	public void testDeleteOrder() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		
		Order order = new Order();
		order.setCustomerId(user);
		order.setPaymentMethod((short)0);
		
		orderDao.createOrder(order);
		
		long id = order.getId();
		
		orderDao.deleteOrder(order);
		
		order = orderDao.getOrderById(id);
		
		assertNull(order);
	}
}
