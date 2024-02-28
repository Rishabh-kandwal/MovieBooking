package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Actors;

public interface ActorRepository extends JpaRepository<Actors, Integer> {

}
