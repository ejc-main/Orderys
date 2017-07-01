package com.revature.orderys.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.UserDao;

public class BusinessDaoTests {
	private AbstractApplicationContext ac;
	
	private UserDao userDao;
	private BusinessDao businessDao;
	
	private User user;
	private Business business;

	@Before
	public void setUp() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		userDao = (UserDao) ac.getBean("userDao");
		businessDao = (BusinessDao) ac.getBean("businessDao");
		
		user = new User();
		user.setEmail("fake.email@fraudulent.com");
		user.setPasswordHash("pwdhash");
		user.setFirstName("Frank");
		user.setLastName("Banks");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		business = new Business();
		business.setName("Frank's House of Franks");
		business.setCity("White Oaks");
		business.setCountry("USA");
		business.setState("WA");
		business.setStreetAddress1("123 Lily Circle");
		business.setZip("12344");
		business.setManager(user);
	}
	
	@After
	public void tearDown() {
		ac.close();
		ac = null;
		
		userDao = null;
		businessDao = null;
		
		user = null;
		business = null;
	}
	
	@Test
	public void testCreateAndGetBusiness() {		
		businessDao.createBusiness(business);
		
		long id = business.getId();
		business = businessDao.getBusinessById(id);
		
		assertNotNull(business);
	}

	// TODO: Write test for getBusinessByManager when that method is implemented
	
	@Test
	public void testUpdateBusiness() {		
		businessDao.createBusiness(business);
		
		String newName = "China Star";
		business.setName(newName);
		
		businessDao.updateBusiness(business);
		business = businessDao.getBusinessById(business.getId());
		
		assertTrue(business.getName().equals(newName));
	}
	
	@Test
	public void testGetAllBusinesses() {
		businessDao.createBusiness(business);
		
		User user2 = new User();
		user2.setEmail("management@business.com");
		user2.setPasswordHash("hash");
		user2.setFirstName("Sue");
		user2.setLastName("Lu");
		user2.setRole(User.Role.MANAGER);
		userDao.createUser(user2);
		
		Business business2 = new Business();
		business2.setName("Salty Susan's Hot Dog Shack");
		business2.setCity("Gemfield");
		business2.setCountry("USA");
		business2.setState("CO");
		business2.setStreetAddress1("1273 SW Industrial Way");
		business2.setZip("12432");
		business2.setManager(user2);
		
		businessDao.createBusiness(business2);
		
		ArrayList<Business> allBusinesses = (ArrayList<Business>) businessDao.getAllBusinesses();
		
		assertEquals(2, allBusinesses.size());
	}
	
	@Test
	public void testDeleteBusiness() {		
		businessDao.createBusiness(business);
		
		long id = business.getId();
		businessDao.deleteBusiness(business);
		
		business = businessDao.getBusinessById(id);
		
		assertTrue(business == null);
	}
}
