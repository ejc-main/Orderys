package com.revature.orderys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.bean.User;
import com.revature.orderys.service.Service;
import com.revature.orderys.util.PasswordStorage;
import com.revature.orderys.util.PasswordStorage.CannotPerformOperationException;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	Service service;
	
	
	
//	@GetMapping, @PostMapping
//	@RequestBody, @ResponseBody
	
//	@ResponseBody @RequestMapping(method=RequestMethod.GET)
//	public void getUsers() {
//		
//	}
	
	public void setService(Service service) {
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public void addUser(@RequestParam(name="email", required=true) String email,
			@RequestParam(name="password", required=true) String password,
			@RequestParam(name="firstname", required=true) String firstname,
			@RequestParam(name="lastname", required=true) String lastname) {
		try {
			service.addNewUser(email, PasswordStorage.createHash(password), firstname, lastname, "CUSTOMER");
		} catch (CannotPerformOperationException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public User getUser(@PathVariable long userId) {
		User u = null;
		u = service.getUserById(userId);
		return u;
	}

}
