package com.example.demo.controller;

import com.example.demo.services.HelloWorldService;

public class GreetingController {

	private HelloWorldService helloWorldService;

	private HelloWorldService helloWorldServiceEnglishImpl;

	private HelloWorldService helloWorldServiceSpanishImpl;

	public void setHelloWorldServiceEnglishImpl(HelloWorldService helloWorldServiceEnglishImpl) {
		this.helloWorldServiceEnglishImpl = helloWorldServiceEnglishImpl;
	}

	public void setHelloWorldServiceSpanishImpl(HelloWorldService helloWorldServiceSpanishImpl) {
		this.helloWorldServiceSpanishImpl = helloWorldServiceSpanishImpl;
	}

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	public void getMessage() {
		String greeting = helloWorldService.getMessage();
		System.out.println(greeting);
	}

}
