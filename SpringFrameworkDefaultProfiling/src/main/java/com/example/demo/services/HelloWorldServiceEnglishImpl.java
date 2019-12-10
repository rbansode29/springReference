package com.example.demo.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class HelloWorldServiceEnglishImpl implements HelloWorldService {

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Hello World !!!";
	}

}
