package com.revature.orderys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.Business;
import com.revature.orderys.bean.Order;
import com.revature.orderys.bean.Rating;
import com.revature.orderys.bean.Station;
import com.revature.orderys.bean.User;
import com.revature.orderys.exceptions.EmailNotUniqueException;
import com.revature.orderys.service.Service;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	Service service;
	
	public UserController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public User addUser(@RequestParam(name="email", required=true) String email,
			@RequestParam(name="password", required=true) String password,
			@RequestParam(name="firstname", required=true) String firstname,
			@RequestParam(name="lastname", required=true) String lastname,
			HttpSession session){
		try {
			return service.addNewUser(email, password, firstname, lastname);
		} catch (EmailNotUniqueException ex) {
			session.setAttribute("registrationError", ex.getMessage());
			return null;
		}
		
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public User getUser(@PathVariable(value="userId") long userId, HttpSession session) {
		User u = null;
		u = service.getUserById(userId);
		return u;
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public User updateUser(@RequestParam(name="email", required=false) String email,
			@RequestParam(name="password", required=false) String password,
			@RequestParam(name="firstname", required=false) String firstname,
			@RequestParam(name="lastname", required=false) String lastname,
			@RequestParam(name="role", required=false) String role,
			@RequestParam(name="orders", required=false) List<Order> orders,
			@RequestParam(name="ratings", required=false) List<Rating> ratings,
			@RequestParam(name="stations", required=false) List<Station> stations,
			@RequestParam(name="business", required=false) Business business,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (email != null) {
			user.setEmail(email);
		}
		if (password != null) {
			user.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt()));
		}
		if (firstname != null) {
			user.setFirstName(firstname);
		}
		if (lastname != null) {
			user.setLastName(lastname);
		}
		if (role != null) {
			user.setRole(User.Role.valueOf(role.toUpperCase()));
		}
		if (orders != null) {
			user.setOrders(orders);
		}
		if (ratings != null) {
			user.setRatings(ratings);
		}
		if (stations != null) {
			user.setEmployeeStations(stations);
		}
		if (business != null) {
			user.setBusinessManaged(business);
		}
		return service.updateUser(user);
	}

}