package com.Sandar.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Sandar.demo.formmodels.StudentFormModel;
import com.Sandar.demo.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	 @GetMapping("/admin/addStudent")
	    public ModelAndView addNewStudent(StudentFormModel studentFormModel) {
	        return new ModelAndView("student/addStudent");
	    }
	    
	    @RequestMapping(value = "/admin/addStudent", method=RequestMethod.POST)
	    public  String handleNewStudent(@Valid StudentFormModel studentFormModel, BindingResult bindingResult) {
	    	
	    	if(bindingResult.hasErrors()) {
	    		System.out.println("has error");
	    		return "admin/Student/addNewStudent";
	    	}
	    	
	    	
	    	
	    	System.out.println("successfully");
	    	
	    	
	    	
	        return "redirect:/admin/addStudent";
	    }
}
