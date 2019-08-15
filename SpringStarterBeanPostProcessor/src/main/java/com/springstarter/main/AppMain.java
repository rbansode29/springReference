package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.model.BasicDataSource;
import com.springstarter.model.DefaultStrategy;
import com.springstarter.model.InstanceValidatorImpl;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		//InstanceValidatorImpl l_instanceValidator = (InstanceValidatorImpl) l_appContext
		//		.getBean("instanceValidatorImpl");
		//l_instanceValidator.display();
		
		BasicDataSource l_dataSource = (BasicDataSource)l_appContext.getBean("dataSource");
		System.out.println("Driver Name - "+l_dataSource.getDriverClassName());
		System.out.println("URL - "+l_dataSource.getUrl());
		
		DefaultStrategy l_defaultStrategy = (DefaultStrategy)l_appContext.getBean("serviceStrategy");
		l_defaultStrategy.display();
	}

}
