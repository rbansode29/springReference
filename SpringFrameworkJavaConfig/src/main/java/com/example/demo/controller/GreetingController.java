package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.services.HelloWorldService;

@Controller
public class GreetingController {

	private HelloWorldService helloWorldService;

	@Autowired
	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	public String getGreeting() {
		String greeting = helloWorldService.SayHello();
		System.out.println(greeting);
		return greeting;
	}

}
