package com.example.demo.services;

// required bean has been defined into Java configuration file
//@Component
//@Profile("english")
public class HelloWorldServiceEnglishImpl implements HelloWorldService {

	@Override
	public String SayHello() {
		// TODO Auto-generated method stub
		return "Hello World!!";
	}

}
