package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.model.HelloWorldDemo;

public class AppMain {

	public static void main(String[] args) {
		// Instantiating a container
		// ApplicationContext context =new ClassPathXmlApplicationContext(new String[]
		// {"services.xml", "daos.xml"});
		AbstractApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		l_appContext.registerShutdownHook();

		HelloWorldDemo l_helloWorldDemo = (HelloWorldDemo) l_appContext.getBean("helloWorldDemo");
		l_helloWorldDemo.sayHello();

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.close();

	}

}
