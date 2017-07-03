package com.revature.orderys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.Order;

@RestController
@RequestMapping(value="/order")
public class OrderController {
	
///order/{orderId}
//GET: get the details about a specific order
//POST: update (cancel) a specific order
//
///order/{orderId}/item
//GET: get list of order items in an order
//[NOT NEEDED?] POST: add an order item to an order 
//(would it be best to not allow the items of an order to be modified?
// - basically orders would be 'assembled' client-side before being submitted)
//
///order/{orderId}/item/{productId}
//GET: get details for a specific order item in an order
//POST: update (mark as completed) a specific order item in an order
	
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public Order createOrder() {
//		
//	}
//	
//	@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
//	public Order getOrder() {
//		
//	}
//	
//	@RequestMapping(value="/{orderId}", method=RequestMethod.POST)
//	public Order updateOrder() {
//		
//	}
	
}
