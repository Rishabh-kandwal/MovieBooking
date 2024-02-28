package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Sid;
	String SeatName;
	int NoOfSeat;

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSeatName() {
		return SeatName;
	}

	public void setSeatName(String seatName) {
		SeatName = seatName;
	}

	public int getNoOfSeat() {
		return NoOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		NoOfSeat = noOfSeat;
	}

}
