package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cdac.training.productrest.model.Product;
import com.example.demo.Model.Movie;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ShowRepository;

@Service
public class MovieServices {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private ActorRepository actorRepository;

	public Movie saveMovieWithShows(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie saveMovie(Movie movie) {
		try {
			Movie savedMovie = movieRepository.save(movie);

			return savedMovie;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Movie> listAllMovie() {

		return movieRepository.findAll(); // Defined in JPA repo.
	}

	public Optional<Movie> getSingleMovieById(int id) {
		return movieRepository.findById(id); // Defined in JPA repo.
	}

	public Optional<Movie> getSingleMovieByName(String name) {
//		return movieRepository.findByMovieName(name); // Defined in JPA repo.
		return null;
	}

	public void deleteMovieById(int id) {
		movieRepository.deleteById(id); // Defined in JPA repo.
	}

	public void deleteMovieByName(String name) {
//		movieRepository.deleteMovieByName(name); // Defined in JPA repo.
	}

}
