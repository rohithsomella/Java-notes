package com.boot.lombok.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.lombok.model.Person;

@Controller
public class PersonController {

	@GetMapping("/persons")
	public String perList(Model model)
	{
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(100,"Rohith","rohithsomella@gmail.com"));
		persons.add(new Person(101,"Charan","charansomella@gmail.com"));
		persons.add(new Person(102,"Sachin","sachintakur@gmail.com"));
		model.addAttribute("persons",persons);
		return "persons-list";
		
	}
}
