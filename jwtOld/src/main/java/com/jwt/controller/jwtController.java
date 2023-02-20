package com.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jwtController {

	@RequestMapping("/sayCheese")
	public String myFirstJwt()
	{
		return "Hello Jwt Let's do you";
	}
	
	
	
}


