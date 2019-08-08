package com.springstarter.constructor;

public class ExampleBean {

	private int years;
	private String ultimateAnswer;

	public ExampleBean() {
		// TODO Auto-generated constructor stub
	}

	
	//@ConstructorProperties({"years", "ultimateAnswer"})
	public ExampleBean(int years, String ultimateAnswer) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}

}
