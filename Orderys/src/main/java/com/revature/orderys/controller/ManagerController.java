package com.revature.orderys.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.OrderItem;
import com.revature.orderys.bean.Product;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.service.Service;

/**
 * The controller that handles requests to URIs starting with /business.
 * Methods in this controller should be available for managers attempting to access 
 * the business they manage, or for all users if labeled as such.
 * @author Eric Christie
 *
 */
@RestController
@RequestMapping(value="/business")
public class ManagerController {
	
	@Autowired
	Service service;
	
	public ManagerController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	/**
	 * get list of all businesses
	 * available to everyone
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public ArrayList<Business> getBusinesses(HttpServletRequest request, HttpServletResponse response) {
		return (ArrayList<Business>) service.getAllBusinesses();
	}
	/**
	 * add new business
	 * available to everyone
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public Business addBusiness(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Business business) {
		User u = (User) request.getSession().getAttribute("user");
		if (u.getBusinessManaged() == null) {
			return service.registerBusiness(business);
		} else {
			throw new Exception("You can't make more than one business.");
		}
	}
	
//	/**
//	 * get information for specified business
//	 */
//	@RequestMapping(value="/{businessId}", method=RequestMethod.GET)
//	public Business getBusiness(HttpServletRequest request, HttpServletResponse response,
//			@PathVariable(value="businessId") long businessId) {
//		
//	}
	/**
	 * update information for specified business
	 */
	@RequestMapping(value="/{businessId}", method=RequestMethod.POST)
	public Business updateBusiness(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId, @RequestBody Business updates) {
		
	}
//	/**
//	 * update information for specified business
//	 */
//	@RequestMapping(value="/{businessId}", method=RequestMethod.PUT)
//	/**
//	 * delete specified business
//	 */
//	@RequestMapping(value="/{businessId}", method=RequestMethod.DELETE)
	
	/**
	 * get list of stations for specified business
	 */
	@RequestMapping(value="/{businessId}/station", method=RequestMethod.GET)
	public ArrayList<Station> getStations(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId) {
		return (ArrayList<Station>) service;
	}
	/**
	 * add a station for specified business
	 */
	@RequestMapping(value="/{businessId}/station", method=RequestMethod.POST)
	public Station addStation(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId, @RequestBody Station station) {
		station.setBusiness(service.getBusinessById(businessId));
		return service.createStation(station);
	}
	
//	/**
//	 * get information for specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.GET)
//	/**
//	 * update information for specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.POST)
//	/**
//	 * update information for specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.PUT)
	/**
	 * delete specific station of specified business
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.DELETE)
	
//	/**
//	 * get list of employees assigned to specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.GET)
//	/**
//	 * add employee to specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.POST)
	
	
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.GET)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.POST)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.PUT)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.DELETE)
	
	/**
	 * get list of orders items handled by specific station of specified business
	 */
	@RequestMapping(value="/{businessId}/orderItem", method=RequestMethod.GET)
	public ArrayList<OrderItem> getActiveOrderItems(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="businessId") long businessId) {
		
	}
	
//	/**
//	 * get information for specific product handled by specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.GET)
//	/**
//	 * update product handled by specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.POST)
//	/**
//	 * update information for specific product handled by specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.PUT)
	
	/**
	 * get list of products provided by specified business
	 */
	@RequestMapping(value="/{businessId}/product", method=RequestMethod.GET)
	public ArrayList<Product> getProducts(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId) {
		return service.getMenu(service.getBusinessById(businessId));
	}
	/**
	 * add product provided by specified business
	 */
	@RequestMapping(value="/{businessId}/product", method=RequestMethod.POST)
	public Product addProduct(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId, @RequestBody Product product) {
		
	}
	
	/**
	 * get information for specific product provided by specified business
	 */
	@RequestMapping(value="/{businessId}/product/{productId}", method=RequestMethod.GET)
	/**
	 * update information for specific product provided by specified business
	 */
	@RequestMapping(value="/{businessId}/product/{productId}", method=RequestMethod.POST)
//	/**
//	 * update information for specific product provided by specified business
//	 */
//	@RequestMapping(value="/{businessId}/product/{productId}", method=RequestMethod.PUT)
//	/**
//	 * delete specific product provided by specified business
//	 */
//	@RequestMapping(value="/{businessId}/product/{productId}", method=RequestMethod.DELETE)
	
	/**
	 * get list of employees working for specified business
	 */
	@RequestMapping(value="/{businessId}/employee", method=RequestMethod.GET)
	public ArrayList<User> getEmployees(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId) {
		return (ArrayList<User>) service.getEmployeesByBusiness(business)
	}
	/**
	 * SEND SOMEONE AN EMAIL OFFERING THEM A JOB WITH SPECIFIED BUSINESS
	 */
	@RequestMapping(value="/{businessId}/employee", method=RequestMethod.POST)
	public void sendJobOffer(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value="businessId") long businessId,
			@RequestParam(name="email", required=true) String email,
			@RequestParam(name="firstname", required=true) String firstname,
			@RequestParam(name="lastname", required=true) String lastname,
			@RequestParam(name="message", required=true) String message) {
		
	}
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/employee", method=RequestMethod.PUT)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/employee", method=RequestMethod.DELETE)
	
	/**
	 * get information for specific employee of specified business
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}", method=RequestMethod.GET)
	/**
	 * delete (fire) specific employee of specified business
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}", method=RequestMethod.DELETE)
	
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.GET)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.POST)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.PUT)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.DELETE)
//	
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.GET)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.POST)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.PUT)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.DELETE)
//	
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.GET)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.POST)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.PUT)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	

}
