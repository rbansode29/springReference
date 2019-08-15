package com.springstarter.model;

/**
 * ApplicationContext pre-instantiates all singletons by default. Therefore, it
 * is important (at least for singleton beans) that if you have a (parent) bean
 * definition which you intend to use only as a template, and this definition
 * specifies a class, you must make sure to set the abstract attribute to true,
 * otherwise the application context will actually (attempt to) pre-instantiate
 * the abstract bean.
 **/

public class SingletonWithAbstract {

	private String singletonWithAbstract;

	public SingletonWithAbstract() {
		System.out.println("inside the SingletonWithAbstract constructor");
	}

	public String getSingletonWithAbstract() {
		return singletonWithAbstract;
	}

	public void setSingletonWithAbstract(String singletonWithAbstract) {
		this.singletonWithAbstract = singletonWithAbstract;
	}

	public void display() {
		System.out.println("inside display of SingletonWithAbstract. property value - " + singletonWithAbstract);
	}

}
