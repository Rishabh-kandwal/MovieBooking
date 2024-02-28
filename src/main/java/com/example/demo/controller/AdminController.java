package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Admin;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.AdminServices;

@RestController
@RequestMapping(value = "/api")
public class AdminController {
	@Autowired
	private AdminServices Aservice;

	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdmin(@Validated @RequestBody Admin Adn) {

		try {
			Admin a = Aservice.SavingAdmin(Adn);
			return ResponseEntity.status(HttpStatus.CREATED).body(a);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/loginAdmin")
	public ResponseEntity<Boolean> loginAdmin(@Validated @RequestBody Admin ad) throws ResourceNotFoundException {
		try {
		System.out.println(ad.getAid() + " : " + ad.getPassword());
		Boolean isAuthenticated = false;
		long id = ad.getAid();
		String password = ad.getPassword();
		System.out.println(id);
		Admin d = Aservice.loginAdmin(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		if (id == d.getAid() && password.equals(d.getPassword())) {
			isAuthenticated = true;

		}

		return ResponseEntity.ok(isAuthenticated);}
		catch(Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
