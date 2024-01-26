package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.user;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class UserServices 
{
	@Autowired
	private UserRepository drepo;
	
	public user registerUser(user d) {
		return drepo.save(d);
	}
	
	public Optional<user> loginUser(String email) {

		return drepo.findByEmail(email); // Invoke Custom method
	}

	
	
}
