package com.revature.orderys.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;

public class BusinessDaoTests {

	@Test
	public void testCreateBusiness() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BusinessDao businessDao = (BusinessDao) ac.getBean("businessDao");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		Business business = new Business();
		business.setName("name");
		business.setCity("anywhere");
		business.setCountry("usa");
		business.setState("wa");
		business.setStreetAddress1("123 Some Drive");
		business.setZip("12344");
		business.setManager(user);
		
		Business copy = new Business();
		copy.setName(business.getName());
		copy.setCity(business.getCity());
		copy.setCountry(business.getCountry());
		copy.setState(business.getState());
		copy.setStreetAddress1(business.getStreetAddress1());
		copy.setZip(business.getZip());
		copy.setManager(business.getManager());
		
		businessDao.createBusiness(business);
		copy.setId(business.getId());
		
		assertTrue(haveSamePropertyValues(copy, business));
	}

	private boolean haveSamePropertyValues(Business expected, Business actual) {
		boolean result = true;
		
		if(expected.getId() != actual.getId()) {
			result = false;
		}
		if(!expected.getCity().equals(actual.getCity())) {
			result = false;
		}
		if(!expected.getCountry().equals(actual.getCountry())) {
			result = false;
		}
		if(expected.getManager().getId() != actual.getManager().getId()) {
			result = false;
		}
		if(!expected.getName().equals(actual.getName())) {
			result = false;
		}
		if(!expected.getStreetAddress1().equals(actual.getStreetAddress1())) {
			result = false;
		}
		if(!expected.getZip().equals(actual.getZip())) {
			result = false;
		}
		
		return result;
	}
	
	@Test
	public void testGetBusinessById() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BusinessDao businessDao = (BusinessDao) ac.getBean("businessDao");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		Business business = new Business();
		business.setName("name");
		business.setCity("anywhere");
		business.setCountry("usa");
		business.setState("wa");
		business.setStreetAddress1("123 Some Drive");
		business.setZip("12344");
		business.setManager(user);
		
		businessDao.createBusiness(business);
		
		business = businessDao.getBusinessById(business.getId());
		
		assertNotNull(business);
	}
	
	// TODO: Write test for getBusinessByManager when that method is implemented
	
	@Test
	public void testUpdateBusiness() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BusinessDao businessDao = (BusinessDao) ac.getBean("businessDao");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		Business business = new Business();
		business.setName("name");
		business.setCity("anywhere");
		business.setCountry("usa");
		business.setState("wa");
		business.setStreetAddress1("123 Some Drive");
		business.setZip("12344");
		business.setManager(user);
		
		businessDao.createBusiness(business);
		
		String newName = "Updated business name";
		business.setName(newName);
		
		businessDao.updateBusiness(business);
		business = businessDao.getBusinessById(business.getId());
		
		assertTrue(business.getName().equals(newName));
	}
	
	@Test
	public void testGetAllBusinesses() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BusinessDao businessDao = (BusinessDao) ac.getBean("businessDao");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		Business business1 = new Business();
		business1.setName("name");
		business1.setCity("anywhere");
		business1.setCountry("usa");
		business1.setState("wa");
		business1.setStreetAddress1("123 Some Drive");
		business1.setZip("12344");
		business1.setManager(user);
		
		businessDao.createBusiness(business1);
		
		User user2 = new User();
		user2.setEmail("a2@b.com");
		user2.setPasswordHash("hash");
		user2.setFirstName("first");
		user2.setLastName("last");
		user2.setRole(User.Role.MANAGER);
		userDao.createUser(user2);
		
		Business business2 = new Business();
		business2.setName("name");
		business2.setCity("anywhere");
		business2.setCountry("usa");
		business2.setState("wa");
		business2.setStreetAddress1("123 Some Drive");
		business2.setZip("12344");
		business2.setManager(user2);
		
		businessDao.createBusiness(business2);
		
		ArrayList<Business> allBusinesses = (ArrayList<Business>) businessDao.getAllBusinesses();
		
		assertEquals(2, allBusinesses.size());
	}
	
	@Test
	public void testDeleteBusiness() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BusinessDao businessDao = (BusinessDao) ac.getBean("businessDao");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		Business business = new Business();
		business.setName("name");
		business.setCity("anywhere");
		business.setCountry("usa");
		business.setState("wa");
		business.setStreetAddress1("123 Some Drive");
		business.setZip("12344");
		business.setManager(user);
		
		businessDao.createBusiness(business);
		
		long id = business.getId();
		businessDao.deleteBusiness(business);
		
		business = businessDao.getBusinessById(id);
		
		assertTrue(business == null);
	}
}
