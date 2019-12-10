package com.example.demo.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("spanish")
public class HelloWorldServiceSpanishImpl implements HelloWorldService {

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Hole Monde!!!";
	}

}
