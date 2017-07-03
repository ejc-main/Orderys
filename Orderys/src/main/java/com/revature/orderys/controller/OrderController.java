package com.revature.orderys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.Order;

@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	/*
	 * GET: get the details about a specific order
	 */
	@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
	
	/*
	 * POST: update (cancel) a specific order
	 */
	@RequestMapping(value="/{orderId}", method=RequestMethod.POST)
	
	/*
	 * GET: get list of order items in an order
	 */
	@RequestMapping(value="/{orderId}/item", method=RequestMethod.GET)
	
	/*
	 * [NOT NEEDED?] POST: add an order item to an order
	 * (would it be best to not allow the items of an order to be modified?
	 *  - basically orders would be 'assembled' client-side before being submitted)
	 */
	@RequestMapping(value="/{orderId}/item", method=RequestMethod.POST)

	/*
	 * GET: get details for a specific order item in an order
	 */
	@RequestMapping(value="/{orderId}/item/{productId}", method=RequestMethod.GET)
	
	/*
	 * POST: update (mark as completed) a specific order item in an order
	 */
	@RequestMapping(value="/{orderId}/item/{productId}", method=RequestMethod.POST)
	
}
