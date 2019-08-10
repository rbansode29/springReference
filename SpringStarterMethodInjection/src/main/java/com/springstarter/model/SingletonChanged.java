package com.springstarter.model;

public abstract class SingletonChanged {

	protected abstract Prototype createPrototype();

	public SingletonChanged() {
		// TODO Auto-generated constructor stub
	}

	public void doSomething() {

		createPrototype().foo();
	}

	public void doSomethingElse() {

		createPrototype().bar();
	}

}
