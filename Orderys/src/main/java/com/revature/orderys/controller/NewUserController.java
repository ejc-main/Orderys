package com.revature.orderys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderys.service.Service;

@RestController
@RequestMapping(value="/user")
public class NewUserController {
	
	@Autowired
	Service service;
	
	public NewUserController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	

}
