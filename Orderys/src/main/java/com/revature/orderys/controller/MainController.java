package com.revature.orderys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/main")
public class MainController {
	
	/*
	 * Use the @RequestBody annotation to make a controller method serialize its output as 
	 * a JSON string to be used as the HTTP response body. You should also be sure to catch 
	 * and handle any errors that might get thrown within any such methods.
	 */
	
	@RequestMapping(method=RequestMethod.GET)
	public String getMainPage() {
		return "index";
	}
	
}
