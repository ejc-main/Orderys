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
	
	@RequestMapping(value="/landing", method=RequestMethod.GET)
	public String getLandingPage(HttpSession session) {
		if ((User) session.getAttribute("user") == null) {
			return "landing";
		} else {
			return "redirect:main";
		}
	}
	
	@RequestMapping(value = {"", "/", "main"}, method = RequestMethod.GET)
	public String getMainPage(HttpSession session) {
		session.setMaxInactiveInterval(60 * 60);
		if (((User) session.getAttribute("user")) == null) {
			return "redirect:landing";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(name="email", required=true) String email,
    		@RequestParam(name="password", required=true) String password,
    		HttpSession session) {
		if (((User) session.getAttribute("user")) != null) {
			return "redirect:main";
		} else {
			try {
				User user = service.loginUser(email, password);
				System.out.println("logged in as " + user);
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(60 * 60);
				return "redirect:main";
			} catch (InvalidCredentialsException ex) {
				session.setAttribute("loginError", ex.getMessage());
				return "redirect:landing";
			}
		}
    }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@RequestParam(name="email", required=true) String email,
    		@RequestParam(name="password", required=true) String password,
    		@RequestParam(name="firstname", required=true) String firstname,
    		@RequestParam(name="lastname", required=true) String lastname,    		
    		HttpSession session) {
		if (((User) session.getAttribute("user")) != null) {
			return "redirect:main";
		} else {
			try {
				User user = service.addNewUser(email, password, firstname, lastname);
				System.out.println("registered new account " + user);
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(60 * 60);
				return "redirect:main";
			} catch (EmailNotUniqueException ex) {
				session.setAttribute("registrationError", ex.getMessage());
				return "redirect:landing";
			}
		}
	}
	
	@RequestMapping(value="/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:landing";
	}

}
