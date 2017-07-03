package com.revature.orderys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.service.Service;

@RestController
@RequestMapping(value="/station")
public class StationController {
	
	@Autowired
	Service service;
	
	public StationController() {
		super();
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
//	/*
//	 * GET: get details for a station of a business
//	 */
//	@RequestMapping(value="/{stationId}", method=RequestMethod.GET)
//	
//	/*
//	 * POST: update details for a station of a business
//	 */
//	@RequestMapping(value="/{stationId}", method=RequestMethod.POST)
//	
//	/*
//	 * DELETE: remove a station
//	 */
//	@RequestMapping(value="/{stationId}", method=RequestMethod.DELETE)
//	
//	/*
//	 * GET: get list of products that a station is responsible for
//	 */
//	@RequestMapping(value="/{stationId}/product", method=RequestMethod.GET)
//	
//	/*
//	 * POST: add a new product to a stations responsibilities
//	 */
//	@RequestMapping(value="/{stationId}/product", method=RequestMethod.POST)
//	
//	/*
//	 * GET: get list of employees assigned to a station
//	 */
//	@RequestMapping(value="/{stationId}/employee", method=RequestMethod.GET)
//	
//	/*
//	 * POST: assign an employee to a station
//	 */
//	@RequestMapping(value="/{stationId}/employee", method=RequestMethod.POST)
//	
//	/*
//	 * GET: get information about an employee assigned to a station
//	 */
//	@RequestMapping(value="/{stationId}/employee/{employeeId}", method=RequestMethod.GET)
//	
//	/*
//	 * DELETE: remove an employee from a station, but not from the business
//	 */
//	@RequestMapping(value="/{stationId}/employee/{employeeId}", method=RequestMethod.POST)

}
