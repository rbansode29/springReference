package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.autowiredannotation.SimpleMovieListerAutowired;
import com.springstarter.qualifierannotation.QualifierAnnotation;
import com.springstarter.requiredannotation.SimpleMovieLister;
import com.springstarter.resourceannotation.MovieRecommender;

public class AppMain {

	public static void main(String[] args) {

		// Instantiating a container
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext(new String[] { "autowiredannotation.xml",
				"qualifierannotation.xml", "requiredannotation.xml", "resourceannotation.xml" });

		// @Required annotation example - for cross check comment out the property tag
		SimpleMovieLister l_simpleMovieLister = (SimpleMovieLister) l_appContext.getBean("simpleMovieLister");
		l_simpleMovieLister.showMovie();

		// @Autowire annotation example -
		SimpleMovieListerAutowired l_simpleMovieListerAutowire = (SimpleMovieListerAutowired) l_appContext
				.getBean("simpleMovieListerAutowired");
		l_simpleMovieListerAutowire.playMovie();

		// @Qualifier annotation example -
		QualifierAnnotation l_qualifierAnnotation = (QualifierAnnotation) l_appContext.getBean("qualifierAnnotation");
		l_qualifierAnnotation.getQualification();
		
		//@Resource annotation example - 
		MovieRecommender l_movieRecommender = (MovieRecommender)l_appContext.getBean("movieRecommender");
		l_movieRecommender.showCustomer();

	}

}
