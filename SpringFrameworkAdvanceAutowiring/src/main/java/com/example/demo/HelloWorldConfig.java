package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.example.demo.factory.HelloWorldFactory;
import com.example.demo.services.HelloWorldService;

@Configuration
public class HelloWorldConfig {

	@Bean
	public HelloWorldFactory helloWorldFactory() {
		return new HelloWorldFactory();
	}

	@Bean
	@Profile("english")
	@Primary // this annotation is used to made the default or first bean among multipal same
				// bean present if any
	public HelloWorldService helloWorldServiceEnglishImpl(HelloWorldFactory helloWorldFactory) {
		return helloWorldFactory.createHelloWorldService("EN");
	}

	@Bean
	@Profile("spanish")
	@Primary
	public HelloWorldService helloWorldServiceSpanishImpl(HelloWorldFactory helloWorldFactory) {
		return helloWorldFactory.createHelloWorldService("SP");
	}

	@Bean(name = "french")
	public HelloWorldService helloWorldServiceFrenchImpl(HelloWorldFactory helloWorldFactory) {
		return helloWorldFactory.createHelloWorldService("FR");
	}

	@Bean(name = "german")
	public HelloWorldService helloWorldServiceGermanImpl(HelloWorldFactory helloWorldFactory) {
		return helloWorldFactory.createHelloWorldService("GM");
	}

	@Bean
	public HelloWorldService helloWorldServiceRussionImpl(HelloWorldFactory helloWorldFactory) {
		return helloWorldFactory.createHelloWorldService("RU");
	}

	@Bean
	public HelloWorldService helloWorldServiceKoreanImpl(HelloWorldFactory helloWorldFactory) {
		return helloWorldFactory.createHelloWorldService("KO");
	}
}
