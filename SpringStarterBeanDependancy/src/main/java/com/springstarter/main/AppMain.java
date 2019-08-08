package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.constructor.SimpleMovieLister;
import com.springstarter.setter.SimpleMovieListerSetter;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//construtor based dependency
		SimpleMovieLister l_simpleMovieLister = (SimpleMovieLister) l_appContext.getBean("simpleMovieListerCons");
		l_simpleMovieLister.showMovieList();
		
		//setter based dependency
		SimpleMovieListerSetter l_simpleMovieListerSetter = (SimpleMovieListerSetter)l_appContext.getBean("simpleMovieListerSetterCons");
		l_simpleMovieListerSetter.showMovieList();
	}

}
