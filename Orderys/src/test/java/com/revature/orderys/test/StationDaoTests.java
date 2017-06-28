package com.revature.orderys.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDaoImpl;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;

public class StationDaoTests {

	@Test
	public void test() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StationDao stationDao = (StationDao) ac.getBean("stationDao");
		BusinessDaoImpl businessDao = (BusinessDaoImpl) ac.getBean("businessDao");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = new User();
		user.setEmail("a@b.com");
		user.setPasswordHash("hash");
		user.setFirstName("first");
		user.setLastName("last");
		user.setRole(User.Role.MANAGER);
		userDao.createUser(user);
		
		Business business = new Business();
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

	private static boolean haveSamePropertyValues(Station expected, Station actual) {
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
}
