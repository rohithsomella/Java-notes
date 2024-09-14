package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody // (instead of using this annotation to every method simply we can use to class level.
public class TestController {

	@RequestMapping("/test") // url name can be anything ex: test
	//@ResponseBody // --> it helps to make the return string visible on browser
	public String greet() // method name can be anything ex: greet()
	{
		return "Good Morning Rohith, like comment and subscribe";
		
	}
	
	@RequestMapping("/info")
	//@ResponseBody
	public String info() {
		return "2nd text view to using responsebody annotation.";
	}
}
