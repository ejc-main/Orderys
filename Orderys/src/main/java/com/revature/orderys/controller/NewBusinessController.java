//package com.revature.orderys.controller;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.orderys.bean.Business;
//import com.revature.orderys.service.Service;
//
///**
// * The controller that handles requests to URIs starting with /business.
// * Methods in this controller should be available for managers attempting to access 
// * the business they manage, or for all users if labeled as such.
// * @author Eric Christie
// *
// */
//@RestController
//@RequestMapping(value="/business")
//public class NewBusinessController {
//	
//	@Autowired
//	Service service;
//	
//	public NewBusinessController() {
//		super();
//	}
//
//	public void setService(Service service) {
//		this.service = service;
//	}
//	
//	/**
//	 * get list of all businesses
//	 */
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public ArrayList<Business> getBusinesses() {
//		
//	}
//	/**
//	 * add new business
//	 */
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public Business addBusiness() {
//		
//	}
//	
//	/**
//	 * get information for specified business
//	 */
//	@RequestMapping(value="/{businessId}", method=RequestMethod.GET)
//	public Business getBusiness() {
//		
//	}
//	/**
//	 * update information for specified business
//	 */
//	@RequestMapping(value="/{businessId}", method=RequestMethod.POST)
//	public Business updateBusiness() {
//		
//	}
////	/**
////	 * update information for specified business
////	 */
////	@RequestMapping(value="/{businessId}", method=RequestMethod.PUT)
////	/**
////	 * delete specified business
////	 */
////	@RequestMapping(value="/{businessId}", method=RequestMethod.DELETE)
//	
//	/**
//	 * get list of stations for specified business
//	 */
//	@RequestMapping(value="/{businessId}/station", method=RequestMethod.GET)
//	/**
//	 * add a station for specified business
//	 */
//	@RequestMapping(value="/{businessId}/station", method=RequestMethod.POST)
//	
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
//	/**
//	 * delete specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.DELETE)
//	
//	/**
//	 * get list of employees assigned to specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.GET)
//	/**
//	 * add employee to specific station of specified business
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.POST)
//	
////	/**
////	 * 
////	 */
////	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.GET)
////	/**
////	 * 
////	 */
////	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.POST)
////	/**
////	 * 
////	 */
////	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.PUT)
////	/**
////	 * 
////	 */
////	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.DELETE)
//	
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/product", method=RequestMethod.GET)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/product", method=RequestMethod.POST)
//	
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.GET)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.POST)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.PUT)
//	/**
//	 * 
//	 */
//	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.DELETE)
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
//	
//
//}
