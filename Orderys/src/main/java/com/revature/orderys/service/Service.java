package com.revature.orderys.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.BusinessDaoImpl;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.StationDaoImpl;
import com.revature.orderys.dao.UserDao;
import com.revature.orderys.dao.UserDaoImpl;

public class Service {
	private UserDao uDao = new UserDaoImpl();
	private BusinessDao bDao = new BusinessDaoImpl();
	private StationDao sDao = new StationDaoImpl();
	
	public User getUserById(long id){
		return uDao.getUserById(id);
	}
	public User loginUser(String email,String passwordHash){
		User u = uDao.getUserByEmail(email);
		if(u.getPasswordHash().equals(passwordHash)){
			return u;
		}else{
			return null;
		}
	}
	public void addNewUser(String email,String passwordHash,String firstName, String lastName, String role){
		User u = new User();
		u.setEmail(email);
		u.setPasswordHash(passwordHash);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setRole(User.Role.valueOf(role));
	}
	public void changeUserPassword(String email,String passwordHash){
		User u = uDao.getUserByEmail(email);
		u.setPasswordHash(passwordHash);
		uDao.updateUser(u);
	}
	public void addNewBusiness(String email,String businessName,String city,String country,String state,String streetAddress1,String streetAddress2,String zip){
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
}
