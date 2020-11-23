package com.Sandar.demo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sandar.demo.models.Student;
import com.Sandar.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void saveStudent(String name, String password, String code,String nrc, String fatherName, String gender, Date dateOfBirth,
			String phNo,String email, String contactAddress, String knownFrom, String education, String otherQualification, String imageUrl) {
		
		Student student = new Student();
		student.setName(name);
		student.setCode(code);
		student.setFathereName(fatherName);
		student.setNrc(nrc);
		student.setDateOfBirth(dateOfBirth);
		student.setGender(gender);
		student.setPassword(password);
		student.setContactAddress(contactAddress);
		student.setPhoneNumber(phNo);
		student.setImageUrl(imageUrl);
		student.setKnownFrom(knownFrom);
		student.setOtherQualification(otherQualification);
		student.setEmail(email);
		
		studentRepository.save(student);
		
	}

}
