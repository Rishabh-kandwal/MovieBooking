package com.example.demo.controller;

import java.util.List;

//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Movie;
import com.example.demo.Model.user;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserServices;

@RestController
@RequestMapping(value="/api")

public class UserController 
{
	@Autowired
	private UserServices dservice;
	@PostMapping("/user")
	public ResponseEntity<user> saveProduct(@Validated @RequestBody user use)
	{
		   
		try {
			user p=dservice.registerUser(use);
				return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<user>> getAllUser() {
		try {
			List<user> use = dservice.listAllUser();
			return ResponseEntity.ok(use);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/loginUser")
	public ResponseEntity<Boolean> loginUser(@Validated @RequestBody user use) throws ResourceNotFoundException
	{
		Boolean isAuthenticated = false;
		String email=use.getEmail();
		String password=use.getPassword();
		
		user d = dservice.loginUser(email).orElseThrow(() ->
		new ResourceNotFoundException("User not found for this email :: " + email));
		
		if(email.equals(d.getEmail()) && password.equals(d.getPassword()))
		{
			isAuthenticated = true;

		}
		
		return ResponseEntity.ok(isAuthenticated);
	}
	
}
