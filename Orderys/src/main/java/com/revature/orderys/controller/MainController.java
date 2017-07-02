package com.revature.orderys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.orderys.bean.User;
import com.revature.orderys.exceptions.EmailNotUniqueException;
import com.revature.orderys.exceptions.InvalidCredentialsException;
import com.revature.orderys.service.Service;

@Controller
public class MainController {
	
	@Autowired
	Service service;
	
	/*
	 * Use the @RequestBody annotation to make a controller method serialize its output as 
	 * a JSON string to be used as the HTTP response body. You should also be sure to catch 
	 * and handle any errors that might get thrown within any such methods.
	 */
		
	public MainController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value = {"","/","home"}, method = RequestMethod.GET)
	public String getMainPage(HttpSession session) {
		session.setMaxInactiveInterval(60 * 60);
		if (((User) session.getAttribute("user")) == null) {
			System.out.println("main controller directing to landing");
			return "landing";
		} else {
			System.out.println("main controller directing to home");
			return "home";
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(name="email", required=true) String email,
    		@RequestParam(name="password", required=true) String password,
    		HttpSession session) {
		session.setMaxInactiveInterval(60 * 60);
		if (((User) session.getAttribute("user")) != null) {
			System.out.println("landing controller directing to home");
			return "home";
		} else {
			System.out.println("landing controller logging in");
			try {
				User credentials = new User();
				credentials.setEmail(email);
				credentials.setPasswordHash(password);
				User user = service.loginUser(credentials);
				session.setAttribute("user", user);
				return "home";
			} catch (InvalidCredentialsException ex) {
				session.setAttribute("loginError",
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
			System.out.println("landing controller directing to home");
			return "home";
		} else {
			System.out.println("landing controller registering");
			try {
				User user = service.addNewUser(email, password, firstname, lastname);
				session.setAttribute("user", user);
				return "home";
			} catch (EmailNotUniqueException ex) {
				session.setAttribute("registrationError",
						"Registration failed. The email address you provided is already in use.");
				return "landing";
			}
		}
	}
	
	@RequestMapping(value="/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "landing";
	}

}
