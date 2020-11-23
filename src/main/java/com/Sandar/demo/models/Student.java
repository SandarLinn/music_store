package com.Sandar.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	private long id;
	private String name;
	private String password;
	private String code;
	
	@Column(name="father_name")
	private String fathereName;
	
	private String nrc;
	private String gender;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="contact_address")
	private String contactAddress;
	
	@Column(name="know_from")
	private String knownFrom;
	
	@Column(name="student_education")
	private String studentEducation;
	
	@Column(name="other_qualification")
	private String otherQualification;
	
	@Column(name="image_url")
	private String imageUrl;
	
	public Student() {
		
	}

	public Student( Student student) {
		super();
		this.name = student.getName();
		this.password = student.getPassword();
		this.code = student.getCode();
		this.fathereName = student.getFathereName();
		this.nrc = student.getNrc();
		this.gender = student.getGender();
		this.email = student.getEmail();
		this.phoneNumber = student.getPhoneNumber();
		this.contactAddress = student.getContactAddress();
		this.knownFrom = student.getKnownFrom();
		this.studentEducation = student.getStudentEducation();
		this.otherQualification = student.getOtherQualification();
		this.imageUrl = student.getImageUrl();
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFathereName() {
		return fathereName;
	}

	public void setFathereName(String fathereName) {
		this.fathereName = fathereName;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getKnownFrom() {
		return knownFrom;
	}

	public void setKnownFrom(String knownFrom) {
		this.knownFrom = knownFrom;
	}

	public String getStudentEducation() {
		return studentEducation;
	}

	public void setStudentEducation(String studentEducation) {
		this.studentEducation = studentEducation;
	}

	public String getOtherQualification() {
		return otherQualification;
	}

	public void setOtherQualification(String otherQualification) {
		this.otherQualification = otherQualification;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
