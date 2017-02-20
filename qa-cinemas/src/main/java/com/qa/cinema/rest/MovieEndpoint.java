package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinemas.service.MovieService;

@Path("/movie")
public class MovieEndpoint {
	@Inject
	private MovieService mService;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllMovies(){
		return mService.listAllMovies();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public  String addMovie(String Movie){
		return mService.createMovie(Movie);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public  String updateMovie(@PathParam("id") Long movieID, String Movie){
		return mService.updateMovie(movieID, Movie);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public  String deleteMovie(@PathParam("id") Long movieID){
		return mService.deleteMovie(movieID);
	}
}
