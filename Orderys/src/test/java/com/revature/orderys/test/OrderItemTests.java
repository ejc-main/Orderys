package com.revature.orderys.test;

import java.math.BigDecimal;

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

	@Test
	public void testCreateAndGetOrderItem() {
		itemDao.createOrderItem(item);
	}

}
