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
//import com.revature.orderys.bean.Product;
//import com.revature.orderys.bean.Rating;
//import com.revature.orderys.service.Service;
//
//@RestController
//@RequestMapping(value="/product")
//public class ProductController {
//	
//	@Autowired
//	Service service;
//	
//	public ProductController() {
//		super();
//	}
//	
//	public void setService(Service service) {
//		this.service = service;
//	}
//	
////	/*
////	 * GET: get list of all products (might be useful for searching all products from all businesses)
////	 */
////	@RequestMapping(value="", method=RequestMethod.GET)
//	
//	
//	/*
//	 * GET: get information about a product
//	 * accessible by customers, employees, and managers
//	 */
//	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
//	public Product getProduct(HttpSession session, @PathVariable(value="productId") long productId) {
//		
//	}
//	
//	/*
//	 * POST: update information about a product
//	 * accessible by the manager of the business that provides the given product
//	 */
//	@RequestMapping(value="/{productId}", method=RequestMethod.POST)
//	public Product updateProduct(HttpSession session, @PathVariable(value="productId") long productId) {
//		
//	}
//	
//	
//	/*
//	 * DELETE: remove a product from the menu it belongs to
//	 * accessible by the manager of the business that provides the given product
//	 */
//	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
//	public boolean deleteProduct(HttpSession session, @PathVariable(value="productId") long productId) {
//		
//	}
//	
//	
//	/*
//	 * GET: get list of all ratings for a product
//	 * accessible by customers, employees, and managers
//	 */
//	@RequestMapping(value="/{productId}/rating", method=RequestMethod.GET)
//	public ArrayList<Rating> getProductRatings(HttpSession session, @PathVariable(value="productId") long productId) {
//		
//	}
//	
//	
//	/*
//	 * POST: submit a rating for a product
//	 * accessibly by customers who have purchased and received the given product
//	 */
//	@RequestMapping(value="/{productId}/rating", method=RequestMethod.POST)
//	public Rating submitProductRating(HttpSession session, @PathVariable(value="productId") long productId) {
//		
//	}
//	
//	
////	/*
////	 * [NOT NEEDED] GET: 
////	 */
////	@RequestMapping(value="/{productId}/rating/{userId}", method=RequestMethod.GET)
//	
////	/*
////	 * [NOT NEEDED] POST:
////	 */
////	@RequestMapping(value="/{productId}/rating/{userId}", method=RequestMethod.POST)
//	
//}
