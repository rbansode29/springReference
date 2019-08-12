package com.springstarter.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorldDemo implements InitializingBean, DisposableBean {

	public HelloWorldDemo() {
		System.out.println("Inside Constructor");
		// TODO Auto-generated constructor stub
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Inside HelloWorldDemo::setName() method");
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Hello World by " + name);
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside HelloWorldDemo::destroy() method ");

	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside HelloWorldDemo::afterPropertiesSet() method");
	}

	public void init() {
		System.out.println("Inside custom HelloWorldDemo::init() method");
	}

	public void destroyed() {
		System.out.println("Inside custom HelloWorldDemo::destroyed() method");
	}
	
	@PostConstruct
	public void initUsingPostConstruct() {
		System.out.println("Inside @PostConstruct HelloWorldDemo::initUsingPostConstruct() method");
	}
	
	@PreDestroy	
	public void destroyUsingPreDestroy() {
		System.out.println("Inside @PreDestroy HelloWorldDemo::destroyUsingPreDestroy() method");
	}
	
	
}
