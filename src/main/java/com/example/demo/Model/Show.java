package com.example.demo.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "show_table")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	LocalDate showdate;
	LocalTime showtime;
	String showlanguage;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mid")
	private Movie movie;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public LocalDate getShowdate() {
		return showdate;
	}

	public void setShowdate(LocalDate showdate) {
		this.showdate = showdate;
	}

	public LocalTime getShowtime() {
		return showtime;
	}

	public void setShowtime(LocalTime showtime) {
		this.showtime = showtime;
	}

	public String getShowlanguage() {
		return showlanguage;
	}

	public void setShowlanguage(String showlanguage) {
		this.showlanguage = showlanguage;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
