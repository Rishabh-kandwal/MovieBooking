package com.example.demo.Model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Aid;

	private String password;

//	@JsonIgnore
//	@ManyToOne(targetEntity=Theater.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "Tid")
//	Theater Theaters;

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = password;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		this.password = encodedString;
	}

	public long getAid() {
		return Aid;
	}

	public void setAid(long aid) {
		Aid = aid;
	}

	public String getPassword() {
		return password;
	}

}
