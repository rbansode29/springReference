package com.example.demo.services;

// required bean has been defined into Java configuration file
//@Component
//@Profile("default")
public class HelloWorldServiceDefaultImpl implements HelloWorldService {

	@Override
	public String SayHello() {
		// TODO Auto-generated method stub
		return "Default Profile";
	}

}
