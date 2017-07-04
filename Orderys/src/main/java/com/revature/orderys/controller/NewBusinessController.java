package com.revature.orderys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class NewBusinessController {
	
	@Autowired
	Service service;
	
	public NewBusinessController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	/**
	 * get list of all businesses
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	/**
	 * add new business
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	
	/**
	 * get information for specified business
	 */
	@RequestMapping(value="/{businessId}", method=RequestMethod.GET)
	/**
	 * update information for specified business
	 */
	@RequestMapping(value="/{businessId}", method=RequestMethod.POST)
//	/**
//	 * update information for specified business
//	 */
//	@RequestMapping(value="/{businessId}", method=RequestMethod.PUT)
//	/**
//	 * delete specified business
//	 */
//	@RequestMapping(value="/{businessId}", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/employee/{employeeId}", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}/product/{productId}", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	/**
	 * 
	 */
	@RequestMapping(value="", method=RequestMethod.DELETE)
	
	

}
