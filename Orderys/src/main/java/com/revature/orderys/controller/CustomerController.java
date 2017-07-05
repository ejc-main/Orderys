package com.revature.orderys.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.OrderItem;
import com.revature.orderys.bean.User;
import com.revature.orderys.service.Service;

/**
 * The controller that handles requests to URIs starting with /user.
 * Methods in this controller should be available for customers attempting 
 * to access their own account, or for all users if labeled as such.
 * @author Eric Christie
 *
 */
@RestController
@RequestMapping(value="/user")
public class CustomerController {
	
	@Autowired
	Service service;
	
	public CustomerController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}
	
//	/**
//	 * get list of all users
//	 */
//	@RequestMapping(value="", method=RequestMethod.GET)
//	/**
//	 * add a new user
//	 */
//	@RequestMapping(value="", method=RequestMethod.POST)
	
	/**
	 * get account information for specified user
	 */
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public User getUser(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="userId") long userId) {
		User u = null;
		u = service.getUserById(userId);
		u.setPasswordHash(null);
		return u;
	}
	/**
	 * update account information for specified user
	 * (does not affect ratings, business managed, orders, or role)
	 */
	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public User updateUser(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="userId") long userId, @RequestBody User updates) {
		updates.setId(userId);
		User updated = (User) request.getSession().getAttribute("user");
		if (updates.getEmail() != null) {
			updated.setEmail(updates.getEmail());
		}
		if (updates.getPasswordHash() != null) {
			updated.setPasswordHash(BCrypt.hashpw(updates.getPasswordHash(), BCrypt.gensalt()));
		}
		if (updates.getFirstName() != null) {
			updated.setFirstName(updates.getFirstName());
		}
		if (updates.getLastName() != null) {
			updated.setLastName(updates.getLastName());
		}
		if (updates.getEmployeeStations() != null) {
			updated.setEmployeeStations(updates.getEmployeeStations());
		}
		updated = service.updateUser(updated);
		updated.setPasswordHash(null);
		return updated;
	}
//	/**
//	 * update account information for specified user
//	 */
//	@RequestMapping(value="/{userId}", method=RequestMethod.PUT)
//	/**
//	 * delete specified user
//	 */
//	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	
	/**
	 * get list of all orders placed by specified user
	 */
	@RequestMapping(value="/{userId}/order", method=RequestMethod.GET)
	public ArrayList<Order> getOrders(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="userId") long userId) {
		return (ArrayList<Order>) service.getAllUserOrders((User) request.getSession().getAttribute("user"));
	}
	/**
	 * place a new order as specified user
	 */
	@RequestMapping(value="/{userId}/order", method=RequestMethod.POST)
	public Order placeOrder(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="userId") long userId, @RequestBody Order order) {
		order.setCustomerId((User) request.getSession().getAttribute("user"));
		return service.placeOrder(order);
	}
	
//	/**
//	 * get information for specified order placed by specified user
//	 */
//	@RequestMapping(value="/{userId}/order/{orderId}", method=RequestMethod.GET)
//	public Order getOrder(HttpServletRequest request, HttpServletResponse response,
//			@PathVariable(value="userId") long userId, @PathVariable(value="orderId") long orderId) {
//		
//	}
	/**
	 * update (cancel) specified order placed by specified user
	 * @throws Exception 
	 */
	@RequestMapping(value="/{userId}/order/{orderId}", method=RequestMethod.POST)
	public Order cancelOrder(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="userId") long userId, @PathVariable(value="orderId") long orderId,
			@RequestBody Order cancelling) throws Exception {
		cancelling.setCustomerId((User) request.getSession().getAttribute("user"));
		if (!service.getOrderStatus(service.getOrderById(orderId)).equals(OrderItem.Status.COMPLETED)) {
			service.cancelOrder(cancelling);
			return service.getOrderById(orderId);
		} else {
			throw new Exception("You cannot cancel an order that has already been completed.");
		}
	}

	@RequestMapping(value="/{userId}/business", method=RequestMethod.GET)
	public Business getManagedBusiness(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="userId") long userId) {
		return service.getBusinessManagedByUser((User) request.getSession().getAttribute("user"));
	}
	
	@RequestMapping(value="/current", method=RequestMethod.GET)
	public User getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
		return (User) request.getSession().getAttribute("user");
	}
	
}
