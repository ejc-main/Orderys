package com.revature.orderys.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;

@org.springframework.stereotype.Service
public class Service {
	
	
	public User getUserById(long id){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao uDao = (UserDao) ac.getBean("userDao");
		return uDao.getUserById(id);
	}
	public User loginUser(String email,String passwordHash){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao uDao = (UserDao) ac.getBean("userDao");
		User u = uDao.getUserByEmail(email);
		if(u.getPasswordHash().equals(passwordHash)){
			return u;
		}else{
			return null;
		}
		
	}
	public void addNewUser(String email,String passwordHash,String firstName, String lastName, String role){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao uDao = (UserDao) ac.getBean("userDao");
		User u = new User();
		u.setEmail(email);
		u.setPasswordHash(passwordHash);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setRole(User.Role.valueOf(role));
		uDao.createUser(u);
		System.out.println("hi2");
	}
	public void changeUserPassword(String email,String passwordHash){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao uDao = (UserDao) ac.getBean("userDao");
		User u = uDao.getUserByEmail(email);
		u.setPasswordHash(passwordHash);
		uDao.updateUser(u);
	}
	public void addNewBusiness(String email,String businessName,String city,String country,String state,String streetAddress1,String streetAddress2,String zip){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BusinessDao bDao = (BusinessDao) ac.getBean("businessDao");
		UserDao uDao = (UserDao) ac.getBean("userDao");
		StationDao sDao = (StationDao) ac.getBean("stationDao");
		User u = uDao.getUserByEmail(email);
		Business b = new Business();
		b.setManager(u);
		b.setName(businessName);
		b.setCity(city);
		b.setCountry(country);
		b.setState(state);
		b.setStreetAddress1(streetAddress1);
		b.setZip(zip);
		Station s = new Station();
		s.setBusiness(b);
		s.setStationName("default");
		sDao.createStation(s);
		ArrayList<Station> stations=(ArrayList<Station>)sDao.getAllStationsByBusiness(b);
		b.setStations(stations);
		if(streetAddress2!=null){
			b.setStreetAddress2(streetAddress2);
		}
		bDao.createBusiness(b);
	}
	public void addNewMenuItem(String managerEmail,String stationName,String name, double price,long time,String description){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BusinessDao bDao = (BusinessDao) ac.getBean("businessDao");
		UserDao uDao = (UserDao) ac.getBean("userDao");
		StationDao sDao = (StationDao) ac.getBean("stationDao");
		Product p = new Product();
		p.setDescription(description);
		//p.setIntendedCompletionTime(time);
		p.setName(name);
		BigDecimal num = new BigDecimal(price);
		p.setProductPrice(num);
		User m = uDao.getUserByEmail(managerEmail);
		Business b = bDao.getBusinessByManager(m);
		ArrayList<Station> stations=(ArrayList<Station>) sDao.getAllStationsByBusiness(b);
		Station sOut=new Station();
		Station sDefault = new Station();
		for(Station s:stations ){
			if(s.getStationName().equals(stationName)){
				sOut=s;
			}
			if(s.getStationName().equals("default")){
				sDefault=s;
			}
		}
		if(sOut.getId()!=0){
			p.setStation(sOut);
		}else{
			p.setStation(sDefault);
		}
		
	}
	public static void main(String[] args) {
		
	}
}
