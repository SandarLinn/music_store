package com.Sandar.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Sandar.demo.formmodels.PersonForm;
import com.Sandar.demo.models.Person;
import com.Sandar.demo.models.UserAccount;
import com.Sandar.demo.repositories.UserAccountRepository;
import com.Sandar.demo.services.PersonService;

@Controller
public class PersonController {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	@Autowired
	private PersonService personService;
	
    @Autowired
    private UserAccountRepository userAccountRepository;
	
	@RequestMapping(value="/getPersonList",method = RequestMethod.GET)
	public ModelAndView successPersonForm(Model model, HttpSession session) {
		List<Person> persons = personService.findAll();
		String names = "";
		for(Person person : persons){
			names += person.getName() +"\n";
		}
		
		
		int result = jdbcTemplate.queryForObject(
			    "SELECT COUNT(*) FROM PERSON", Integer.class);
		
		logger.info("get person list ===="+ result);
		
		model.addAttribute("persons", persons);
		return new ModelAndView("showPersonList");
	}
	
	@RequestMapping(value="/savePerson",method = RequestMethod.GET)
	public @ResponseBody String savePerson() {
		personService.savePerson("Chit Su Lwin", 24);
		
		 return "save person";
	}
	
	 @RequestMapping(value="/formTest",method = RequestMethod.GET)
	    public ModelAndView formTest(PersonForm personForm) {
		 	System.out.println("person id = "+ personForm.getName());
	    	return new ModelAndView("admin/formTest");
	    }
	    
	 
	 @RequestMapping(value="/testSecurity",method = RequestMethod.GET)
	    public @ResponseBody String testSecurity() {
		 UserAccount userAccount = userAccountRepository.findByEmail("sandarlinn@gmail.com");
	    	return "hello" + userAccount.getDisplayName();
	  }
	    
	 
	    @RequestMapping(value="/formTest",method = RequestMethod.POST)
	    public String handleFormTest(@Valid PersonForm personForm, BindingResult bindingResult) {
	    	if(bindingResult.hasErrors()){
	    		return "admin/formTest"; 
	    	}
	    	personService.savePerson(personForm.getName(), personForm.getAge());
	    	 return "redirect:/getPersonList";
	    }
	    
	    @RequestMapping(value="/updatePerson/{personId}",method = RequestMethod.GET)
	    public ModelAndView successPersonForm(@PathVariable(name = "personId") Long id, HttpSession session, Model model) {
	    	Person person = personService.getPersonById(id);
	    	if(person != null){
	    		PersonForm personForm = new PersonForm();
	    		personForm.setName(person.getName());
	    		personForm.setAge(person.getAge());
	    		model.addAttribute("personForm", personForm);
	    	}
	    	session.setAttribute("personSuccess", "successfully updated");
	    	model.addAttribute("personId", id);
	    	return new ModelAndView("admin/formTest");
	    	
	    }
}
