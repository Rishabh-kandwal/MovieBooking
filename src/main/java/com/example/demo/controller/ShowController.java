package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Movie;
import com.example.demo.Model.Show;
import com.example.demo.service.MovieServices;
import com.example.demo.service.ShowServices;

@RestController
@RequestMapping(value = "/api")
public class ShowController {
	private ShowServices Sservices = new ShowServices();
	private MovieServices Mserv = new MovieServices();

	@PostMapping("/show")
	public ResponseEntity<Show> saveShow(@Validated @RequestBody Show show) {
		try {
			Movie movie = null;
			if (show.getMovie().getMid() > 0) {
				Optional<Movie> om = Mserv.getSingleMovieById(show.getMovie().getMid());
				if (om.isPresent()) {
					movie = om.get();
				} else {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie with ID " +
					// movie.getMid() + " not found");
				}
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie with ID " +
				// show.getSid() + " not found");
			}

			show.setMovie(movie);
			Show savedshow = Sservices.saveShows(show);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedshow);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/show")
	public ResponseEntity<List<Show>> getAllShows() {
		try {
			List<Show> Shows = Sservices.listAllShows();
			return ResponseEntity.ok(Shows);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/show/{id}")
//	public ResponseEntity<Show> getShowById(@PathVariable(value="id") int pId)
//				throws ResourceNotFoundException

	public ResponseEntity<Show> getSingleShowById(@PathVariable int id)
			throws com.example.demo.exception.ResourceNotFoundException {

		Optional<Show> show = Sservices.getSingleShowById(id);
		if (show.isPresent()) {
			return new ResponseEntity<>(show.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
