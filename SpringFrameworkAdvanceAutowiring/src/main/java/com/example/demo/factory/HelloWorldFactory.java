package com.example.demo.factory;

import com.example.demo.service.HelloWorldServiceDefaultImpl;
import com.example.demo.service.HelloWorldServiceEnglishImpl;
import com.example.demo.service.HelloWorldServiceGermanImpl;
import com.example.demo.service.HelloWorldServiceSpanishImpl;
import com.example.demo.services.HelloWorldService;

public class HelloWorldFactory {

	public HelloWorldService createHelloWorldService(String language) {
		HelloWorldService helloWorldService = null;
		switch (language) {
		case "EN":
			helloWorldService = new HelloWorldServiceEnglishImpl();
			break;
		case "SP":
			helloWorldService = new HelloWorldServiceSpanishImpl();
			break;
		case "FR":
			helloWorldService = new HelloWorldServiceFrenchtImpl();
			break;
		case "GM":
			helloWorldService = new HelloWorldServiceGermanImpl();
			break;
		default:
			helloWorldService = new HelloWorldServiceDefaultImpl();
		}
		return helloWorldService;
	}

}
