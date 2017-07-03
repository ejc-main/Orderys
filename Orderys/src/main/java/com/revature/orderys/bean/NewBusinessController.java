package com.revature.orderys.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.orderys.service.Service;

@RestController
@RequestMapping(value="/business")
public class NewBusinessController {
	
	@Autowired
	Service service;
	
	public NewUserController() {
		super();
	}

	public void setService(Service service) {
		this.service = service;
	}

}
