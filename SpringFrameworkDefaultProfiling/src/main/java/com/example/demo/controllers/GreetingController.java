package com.example.demo.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.demo.services.HelloWorldService;

@Controller
@Component
public class GreetingController {
	private HelloWorldService helloWorldService;

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	public String sayHello() {
		String greeting = helloWorldService.getGreeting();
		System.out.println(greeting);
		return greeting;
	}

}
