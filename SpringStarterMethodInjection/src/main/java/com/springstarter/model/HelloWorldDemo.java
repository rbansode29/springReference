package com.springstarter.model;

public class HelloWorldDemo {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.print("Hello World by " + name);
	}
}
