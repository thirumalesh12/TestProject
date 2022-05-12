package com.capg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
public class HelloController {
	@GetMapping("/hello")
	public String sayHello()
	{
		return "welcome to spring boot";
	}

}
