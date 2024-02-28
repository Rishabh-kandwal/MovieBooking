package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Show;
import com.example.demo.repository.ShowRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class ShowServices 
{
	@Autowired
	private ShowRepository Srepo;
	@Transactional
	public Show saveShows(Show s) {
		return Srepo.save(s);   // Invokes save() method predefined in JPA repo
	}
	
	@Transactional
	 public List<Show> listAllShows(){
	 		
	 		return Srepo.findAll(); //Defined in JPA repo.
	 	}
	

	@Transactional
	 public Optional<Show> getSingleShowById(int id){
			return Srepo.findById(id); // Defined in JPA repo.
		}

	@Transactional
	 public void deleteShowById(int id) {
		 Srepo.deleteById(id); // Defined in JPA repo.
	}

	
	
	
}
