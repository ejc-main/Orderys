package com.revature.orderys.service;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
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
import com.revature.orderys.exceptions.InvalidBusinessException;
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
	
	public User addNewUser(String email,String password,String firstName, String lastName) throws EmailNotUniqueException {		
		if(UDao.getUserByEmail(email) == null) {
			User user = new User();
			user.setRole(User.Role.CUSTOMER);
			user.setEmail(email.trim());
			String hash = BCrypt.hashpw(password, BCrypt.gensalt());
			System.out.println(hash);
			user.setPasswordHash(hash);
			user.setFirstName(firstName.trim());
			user.setLastName(lastName.trim());
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
	
	public User loginUser(User user) throws InvalidCredentialsException {
		User u = UDao.getUserByEmail(user.getEmail());
		
		if(BCrypt.checkpw(user.getPasswordHash(), u.getPasswordHash())) {
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
	
	/**
	 * Creates a new business in the Orderys database. Updates role of
	 * given business's user to manager.
	 * 	
	 * @param business	The new business that will be persisted.
	 * @return			The updated business.
	 */
	
	// TODO: Untested
	// TODO: Implement some types of checks on business.
	public Business registerBusiness(Business business) throws InvalidBusinessException {		
		boolean isValidBusiness = true;
		
		String errorMessage = "";
		
		if(business.getCity() == null || business.getCity().length() == 0) {
			isValidBusiness = false;
			errorMessage += "Invalid city\n";
		}
		if(business.getCountry() == null || business.getCountry().length() == 0) {
			isValidBusiness = false;
			errorMessage += "Invalid country\n";
		}
		if(business.getName() == null || business.getName().length() == 0) {
			isValidBusiness = false;
			errorMessage += "Invalid name\n";
		}
		if(business.getState() == null || business.getState().length() == 0) {
			isValidBusiness = false;
			errorMessage += "Invalid state\n";
		}
		if(business.getStreetAddress1() == null || business.getStreetAddress1().length() == 0) {
			isValidBusiness = false;
			errorMessage += "Invalid street address\n";
		}
		if(business.getZip() == null || business.getZip().length() == 0) {
			isValidBusiness = false;
			errorMessage += "Invalid zip";
		}
		
		if(isValidBusiness) {
			User manager = business.getManager();
			manager.setRole(User.Role.MANAGER);
			// TODO: Find out if the user's businessManaged field is automatically set by
			// Hibernate.
			UDao.updateUser(manager);
			BDao.createBusiness(business);
			return business;
		}
		else {
			throw new InvalidBusinessException(errorMessage);
		}
		
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
	
	/**
	 * Changes the employee station of the given user to the given station.
	 * This method first empties the list of employee stations, then adds
	 * the given station to the list. The user is then persisted.
	 * 
	 * @param user		The employee whose station is being updated.
	 * @param station	The employee's new station.
	 * @return			An updated User object that represents the employee.
	 */
	
	// TODO: Untested
	public User updateEmployeeStation(User user, Station station) {
		user.getEmployeeStations().clear();
		user.getEmployeeStations().add(station);
		UDao.updateUser(user);
		return user;
	}
	
	/**
	 * Changes the given user to an employee, and adds the given station
	 * to their list of employee stations. Persists and returns user.
	 * 
	 * @param user		The new employee.
	 * @param station	The station that the new employee is assigned to 
	 * 					(typically the business's default station).
	 * @return			The updated user.
	 */
	
	// TODO: Untested
	public User hireNewEmployee(User user, Station station) {
		user.setRole(User.Role.EMPLOYEE);
		user.getEmployeeStations().add(station);
		UDao.updateUser(user);
		return user;
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
