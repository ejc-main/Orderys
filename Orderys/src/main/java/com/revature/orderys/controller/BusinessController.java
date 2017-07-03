package com.revature.orderys.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.Business;
import com.revature.orderys.service.Service;

@RestController
@RequestMapping(value="/business")
public class BusinessController {
	
	@Autowired
	Service service;
	
	public BusinessController() {
		super();
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	/*
	 * GET: get list of all businesses
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public ArrayList<Business> getAllBusinesses() {
		return (ArrayList<Business>) service.getAllBusinesses();
	}
	
	/*
	 * POST: add a new business
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public Business addBusiness(@RequestParam(name="businessName", required=true) String businessName,
			@RequestParam(name="streetAddress1", required=true) String streetAddress1,
			@RequestParam(name="streetAddress2", required=false) String streetAddress2,
			@RequestParam(name="city", required=true) String city,
			@RequestParam(name="state", required=true) String state,
			@RequestParam(name="country", required=true) String country,
			@RequestParam(name="zip", required=true) String zip,
			HttpServletRequest request) {
		//TODO:implement return
		return null;
		
	}
	
	/*
	 * GET: get information and menu for a specific business
	 */
	@RequestMapping(value="/{businessId}", method=RequestMethod.GET)
	public Business getBusiness(HttpServletRequest request) {
		//TODO:implement return
		return null;
	}
	
	/*
	 * POST: update the information or menu for a specific business
	 */
	@RequestMapping(value="/{businessId}", method=RequestMethod.POST)
	public Business updateBusiness() {
		//TODO:implement return
		return null;
	}

	/*
	 * GET: get list of stations for a specific business
	 */
	RequestMapping(value="/{businessId}/station", method=RequestMethod.GET)
	
	/*
	 * POST: add a new station for a business
	 */
	@RequestMapping(value="/{businessId}/station", method=RequestMethod.POST)
	
	/*
	 * GET: get details for a station of a business
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.GET)
	
	/*
	 * POST: update details for a station of a business
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.POST)
	
	/*
	 * DELETE: remove a station
	 */
	@RequestMapping(value="/{businessId}/station/{stationId}", method=RequestMethod.DELETE)
	
	/*
	 * GET: get list of products provided by a business (maybe just products associated with the default station)
	 */
	@RequestMapping(value="/{businessId}/product", method=RequestMethod.GET)
	
	/*
	 * POST: add a product to the menu (or default station) of a business
	 */
	@RequestMapping(value="/{businessId}/product", method=RequestMethod.POST)
	
	/*
	 * GET: get list of all employees associated with a business (or the default station of the business)
	 */
	@RequestMapping(value="/{businessId}/employee", method=RequestMethod.GET)
	
	/*
	 * POST: add a user as an employee of a business (possibly assign them to the default station)
	 */
	@RequestMapping(value="/{businessId}/employee", method=RequestMethod.POST)
	
	/*
	 * GET: get information about a specific employee
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}", method=RequestMethod.GET)
	
	/*
	 * DELETE: fire an employee (or remove them from a business for some other reason)
	 */
	@RequestMapping(value="/{businessId}/employee/{employeeId}", method=RequestMethod.DELETE)
	
}
