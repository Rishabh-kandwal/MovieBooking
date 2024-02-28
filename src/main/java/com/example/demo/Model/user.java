package com.example.demo.Model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uid;

	private String fname;

	private String lname;

	private String password;

	@Column(unique = true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "fk_uid", referencedColumnName = "uid")
	List<Booking> l;

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = password;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		this.password = encodedString;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Booking> getL() {
		return l;
	}

	public void setL(List<Booking> l) {
		this.l = l;
	}

	public String getPassword() {
		return password;
	}

}
