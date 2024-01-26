package com.example.demo.Model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
public class user 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long pid;
	 private String fname;
	 private String lname;
	 private String password;
	 private String email;
	 public void setPassword(String password) {
			Base64.Encoder encoder = Base64.getEncoder();  
	        String normalString = password;
	        String encodedString = encoder.encodeToString(   
	        normalString.getBytes(StandardCharsets.UTF_8) );
	        this.password = encodedString;
		}
}
