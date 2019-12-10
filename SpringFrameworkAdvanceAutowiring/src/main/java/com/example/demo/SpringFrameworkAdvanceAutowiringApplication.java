package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.controller.GreetingController;

@SpringBootApplication
public class SpringFrameworkAdvanceAutowiringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringFrameworkAdvanceAutowiringApplication.class,
				args);
		GreetingController greetingController = (GreetingController) ctx.getBean("greetingController");
		greetingController.getGreeting();
	}

}
