package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.demo.services.HelloWorldService;

@Controller
public class GreetingController {
	private HelloWorldService helloWorldService;

	private HelloWorldService helloWorldServiceGermanImpl;

	@Autowired
	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@Autowired
	@Qualifier("helloWorldServiceGermanImpl")
	public void setHelloWorldServiceGermanImpl(HelloWorldService helloWorldServiceGermanImpl) {
		this.helloWorldServiceGermanImpl = helloWorldServiceGermanImpl;
	}

	public String getGreeting() {
		String greeting = helloWorldService.sayHello();

		System.out.println(greeting);

		System.out.println(helloWorldServiceGermanImpl.sayHello());

		return greeting;
	}

}
