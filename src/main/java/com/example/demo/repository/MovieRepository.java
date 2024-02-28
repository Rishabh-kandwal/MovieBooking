package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Movie;
import com.example.demo.Model.Show;

import jakarta.transaction.Transactional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

//	@Query("SELECT m FROM Movie m WHERE m.MovieName = :name")
//	Optional<Movie> findByMovieName(String name);
//
//	@Query("DELETE FROM Movie m WHERE m.movieName = :movieName")
//	void deleteMovieByName(@Param("movieName") String movieName);
//	@Query("SELECT s FROM Show s WHERE s.movie = :movie")
//	List<Show> findShowsByMovie(Movie movie);
//	 //Retrieve shows associated with a movie
//
//	    @Modifying
//	    @Transactional
//	    void deleteShowsByMovie(Movie movie);

}
