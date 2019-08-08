package com.springstarter.setter;

public class SimpleMovieListerSetter {

	private MovieFinderSetter movieFinderSetter;

	public SimpleMovieListerSetter() {
	}

	public MovieFinderSetter getMovieFinderSetter() {
		return movieFinderSetter;
	}

	public void setMovieFinderSetter(MovieFinderSetter movieFinderSetter) {
		this.movieFinderSetter = movieFinderSetter;
	}

	public void showMovieList() {
		movieFinderSetter.showMovie();
	}

}
