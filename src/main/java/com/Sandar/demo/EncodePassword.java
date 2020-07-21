package com.Sandar.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {
	public static void main(String args[]){
		String password = "123";
		BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		String hashPassword = passwordEncoder.encode(password);
		System.out.println(hashPassword);
	}
}
