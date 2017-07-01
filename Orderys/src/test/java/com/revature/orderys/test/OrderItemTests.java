package com.revature.orderys.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.OrderItem;
import com.revature.orderys.bean.OrderItemPrimaryKey;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.OrderDao;
import com.revature.orderys.dao.OrderItemDao;
import com.revature.orderys.dao.ProductDao;
import com.revature.orderys.dao.UserDao;

public class OrderItemTests {
	private AbstractApplicationContext ac;
	
	private OrderItemDao itemDao;
	private OrderDao orderDao;
	private ProductDao productDao;
	private BusinessDao businessDao;
	private UserDao userDao;
	
	private OrderItem item;
	private Order order;
	private Product product;
	private Business business;
	private User user;
	
	private Business business2;
	private Order order2;
	private User orderCompleter;
	private OrderItem item2;
	private Product product2;
	
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		itemDao = (OrderItemDao) ac.getBean("orderItemDao");
		orderDao = (OrderDao) ac.getBean("orderDao");
		productDao = (ProductDao) ac.getBean("productDao");
		businessDao = (BusinessDao) ac.getBean("businessDao");
		userDao = (UserDao) ac.getBean("userDao");
		
		user = new User();
		user.setEmail("address@email.com");
		user.setFirstName("Mary");
		user.setLastName("Berry");
		user.setPasswordHash("pwdHash");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		business = new Business();
		business.setCity("Anytown");
		business.setCountry("USA");
		business.setState("WA");
		business.setName("Burger Hut");
		business.setStreetAddress1("123 Oak Drive");
		business.setZip("12343");
		business.setManager(user);
		businessDao.createBusiness(business);
		
		product = new Product();
		product.setName("Steamed Cheeseburger");
		product.setProductPrice(new BigDecimal(4.99));
		productDao.createProduct(product);
		
		order = new Order();
		order.setPaymentMethod((short) 0);
		order.setCustomerId(user);
		orderDao.createOrder(order);
		
		item = new OrderItem();
		item.setQuantity(3);
		item.setStatus(OrderItem.Status.PENDING);
		item.setOrderedAt(business);
		item.setOrderItemKey(new OrderItemPrimaryKey(order, product));
	}

	@After
	public void tearDown() throws Exception {
		ac.close();
		ac = null;
		
		itemDao = null;
		orderDao = null;
		productDao = null;
		businessDao = null;
		userDao = null;
		
		item = null;
		order = null;
		product = null;
		business = null;
		user = null;
	}

	private void createSecondItem(Order order, Product product) {
		item2 = new OrderItem();
		item2.setQuantity(1);
		item2.setStatus(OrderItem.Status.PENDING);
		item2.setOrderedAt(business2);
		item2.setOrderItemKey(new OrderItemPrimaryKey(order, product));
		
	}
	
	private void createSecondOrder() {
		order2 = new Order();
		order2.setPaymentMethod((short) 0);
		order2.setCustomerId(user);
		orderDao.createOrder(order2);
	}
	
	private void createSecondUser() {
		orderCompleter = new User();
		orderCompleter.setEmail("address2@email.com");
		orderCompleter.setFirstName("Sue");
		orderCompleter.setLastName("Sans");
		orderCompleter.setPasswordHash("pwdHash");
		orderCompleter.setRole(User.Role.MANAGER);
		userDao.createUser(orderCompleter);
	}
	
	private void createSecondBusiness() {
		business2 = new Business();
		business2.setCity("Anytown");
		business2.setCountry("USA");
		business2.setState("WA");
		business2.setName("The Hungry Ninja's House of Stew");
		business2.setStreetAddress1("234 Oak Drive");
		business2.setZip("12343");
		business2.setManager(orderCompleter);
		businessDao.createBusiness(business2);
	}
	
	private void createSecondProduct() {
		product2 = new Product();
		product2.setName("Kobe Beef Stew");
		product2.setProductPrice(new BigDecimal(37.99));
		productDao.createProduct(product2);
	}
	
	@Test
	public void testCreateAndGetOrderItem() {
		itemDao.createOrderItem(item);
		
		order = orderDao.getOrderById(order.getId());
		product = productDao.getProductById(product.getId());
		
		OrderItemPrimaryKey newKey = new OrderItemPrimaryKey(order, product);
		
		item = itemDao.getOrderItemByKey(newKey);
		
		assertNotNull(item);
	}

	@Test
	public void testUpdateOrderItem() {
		itemDao.createOrderItem(item);
		
		String newNote = "Extra steam, please!";
		
		item.setNote(newNote);
		itemDao.updateOrderItem(item);
		
		OrderItemPrimaryKey key = new OrderItemPrimaryKey(order, product);
		item = itemDao.getOrderItemByKey(key);
		
		assertTrue(item.getNote().equals(newNote));
	}
	
	@Test
	public void testDeleteOrderItem() {
		itemDao.createOrderItem(item);
		itemDao.deleteOrderItem(item);
		
		OrderItemPrimaryKey key = new OrderItemPrimaryKey(order, product);
		
		item = itemDao.getOrderItemByKey(key);
		
		assertNull(item);
	}
	
	@Test
	public void testGetAllOrderItems() {
		itemDao.createOrderItem(item);
		createSecondOrder();
		createSecondUser();
		createSecondProduct();
		
		createSecondItem(order2, product2);
		itemDao.createOrderItem(item2);
		
		ArrayList<OrderItem> allItems = (ArrayList<OrderItem>) itemDao.getAllOrderItems();
		
		assertEquals(2, allItems.size());
	}
	
	@Test
	public void testGetAllOrderItemsByBusiness() {
		itemDao.createOrderItem(item);
		createSecondOrder();
		createSecondUser();
		createSecondProduct();
		createSecondBusiness();
		
		createSecondItem(order2, product2);
		itemDao.createOrderItem(item2);
		
		ArrayList<OrderItem> allItems = (ArrayList<OrderItem>) itemDao.getOrderItemsByBusiness(business2);
		
		assertEquals(1, allItems.size());
	}
	
	@Test
	public void testGetAllOrderItemsByOrder() {
		itemDao.createOrderItem(item);
		createSecondOrder();
		createSecondUser();
		createSecondProduct();
		createSecondBusiness();
		
		createSecondItem(order2, product2);
		itemDao.createOrderItem(item2);
		
		ArrayList<OrderItem> allItems =(ArrayList<OrderItem>) itemDao.getOrderItemsByOrder(order2);
		
		assertEquals(1, allItems.size());
	}
	
	@Test
	public void testGetAllOrderItemsByOrderCompleter() {
		item.setCompletedBy(user);
		itemDao.createOrderItem(item);
		
		createSecondOrder();
		createSecondUser();
		createSecondProduct();
		createSecondBusiness();
		
		createSecondItem(order2, product2);
		itemDao.createOrderItem(item2);
		
		ArrayList<OrderItem> allItems = (ArrayList<OrderItem>) itemDao.getOrderItemByEmployee(user);
		
		assertEquals(1, allItems.size());
	}
}
