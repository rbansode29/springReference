package com.springstarter.requiredannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class SimpleMovieLister {

	private MovieFinder movieFinder;

	public SimpleMovieLister() {
		// TODO Auto-generated constructor stub
	}

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	@Required
	/*
	 * the above annotation made the property value mandatory. if this property
	 * value is not specified the error has been show
	 */
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	public void showMovie() {
		movieFinder.playMovie();
	}

}
