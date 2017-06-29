package com.revature.orderys.test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;

public class StationDaoTests {
	
	private AbstractApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("beans.xml");
	}

	@After
	public void tearDown() throws Exception {
		ac.close();
		ac = null;
	}

	@Test
	public void test() {
		StationDao stationDao = (StationDao) ac.getBean("stationDao");
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
		business.setName("testbiz");
		business.setCity("anywhere");
		business.setCountry("usa");
		business.setState("wa");
		business.setStreetAddress1("123 Some Drive");
		business.setZip("12344");
		business.setManager(user);
		
		businessDao.createBusiness(business);
		
		Station station = new Station();
		station.setStationName("Default");
		station.setBusiness(business);
		
		Station copy = new Station();
		copy.setStationName(station.getStationName());
		copy.setBusiness(station.getBusiness());
		
		stationDao.createStation(station);
		copy.setId(station.getId());
		
		assertTrue(haveSamePropertyValues(copy, station));
		
	}

	private boolean haveSamePropertyValues(Station expected, Station actual) {
		boolean result = true;
		
		if(expected.getId() != actual.getId()) {
			result = false;
		}
		if(expected.getBusiness().getId() != actual.getBusiness().getId()) {
			result = false;
		}
		if(!expected.getStationName().equals(actual.getStationName())) {
			result = false;
		}
		
		return result;
		
		
	}
	
	@Test
	public void testGetStationById() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StationDao stationDao = (StationDao) ac.getBean("stationDao");
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
		
		Station station = new Station();
		station.setStationName("Default");
		station.setBusiness(business);
		stationDao.createStation(station);
		
		station = stationDao.getStationById(station.getId());
		
		assertNotNull(station);
	}
	
	@Test
	public void testUpdateStation() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StationDao stationDao = (StationDao) ac.getBean("stationDao");
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
		
		Station station = new Station();
		station.setStationName("Default");
		station.setBusiness(business);
		
		stationDao.createStation(station);
		
		String newName = "New station name";
		station.setStationName(newName);
		
		stationDao.updateStation(station);
		station = stationDao.getStationById(station.getId());
		
		assertTrue(station.getStationName().equals(newName));
	}
	
	@Test
	public void testDeleteStation() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StationDao stationDao = (StationDao) ac.getBean("stationDao");
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
		
		Station station = new Station();
		station.setStationName("Default");
		station.setBusiness(business);
		
		assertTrue(station != null);
		
		stationDao.createStation(station);
		station = stationDao.getStationById(station.getId());
		long id = station.getId();
		
		stationDao.deleteStation(station);
		
		station = stationDao.getStationById(id);
		
		assertTrue(station == null);
	}
	
	@Test
	public void testGetAllStations() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StationDao stationDao = (StationDao) ac.getBean("stationDao");
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

		Station station1 = new Station();
		station1.setStationName("Station 1");
		station1.setBusiness(business);
		
		stationDao.createStation(station1);

		Station station2 = new Station();
		station2.setStationName("Station 2");
		station2.setBusiness(business);

		stationDao.createStation(station2);
		
		Station station3 = new Station();
		station3.setStationName("Station 3");
		station3.setBusiness(business);
		
		stationDao.createStation(station3);
		
		ArrayList<Station> allStations = (ArrayList<Station>) stationDao.getAllStations();
		
		assertEquals(3, allStations.size());
	}
}
