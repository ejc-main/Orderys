package com.revature.orderys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String getMainPage() {
//		return "index";
//	}
	
	@RequestMapping(value = {"","/","home"}, method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }
	
}
