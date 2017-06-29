package com.revature.orderys.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.orderys.bean.User;
import com.revature.orderys.dao.UserDao;

import junit.framework.TestCase;

@Transactional
public class UserDaoTests /*extends TestCase */{

	
	@Test
	public static void testCreateUser() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		User copy = new User();
		copy.setEmail(user.getEmail());
		copy.setPasswordHash(user.getPasswordHash());
		copy.setFirstName(user.getFirstName());
		copy.setLastName(user.getLastName());
		copy.setRole(user.getRole());
		
		userDao.createUser(user);
		
		user = userDao.getUserById(1);
		copy.setId(user.getId());
		copy.setEmployeeStations(user.getEmployeeStations());
		copy.setOrders(user.getOrders());
		copy.setRatings(user.getRatings());
		
		assertTrue(haveSamePropertyValues(copy, user));
	}
	
	private static boolean haveSamePropertyValues(User expected, User actual) {
		boolean result = true;
		
		if(expected.getId() != actual.getId()) {
			result = false;
		}
		if(!expected.getEmail().equals(actual.getEmail())) {
			result = false;
		}
		if(!expected.getFirstName().equals(actual.getFirstName())) {
			result = false;
		}
		if(!expected.getLastName().equals(actual.getLastName())) {
			result = false;
		}
		if(!expected.getPasswordHash().equals(actual.getPasswordHash())){
			result = false;
		}
		if(!expected.getRole().equals(actual.getRole())) {
			result = false;
		}
		if(!expected.getOrders().equals(actual.getOrders())) {
			result = false;
		}
		if(!expected.getRatings().equals(actual.getRatings())) {
			result = false;
		}
		if(!expected.getEmployeeStations().equals(actual.getEmployeeStations())) {
			result = false;
		}
		
		return result;
	}
	
	@Test
	public static void testGetUserById() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User(1, "a@b.com", "hash", "First", "Last", User.Role.CUSTOMER);
		userDao.createUser(user);
		user = userDao.getUserById(user.getId());
		
		assertNotNull(user);
	}
	
	@Test
	public static void testGetAllUsers() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		
		User user2 = user;
		user2.setEmail("Fake@email.com");
		
		userDao.createUser(user2);
		
		User user3 = user;
		user3.setEmail("dsaff@lk.com");
		
		userDao.createUser(user3);
		ArrayList<User> users = (ArrayList<User>) userDao.getAllUsers();
		
		assertEquals(3, users.size());
	}
	
	@Test
	public static void testUpdateUser() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);		
		String email = "newEmail@something.com";
		user.setEmail(email);
		
		userDao.updateUser(user);
		user = userDao.getUserById(user.getId());
		
		assertTrue(email.equals(user.getEmail()));
	}
	
	@Test
	public static void testDeleteUser() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.CUSTOMER);
		
		userDao.createUser(user);
		userDao.deleteUser(user);
		user = userDao.getUserById(user.getId());
		
		assertTrue(user == null);
	}
}
