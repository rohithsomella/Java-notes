package com.boot.dataex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController<modelAndView> {

	// 1. model
	
	@GetMapping("/data")
	public String getMessage(Model  model) {
		model.addAttribute("message1","Good morning");
		model.addAttribute("message2","like comment");
		return  "data";
	}
	
	//2. ModelAndView
	
	@GetMapping("/studentinfo")
	public  ModelAndView info() throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "Rohith");
		modelAndView.addObject("age", 24);
		modelAndView.addObject("email", "rohithsomella@gmail.com");
		modelAndView.addObject("mobile",9948617330L);
		
		List<Integer> marks = List.of(98,67,45,98,47,36);
		
		modelAndView.addObject("marks",marks);
		modelAndView.setViewName("info");
		return modelAndView;
		
	}
	
}
