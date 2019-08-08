package com.springstarter.constructor;

public class SimpleMovieLister {

	private MovieFinder movieFinder;

	public SimpleMovieLister(final MovieFinder p_movieFinder) {
		movieFinder = p_movieFinder;
	}

	public void showMovieList() {
		movieFinder.showMovie();
	}

}
