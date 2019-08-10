package com.springstarter.model;

public class Singleton {

	public Singleton() {
		// TODO Auto-generated constructor stub
	}

	private Prototype prototype;

	public Singleton(Prototype prototype) {

		this.prototype = prototype;
	}

	public void doSomething() {

		prototype.foo();
	}

	public void doSomethingElse() {

		prototype.bar();
	}

}
