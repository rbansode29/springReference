package com.spring.lifecycle;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// loading the definitions from the given XML file
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SpringLifeCycle springLifeCycle = (SpringLifeCycle) context.getBean("springLifeCycle");
		System.out.println(springLifeCycle.getStepCounter());
		
		context.registerShutdownHook();
	}

}
