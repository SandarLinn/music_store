package com.Sandar.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.Sandar.demo.models.Person;
import com.Sandar.demo.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll(){
		
		return (List<Person>)personRepository.findAll();
	}
	
	public void savePerson(String name, int age){
		Person person = new Person(name, age);
		personRepository.save(person);
	}
	
	public Person getPersonById(long id){
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()){
			return person.get();
		}
		return null;
	}
}
