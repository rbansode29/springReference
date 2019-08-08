package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.model.HelloWorldDemo;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorldDemo l_helloWorldDemo = (HelloWorldDemo) l_appContext.getBean("helloWorldDemo");
		l_helloWorldDemo.sayHello();
		
		//Instantiating a container
		//ApplicationContext context =new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});
	}

}
