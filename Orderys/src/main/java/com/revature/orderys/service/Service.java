package com.revature.orderys.service;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.OrderItem;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.dao.BusinessDao;
import com.revature.orderys.dao.OrderDao;
import com.revature.orderys.dao.OrderItemDao;
import com.revature.orderys.dao.ProductDao;
import com.revature.orderys.dao.StationDao;
import com.revature.orderys.dao.UserDao;
import com.revature.orderys.exceptions.EmailNotUniqueException;
import com.revature.orderys.exceptions.InvalidCredentialsException;

@Component
public class Service implements Serializable {
	private static final long serialVersionUID = -5447849598788494638L;
	
	private BusinessDao BDao;
	private UserDao UDao;
	private ProductDao productDao;
	private StationDao SDao;
	private OrderDao ODao;
	private OrderItemDao OIDao;
	
	public Service() {
		super();
	}
	
	public void setBDao(BusinessDao bDao) {
		this.BDao = bDao;
	}
	
	public void setUDao(UserDao uDao) {
		this.UDao = uDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void setSDao(StationDao sDao) {
		this.SDao = sDao;
	}
	
	public void setODao(OrderDao orderDao) {
		this.ODao = orderDao;
	}
	
	public void setOIDao(OrderItemDao orderItemDao) {
		this.OIDao = orderItemDao;
	}
	
	// Begin User Services
	
	// TODO: Untested
	public User addNewUser(User user) throws EmailNotUniqueException {	
		if(UDao.getUserByEmail(user.getEmail()) == null) {
			user.setRole(User.Role.CUSTOMER);
			UDao.createUser(user);
			return user;
		}
		else {
			throw new EmailNotUniqueException("A user with email address "
					+ user.getEmail() + " already exists...");
		}
	}
	
	// TODO: Untested
	public User addNewUser(String email,String password,String firstName, String lastName) throws EmailNotUniqueException {		
		if(UDao.getUserByEmail(email) == null) {
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			User user = new User();
			user.setRole(User.Role.CUSTOMER);
<<<<<<< HEAD
			user.setEmail(email);
			user.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt()));
			user.setFirstName(firstName);
			user.setLastName(lastName);
=======
			user.setEmail(email.trim());
			user.setPasswordHash(passwordHash);
			user.setFirstName(firstName.trim());
			user.setLastName(lastName.trim());
>>>>>>> 97eada57208ba68328fe86e4367d8ae00c5c70d4
			UDao.createUser(user);
	
			return user;
		}
		else {
			throw new EmailNotUniqueException("A user with email address "
					+ email.trim() + " already exists...");
		}
	}
	
	// TODO: Untested
	public User updateUser(User user) {
		UDao.updateUser(user);
		
		return user;
	}
	
	// TODO: Untested
	public User loginUser(User user) throws InvalidCredentialsException {
		User u = UDao.getUserByEmail(user.getEmail());
		
		if(u.getPasswordHash().equals(user.getPasswordHash())) {
			return u;
		}
		else {
			throw new InvalidCredentialsException("User entered incorrect email or password.");
		}
	}
	
	// TODO: Untested
	public User loginUser(String email, String password) throws InvalidCredentialsException {
		User u = UDao.getUserByEmail(email.trim());
		
		if (BCrypt.checkpw(password, u.getPasswordHash())) {
			return u;
		}
		else {
			throw new InvalidCredentialsException("User entered incorrect email or password.");
		}
	}
	
	// TODO; Untested
	public List<Business> getAllBusinesses() {
		return BDao.getAllBusinesses();
	}
	
	// TODO: Untested
	public List<Product> getMenu(Business business) {
		return productDao.getAllProductsByBusiness(business);
	}
	
	// TODO: Untested
	public List<Order> getAllUserOrders(User user) {
		return ODao.getOrdersByCustomer(user);
	}
	
	public Order placeOrder(Order order) {
		ODao.createOrder(order);
		return order;
	}
	
	// End User Services
	
	// Start Business Services:
	
	// TODO: Untested
	// TODO: Implement some types of checks on business.
	public Business registerBusiness(Business business) {
		BDao.createBusiness(business);
		return business;
	}
	
	// TODO: Untested
	// TODO: Implement necessary checks on product; throw errors.
	public Product addMenuItem(Product product) {
		productDao.createProduct(product);
		return product;
	}
	
	// TODO: Untested
	// TODO: Implement necessary checks on product and throw exceptions
	public Product updateMenuItem(Product product) {
		productDao.updateProduct(product);
		return product;
	}
	
	// TODO: Untested
	// TODO: Implement necessary checks and throw errors.
	public List<OrderItem> viewActiveOrderItems(Business business) {
		return OIDao.getOrderItemsByStatus(business, OrderItem.Status.ACTIVE);
	}
	
	// TODO: Untested
	// TODO: Implement necessary checks and throw exceptions
	public OrderItem updateOrderItem(OrderItem orderItem) {
		OIDao.updateOrderItem(orderItem);
		return orderItem;
	}
	
	// TODO: Untested
	// TODO: Implement necessary checks and throw exceptions
	public Station createStation(Station station) {
		SDao.createStation(station);
		return station;
	}
	// End Business Services
	
	
	
	
	// TODO: Triage
	// Start old code:
	
	public User getUserById(long id){
		User u=UDao.getUserById(id);
		System.out.println(u.toString());
		return u;
	}
	
	// TODO: Remove?
	public int getNum(){
		return 2;
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
