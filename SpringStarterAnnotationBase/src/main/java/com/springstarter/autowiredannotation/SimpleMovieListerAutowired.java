package com.springstarter.autowiredannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleMovieListerAutowired {

	@Autowired
	/*
	 * the above annotation made it mandatory to specify the property value
	 * byType.it will automatically bind the property through config. some variation
	 * with property :
	 * 
	 * @Autowired(required=false) :No Exception when zero bean found for mentioned
	 * property recommended over @Required annotation because it can not strongly
	 * force for property fulfillment.
	 */
	private MovieFinderAutowired movieFinderAutowired;

	public SimpleMovieListerAutowired() {
		// TODO Auto-generated constructor stub
	}

	public MovieFinderAutowired getMovieFinderAutowired() {
		return movieFinderAutowired;
	}

	public void setMovieFinderAutowired(MovieFinderAutowired movieFinderAutowired) {
		this.movieFinderAutowired = movieFinderAutowired;
	}

	public void playMovie() {
		movieFinderAutowired.playMovie();
	}
}
