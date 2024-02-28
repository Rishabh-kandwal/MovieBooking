package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Actors;
import com.example.demo.Model.Movie;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.MovieServices;
import com.example.demo.service.ShowServices;

@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	private MovieServices Mservices;

	@Autowired
	private ShowServices Sserv;

	@PostMapping("/movie")
	public ResponseEntity<Movie> savemovies(@Validated @RequestBody Movie movies) {
		try {
			List<Actors> act=movies.getActors();
			for(Actors a:act) 
			{
				
			}
			Movie saveMovie = Mservices.saveMovie(movies);
			return ResponseEntity.ok(saveMovie);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/movie")
	public ResponseEntity<List<Movie>> getAllMovie() {
		try {
			List<Movie> movies = Mservices.listAllMovie();
			return ResponseEntity.ok(movies);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/Movie/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") int pId)
			throws com.example.demo.exception.ResourceNotFoundException {
		try {
			Movie m = Mservices.getSingleMovieById(pId)
					.orElseThrow(() -> new ResourceNotFoundException("Movie Not Found for this Id :" + pId));

			return ResponseEntity.ok().body(m);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	@GetMapping("/Movie/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable(value = "name") String name)
			throws ResourceNotFoundException {
		try {

			Movie movie = Mservices.getSingleMovieByName(name)
					.orElseThrow(() -> new ResourceNotFoundException("Movie Not Found for this name :" + name));
			return ResponseEntity.ok().body(movie);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping("/Movie/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMovie(@PathVariable(value = "id") int id)
			throws ResourceNotFoundException {

		try {
			Mservices.getSingleMovieById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Movie Not found for this Id :" + id));
			Mservices.deleteMovieById(id);
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deleted", true);
			return ResponseEntity.ok(response);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping("/Movie/{name}")
	public ResponseEntity<Map<String, Boolean>> deleteMovieByName(@PathVariable(value = "name") String name)
			throws ResourceNotFoundException {

		try {
			Mservices.getSingleMovieByName(name)
					.orElseThrow(() -> new ResourceNotFoundException("Movie Not found for this name :" + name));
			Mservices.deleteMovieByName(name);
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deleted", true);
			return ResponseEntity.ok(response);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
