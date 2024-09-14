package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/greet")
	public String greetMsg()
	{
		return "greeting";
	}

	
	@RequestMapping("/info")
	public String information()
	{
		return "information";
	}
}
