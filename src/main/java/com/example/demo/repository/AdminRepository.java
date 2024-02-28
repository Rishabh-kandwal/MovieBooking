package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Admin;


public interface AdminRepository extends JpaRepository<Admin,Long>
{

}
