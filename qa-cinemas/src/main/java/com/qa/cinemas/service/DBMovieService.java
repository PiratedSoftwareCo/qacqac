package com.qa.cinemas.service;

import java.util.Collection;
import java.util.Collections;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Movie;
import com.qa.cinemas.util.JSONUtil;

@Stateless
@Default
public class DBMovieService implements MovieService {

	@PersistenceContext(unitName = "primary")
	private EntityManager EM;
	
	@Inject
	private JSONUtil mUtil;
	
	@Override
	public String listAllMovies() {
		Query query = EM.createQuery("SELECT e FROM Movie e");
		Collection<Movie> movies = (Collection<Movie>)query.getResultList();
		return mUtil.getJSONForObject(movies);
	}

	@Override
	public String createMovie(String Movie) {
		Movie newMovie = mUtil.getObjectForJSON(Movie, Movie.class);
		EM.persist(newMovie);
		return "{\"Message\" : \"movie added\"}";
	}

	@Override
	public String updateMovie(Long movieID, String Movie) {
		Movie newMovie = mUtil.getObjectForJSON(Movie, Movie.class);
		Movie oldMovie = findMovie(new Long(movieID));
		if(Movie != null){
			oldMovie = newMovie;
			EM.merge(oldMovie);
		}
		return "{\"Message\" : \"movie update\"}";
	}

	@Override
	public String deleteMovie(Long movieID) {
		Movie movie = findMovie(new Long(movieID));
		if(movie != null){
			EM.remove(movie);
		}
		return "{\"Message\" : \"movie removed\"}";
	}
	
	private Movie findMovie(Long id) {
		return EM.find(Movie.class, id);
	}

}
