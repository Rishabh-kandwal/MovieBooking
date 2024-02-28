package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServices {
	@Autowired
	private AdminRepository Arepo;

	public Admin SavingAdmin(Admin ad) {
		return Arepo.save(ad);
	}

	public Optional<Admin> loginAdmin(long id) {
		System.out.print(id);
		return Arepo.findById(id); // Invoke Custom method
	}

}
