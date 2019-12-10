package com.example.demo.services;

// required bean has been defined into Java configuration file
//@Component
//@Profile("spanish")
public class HelloWorldServiceSpanishImpl implements HelloWorldService {

	@Override
	public String SayHello() {
		// TODO Auto-generated method stub
		return "Helo Mondeee!!";
	}

}
