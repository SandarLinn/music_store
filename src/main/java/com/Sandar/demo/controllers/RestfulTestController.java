package com.Sandar.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sandar.demo.models.Person;

@RestController
@RequestMapping("/api")
public class RestfulTestController {
	
	@GetMapping("/getPersons")
	public List<Person> getPersonList(@RequestParam(name="name1",required=true) String name1, @RequestParam(name="name2", required=false) String name2) {
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person();
		person1.setName(name1);
		person1.setAge(23);
		persons.add(person1);
		Person person2 = new Person();
		person2.setName(name2);
		person2.setAge(23);
		persons.add(person2);
		return persons;
	}
}
