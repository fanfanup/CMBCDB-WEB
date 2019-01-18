package com.cmbc.liquibase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TestController {

	
	@RequestMapping(value= "/aaa" , method = RequestMethod.GET)
	public String test(){
		System.out.println("11111111111");
		return "hello,this is a springboot demo";  
	}
}
