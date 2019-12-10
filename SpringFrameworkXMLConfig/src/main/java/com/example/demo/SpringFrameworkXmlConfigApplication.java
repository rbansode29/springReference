package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.example.demo.controller.GreetingController;

@SpringBootApplication
//no component scan needed
@ImportResource("classpath:/spring/spring-config.xml")
public class SpringFrameworkXmlConfigApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringFrameworkXmlConfigApplication.class, args);
		GreetingController greetingController = (GreetingController) ctx.getBean(GreetingController.class);
		greetingController.getMessage();
	}
}
