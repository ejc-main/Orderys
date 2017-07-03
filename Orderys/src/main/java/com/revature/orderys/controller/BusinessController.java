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
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ArrayList<Business> getAllBusinesses() {
		//TODO:implement return 
		return null;
	}
	
	//city, country, state, name, streetAddress1, zip, manager
	@RequestMapping(value="", method=RequestMethod.POST)
	public Business addBusiness(@RequestParam(name="businessName", required=true) String businessName,
			@RequestParam(name="streetAddress1", required=true) String streetAddress1,
			@RequestParam(name="streetAddress2", required=false) String streetAddress2,
			@RequestParam(name="city", required=true) String city,
			@RequestParam(name="state", required=true) String state,
			@RequestParam(name="country", required=true) String country,
			@RequestParam(name="", required=true) String zip,
			HttpServletRequest request) {
		//TODO:implement return 
		return null;
		
		
	}
	
	@RequestMapping(value="/{businessId}", method=RequestMethod.GET)
	public Business getBusiness(HttpServletRequest request) {
		//TODO:implement return 
		return null;
	}
	
	@RequestMapping(value="/{businessId}", method=RequestMethod.POST)
	public Business updateBusiness() {
		//TODO:implement return 
		return null;
	}
	
}
