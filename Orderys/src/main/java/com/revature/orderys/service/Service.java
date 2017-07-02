package com.revature.orderys.service;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;

@Component
public class Service implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5447849598788494638L;
	
	private BusinessDao BDao;
	private UserDao UDao;
	private StationDao SDao;
	
	
	
	
	public void setBDao(BusinessDao bDao) {
		this.BDao = bDao;
	}
	public void setUDao(UserDao uDao) {
		this.UDao = uDao;
	}
	public void setSDao(StationDao sDao) {
		this.SDao = sDao;
	}
	public Service() {
		super();
	}
	public User getUserById(long id){
		User u=UDao.getUserById(id);
		System.out.println(u.toString());
		return u;
	}
	public int getNum(){
		return 2;
	}
	public User loginUser(String email,String passwordHash){
		User u = UDao.getUserByEmail(email);
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
		u.setId(10000L);
		System.out.println(u.toString());
		UDao.createUser(u);
		System.out.println("hi2");
	}
	public void changeUserPassword(String email,String passwordHash){
		User u = UDao.getUserByEmail(email);
		u.setPasswordHash(passwordHash);
		UDao.updateUser(u);
	}
	public void addNewBusiness(String email,String businessName,String city,String country,String state,String streetAddress1,String streetAddress2,String zip){
		User u = UDao.getUserByEmail(email);
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
		SDao.createStation(s);
		ArrayList<Station> stations=(ArrayList<Station>) SDao.getAllStationsByBusiness(b);
		b.setStations(stations);
		if(streetAddress2!=null){
			b.setStreetAddress2(streetAddress2);
		}
		BDao.createBusiness(b);
	}
	public void addNewMenuItem(String managerEmail,String stationName,String name, double price,long time,String description){
		Product p = new Product();
		p.setDescription(description);
		//p.setIntendedCompletionTime(time);
		p.setName(name);
		BigDecimal num = new BigDecimal(price);
		p.setProductPrice(num);
		User m = UDao.getUserByEmail(managerEmail);
		Business b = BDao.getBusinessByManager(m);
		ArrayList<Station> stations=(ArrayList<Station>) SDao.getAllStationsByBusiness(b);
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
