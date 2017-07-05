package com.revature.orderys.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.OrderItem;
import com.revature.orderys.bean.User;
import com.revature.orderys.service.Service;

/**
 * The controller that handles requests to URIs starting with /station.
 * Methods in this controller should be available for employees attempting to access 
 * information about stations they are assigned to, or for all users if labeled as such.
 * @author Eric Christie
 *
 */
@RestController
@RequestMapping(value="/station")
public class EmployeeController {
	
	@Autowired
	Service service;
	
	public EmployeeController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	/**
	 * get account information for specified employee of specified business
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}", method=RequestMethod.GET)
	public User getEmployee(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId,
			@PathVariable(value="") long employeeId) {
		return service.getUserById(employeeId);
	}
	/**
	 * update station for specified employee of specified business
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}", method=RequestMethod.POST)
	public User updateEmployee(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId,
			@PathVariable(value="employeeId") long employeeId,
			@RequestBody User updates) {
		updates.setId(employeeId);
		return service.updateUser(updates);
	}
//	/**
//	 * quit job as specified employee of specified business
//	 */
//	@RequestMapping(value="/{businessId}/employee/{employeeId}", method=RequestMethod.DELETE)
//	public User quitJob(HttpServletRequest request, HttpServletResponse response,
//			@PathVariable(value="businessId") long businessId,
//			@PathVariable(value="employeeId") long employeeId) {
//		User employee = null;
//		return employee;
//	}
	
	/**
	 * get list of order items handled by specified employee of specified business
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}/orderItem", method=RequestMethod.GET)
	public ArrayList<OrderItem> getCompletedOrderItems(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId,
			@PathVariable(value="employeeId") long employeeId) {
		return service.getOrderItemsCompletedByEmployee((User) request.getSession().getAttribute("user"));
	}
	/**
	 * mark specific existing order as having been handled by specific employee of specified business
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}/orderItem", method=RequestMethod.POST)
	public OrderItem completeOrderItem(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId,
			@PathVariable(value="employeeId") long employeeId,
			@RequestBody OrderItem orderItem) {
		orderItem.setStatus(OrderItem.Status.COMPLETED);
		orderItem.setCompletedBy(service.getUserById(employeeId));
		return service.updateOrderItem(orderItem);
	}
	
	/**
	 * get active order items for specified business
	 */
	@RequestMapping(value="/{businessId}/orderItem", method=RequestMethod.GET)
	public ArrayList<OrderItem> getActiveOrderItems(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId) {
		return (ArrayList<OrderItem>) service.viewActiveOrderItems(service.getBusinessById(businessId));
	}
	
//	/**
//	 * update (mark as completed) specific order item for the specified business
//	 */
//	@RequestMapping(value="/{businessId}/orderItem/{itemId}", method=RequestMethod.POST)
	
}
