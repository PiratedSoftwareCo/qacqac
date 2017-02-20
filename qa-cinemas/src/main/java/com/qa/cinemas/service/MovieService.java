package com.qa.cinemas.service;

public interface MovieService {
	String listAllMovies();
	String createMovie(String Movie);
	String updateMovie(Long movieID, String Movie);
	String deleteMovie(Long movieID);
}
