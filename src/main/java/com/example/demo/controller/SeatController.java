package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Seat;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.SeatServices;

@RestController
@RequestMapping("/api")
public class SeatController // saveSeat,getAllSeats,getSeatById,
{
	@Autowired
	private SeatServices Sservices;
//	@Autowired
//	private TheaterServices Tserv;

	@PostMapping("/seat")
	public ResponseEntity<Seat> saveSeat(@Validated @RequestBody Seat seat) {
		try {

			Seat savedSeat = Sservices.saveSeat(seat);

			return ResponseEntity.status(HttpStatus.CREATED).body(savedSeat);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/seat")
	public ResponseEntity<List<Seat>> getAllSeats() {
		try {
			List<Seat> Seats = Sservices.listAllSeat();
			return ResponseEntity.ok(Seats);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/seat/{id}")
	public ResponseEntity<Seat> getSeatById(@PathVariable(value = "id") int pId)
			throws com.example.demo.exception.ResourceNotFoundException {
		try {
			Seat m = Sservices.getSingleSeatById(pId)
					.orElseThrow(() -> new ResourceNotFoundException("Movie Not Found for this Id :" + pId));

			return ResponseEntity.ok().body(m);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

}
