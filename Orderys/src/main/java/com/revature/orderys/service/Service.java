package com.revature.orderys.service;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static void main(String[] args) {
		
	}
	private BusinessDao BDao;
	private UserDao UDao;
	private ProductDao productDao;
	private StationDao SDao;
	private OrderDao ODao;
	
	private OrderItemDao OIDao;
	
	// a list of emails for which no account exists that have been sent job offers 
	private Map<String, Business> pendingHires;
	
	public Service() {
		super();
		pendingHires = new HashMap<String, Business>();
	}
	
	public void addToPendingHires(String email, Business business) {
		pendingHires.put(email, business);
	}
	
	private Boolean wasInPendingHires(String email) {
		return pendingHires.remove(email, pendingHires.get(email));
	}
	
	// TODO: Untested
	// TODO: Implement necessary checks on product; throw errors.
	public Product addMenuItem(Product product) {
		productDao.createProduct(product);
		return product;
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
	
	public User addNewUser(String email,String password,String firstName, String lastName) throws EmailNotUniqueException {		
		if(UDao.getUserByEmail(email) == null) {
			User user = new User();
			user.setEmail(email.trim());
			if (wasInPendingHires(user.getEmail())) {
				user.setRole(User.Role.EMPLOYEE);
			} else {
				user.setRole(User.Role.CUSTOMER);
			}
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
	
	//End Station Services
	
	
	// Begin User Services
	
	//Start Customer Services
	//TODO:untested
	public void cancelOrder(Order order){
		ArrayList<OrderItem> orderitems=(ArrayList<OrderItem>) OIDao.getOrderItemsByOrder(order);
		for(OrderItem orderitem : orderitems){
			orderitem.setStatus(OrderItem.Status.CANCELLED);
			OIDao.updateOrderItem(orderitem);
		}
	}
	//End Customer Services
	
	public void changeUserPassword(String email,String passwordHash){
		User u = UDao.getUserByEmail(email);
		u.setPasswordHash(passwordHash);
		UDao.updateUser(u);
	}
	
	// TODO: Untested
	// TODO: Implement necessary checks and throw exceptions
	public Station createStation(Station station) {
		SDao.createStation(station);
		return station;
	}
	
	public ArrayList<OrderItem> getActiveOrderItems(User employee){
		return (ArrayList<OrderItem>) OIDao.getActiveOrderItemsByBusiness(employee.getEmployeeStations().get(0).getBusiness());
	}
	//End Employee Services
	
	// TODO; Untested
	public List<Business> getAllBusinesses() {
		System.out.println("reached service");
		return BDao.getAllBusinesses();
	}
	
	public ArrayList<Station> getAllStationsByBusiness(Business business){
		return (ArrayList<Station>) SDao.getAllStationsByBusiness(business);
	}
	
	// TODO: Untested
	public List<Order> getAllUserOrders(User user) {
		return ODao.getOrdersByCustomer(user);
	}
	
	//get business, order, product and user by id
	public Business getBusinessById(long id){
		return BDao.getBusinessById(id);
	}
	
	public ArrayList<User> getEmployeesByBusiness(Business business){
		ArrayList<Station> stations=(ArrayList<Station>) SDao.getAllStationsByBusiness(business);
		return null;
	}
	// End Business Services
	
	// End User Services
	
	// Start Business Services:
	
	//Start Station Services
	public ArrayList<User> getEmployeesByStation(Station station){
		return (ArrayList<User>)station.getEmployees();
	}
	
	// TODO: Untested
	public List<Product> getMenu(Business business) {
		return productDao.getAllProductsByBusiness(business);
	}
	
	public Order getOrderById(long id){
		return ODao.getOrderById(id);
	}
	
	//Start Employee Services
	//TODO:untested
	public ArrayList<OrderItem> getOrderItemsCompletedByEmployee(User employee){
		return (ArrayList<OrderItem>) OIDao.getOrderItemsByEmployee(employee);
	}
	
	public OrderItem.Status getOrderStatus(Order order){
		ArrayList<OrderItem> items=(ArrayList<OrderItem>)OIDao.getOrderItemsByOrder(order);
		for(OrderItem item:items){
			if(item.getStatus().equals(OrderItem.Status.CANCELLED)){
				return OrderItem.Status.CANCELLED;
			}else if(item.getStatus().equals(OrderItem.Status.ACTIVE)){
				return OrderItem.Status.ACTIVE;
			}
		}
		return OrderItem.Status.COMPLETED;
	}
	
	//TODO:untested,using untested dao method
	//returns long of seconds for average completion time
	public long getProductAverageCompletionTime(Product product){
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderItems=(ArrayList<OrderItem>) OIDao.getOrderItemsByProduct(product);
		long out=0;
		long numcompleted=0;
		for(OrderItem item:orderItems){
			if(item.getStatus()==OrderItem.Status.COMPLETED){
				out=out+(item.getTimeCompleted().getTime()- item.getTimePlaced().getTime())/1000;
				numcompleted++;
			}
		}
		out=out/numcompleted;
		return out;
	}
	
	public Product getProductById(long id){
		return productDao.getProductById(id);
	}
	
	public User getUserById(long id){
		return UDao.getUserById(id);
	}
	
	public User getUserByEmail(String email) {
		return UDao.getUserByEmail(email);
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
	
	//Start Product Services
	
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
	
	
	//End Product Services
	
	//End Product Services
	
	public User loginUser(User user) throws InvalidCredentialsException {
		User u = UDao.getUserByEmail(user.getEmail());
		
		if(BCrypt.checkpw(user.getPasswordHash(), u.getPasswordHash())) {
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
			
			Station station = new Station();
			station.setStationName("default");
			
			// TODO: Does hibernate instantiate collections?
			if(business.getStations() != null) {
				business.setStations(new ArrayList<Station>());
			}
			
			// TODO: Will the station be persisted?
			business.getStations().add(station);
			BDao.updateBusiness(business);
			
			return business;
		}
		else {
			throw new InvalidBusinessException(errorMessage);
		}
		
	}

	// TODO: Triage
	// Start old code:
	
	public void setBDao(BusinessDao bDao) {
		this.BDao = bDao;
	}
	
	
	public void setODao(OrderDao orderDao) {
		this.ODao = orderDao;
	}
	
	public void setOIDao(OrderItemDao orderItemDao) {
		this.OIDao = orderItemDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public void setSDao(StationDao sDao) {
		this.SDao = sDao;
	}
	public void setUDao(UserDao uDao) {
		this.UDao = uDao;
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
	// TODO: Untested
	// TODO: Might be returning the same product that was entered
	// TODO: Implement necessary checks on product and throw exceptions
	public Product updateMenuItem(Product product) {
		productDao.updateProduct(product);
		return product;
	}
	// TODO: Untested
	// TODO: Implement necessary checks and throw exceptions
	public OrderItem updateOrderItem(OrderItem orderItem) {
		OIDao.updateOrderItem(orderItem);
		return orderItem;
	}
	// TODO: Untested
	public User updateUser(User user) {
		UDao.updateUser(user);
		
		return user;
	}

	// TODO: Untested
	// TODO: Implement necessary checks and throw errors.
	public List<OrderItem> viewActiveOrderItems(Business business) {
		return OIDao.getOrderItemsByStatus(business, OrderItem.Status.ACTIVE);
	}

	public OrderItem.Status getOrderStatus(Order order){
		ArrayList<OrderItem> items=(ArrayList<OrderItem>)OIDao.getOrderItemsByOrder(order);
		for(OrderItem item:items){
			if(item.getStatus().equals(OrderItem.Status.CANCELLED)){
				return OrderItem.Status.CANCELLED;
			}else if(item.getStatus().equals(OrderItem.Status.ACTIVE)){
				return OrderItem.Status.ACTIVE;
			}
		}
		return OrderItem.Status.COMPLETED;
	}
	public ArrayList<Station> getAllStationsByBusiness(Business business){
		return (ArrayList<Station>) SDao.getAllStationsByBusiness(business);
	}
	//get business, order, product and user by id
	public Business getBusinessById(long id){
		return BDao.getBusinessById(id);
	}
	public Order getOrderById(long id){
		return ODao.getOrderById(id);
	}
	public Product getProductById(long id){
		return productDao.getProductById(id);
	}
	//get default station for a business
	public Station getDefaultStation(Business business){
		ArrayList<Station> stations=(ArrayList<Station>)SDao.getAllStationsByBusiness(business);
		for(Station station:stations){
			if(station.getStationName().equalsIgnoreCase("default"));
			return station;	
		}
		return null;
	}
	
}
