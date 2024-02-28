package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Seat;
import com.example.demo.repository.SeatRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SeatServices {
	@Autowired
	private SeatRepository Srepo;

	@Transactional
	public Seat saveSeat(Seat s) {
		return Srepo.save(s);
	}

	@Transactional
	public List<Seat> listAllSeat() {

		return Srepo.findAll();
	}
	@Transactional
	 public Optional<Seat> getSingleSeatById(int id){
			return Srepo.findById(id); 
		}
	
}
