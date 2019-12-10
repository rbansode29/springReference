package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RequestProcessor processor = (RequestProcessor)applicationContext.getBean("processor");
		for (int i=0;i<3;i++){
			ResourceA resource = processor.getResourceA();
			System.out.println(resource.getUrl());
		}
		for (int i=0;i<3;i++){
			ResourceB resource = processor.getResourceB();
			System.out.println(resource.getUrl());
		}
	}


}
