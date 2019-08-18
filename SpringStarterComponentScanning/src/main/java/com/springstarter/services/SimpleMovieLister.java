package com.springstarter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleMovieLister {

	private MovieFinder movieFinder;

	public SimpleMovieLister() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public SimpleMovieLister(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	public void callDisplayMe() {
		System.out.println("You are inside SimpleMovieLister::callDisplayMe method");
		movieFinder.findMovie();
	}

}
