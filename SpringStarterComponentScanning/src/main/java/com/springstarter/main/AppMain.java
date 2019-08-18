package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.services.SimpleMovieLister;

public class AppMain {

	public static void main(String[] args) {
		// Instantiating a container
		// ApplicationContext context =new ClassPathXmlApplicationContext(new String[]
		// {"services.xml", "daos.xml"});
		
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SimpleMovieLister l_simpleMovieLister = (SimpleMovieLister)l_appContext.getBean("simpleMovieLister");
		l_simpleMovieLister.callDisplayMe();
	}

}
