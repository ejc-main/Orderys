package com.revature.orderys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.orderys.bean.User;
import com.revature.orderys.service.Service;

public class LandingController {
	
	@Autowired
	Service service;
		
	public LandingController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value={}, method=RequestMethod.GET)
	public String getLandingPage(HttpSession session) {
		session.setMaxInactiveInterval(60 * 60);
		if (((User) session.getAttribute("user")) != null) {
			return "home";
		} else {
			return "landing";
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(name="email", required=true) String email,
    		@RequestParam(name="password", required=true) String password,
    		HttpSession session) {
		session.setMaxInactiveInterval(60 * 60);
		if (((User) session.getAttribute("user")) != null) {
			return "home";
		} else {
			try {
				User user = service.loginUser(email, password);
				session.setAttribute("user", user);
				return "home";
			} catch (InvalidCredentialsException ex) {
				session.setAttribute("loginAttempted",
						"The username and password you provided were incorrect.");
				return "landing";
			}
		}
    }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@RequestParam(name="email", required=true) String email,
    		@RequestParam(name="password", required=true) String password,
    		@RequestParam(name="firstname", required=true) String firstname,
    		@RequestParam(name="lastname", required=true) String lastname,    		
    		HttpSession session) {
		session.setMaxInactiveInterval(60 * 60);
		if (((User) session.getAttribute("user")) != null) {
			return "home";
		} else {
			try {
				service.addNewUser(email, password, firstname, lastname, "CUSTOMER");
				User user = service.loginUser(email, password);
				session.setAttribute("user", user);
				return "home";
			} catch (EmailNotUniqueException ex) {
				session.setAttribute("registrationAttempted",
						"Registration failed. The email address you provided is already in use.");
				return "landing";
			} catch (InvalidCredentialsException ex) {
				session.setAttribute("loginAttempted", "Please login to your new account.");
				return "landing";
			}
		}
	}
	
}
