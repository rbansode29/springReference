package com.example.demo.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.services.HelloWorldService;
import com.example.demo.services.HelloWorldServiceDefaultImpl;
import com.example.demo.services.HelloWorldServiceEnglishImpl;
import com.example.demo.services.HelloWorldServiceSpanishImpl;

@Configuration
public class HelloWorldConfig {

	@Bean
	@Profile("default")
	public HelloWorldService helloWorldServiceDefaultImpl() {
		return new HelloWorldServiceDefaultImpl();
	}

	@Bean
	@Profile("english")
	public HelloWorldService helloWorldServiceEnglishImpl() {
		return new HelloWorldServiceEnglishImpl();
	}

	@Bean
	@Profile("spanish")
	public HelloWorldService helloWorldServicespanishImpl() {
		return new HelloWorldServiceSpanishImpl();
	}

}
