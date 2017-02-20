package com.qa.cinemas.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class MapMovieService implements MovieService {

	@Override
	public String listAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createMovie(String Movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMovie(Long movieID, String Movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovie(Long movieID) {
		// TODO Auto-generated method stub
		return null;
	}

}
