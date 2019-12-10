package com.example.demo;

import org.apache.catalina.core.ApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.demo.controllers.GreetingController;

@SpringBootApplication
public class SpringFrameworkDefaultProfilingApplication {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = (AbstractApplicationContext) SpringApplication
				.run(SpringFrameworkDefaultProfilingApplication.class, args);
		GreetingController greetingController = (GreetingController)ctx.getBean(GreetingController.class);
		greetingController.sayHello();
		ctx.registerShutdownHook();

	}

}
