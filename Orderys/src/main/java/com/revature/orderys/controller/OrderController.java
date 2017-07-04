//package com.revature.orderys.controller;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.orderys.bean.Order;
//import com.revature.orderys.bean.OrderItem;
//import com.revature.orderys.service.Service;
//
//@RestController
//@RequestMapping(value="/order")
//public class OrderController {
//	
//	@Autowired
//	Service service;
//	
//	public OrderController() {
//		super();
//	}
//	
//	public void setService(Service service) {
//		this.service = service;
//	}
//	
//	/*
//	 * GET: get the details about a specific order
//	 * accessible by the customer that placed the order and the manager of the business it was placed with
//	 */
//	@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
//	public Order getOrder(HttpSession session, @PathVariable(value="orderId") long orderId) {
//		
//	}
//	
//	/*
//	 * POST: update (cancel) a specific order
//	 * accessible by the customer that placed the order
//	 */
//	@RequestMapping(value="/{orderId}", method=RequestMethod.POST)
//	public Order cancelOrder(HttpSession session, @PathVariable(value="orderId") long orderId) {
//		
//	}
//	
//	/*
//	 * GET: get list of order items in an order
//	 * accessible by the customer that placed the order and the manager of the business it was placed with
//	 */
//	@RequestMapping(value="/{orderId}/item", method=RequestMethod.GET)
//	public ArrayList<OrderItem> getOrderItems(HttpSession session, @PathVariable(value="orderId") long orderId) {
//		
//	}
//	
////	/*
////	 * [NOT NEEDED?] POST: add an order item to an order
////	 * (would it be best to not allow the items of an order to be modified?
////	 *  - basically orders would be 'assembled' client-side before being submitted)
////	 */
////	@RequestMapping(value="/{orderId}/item", method=RequestMethod.POST)
//
//	/*
//	 * GET: get details for a specific order item in an order
//	 * accessible by customer that placed order, employees at station responsible for the order item, 
//	 * and manager of the business the order was placed with
//	 */
//	@RequestMapping(value="/{orderId}/item/{productId}", method=RequestMethod.GET)
//	public OrderItem getOrderItem(HttpSession session, @PathVariable(value="orderId") long orderId,) {
//		
//	}
//	
//	/*
//	 * POST: update (mark as completed) a specific order item in an order
//	 * accessible by employees assigned to the station responsible for the order item
//	 */
//	@RequestMapping(value="/{orderId}/item/{productId}", method=RequestMethod.POST)
//	public OrderItem completeOrderItem(HttpSession session, @PathVariable(value="orderId") long orderId,) {
//		
//	}
//	
//}
