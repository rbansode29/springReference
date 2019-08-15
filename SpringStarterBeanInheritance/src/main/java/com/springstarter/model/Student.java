package com.springstarter.model;

/**
 * A child bean definition inherits constructor argument values, property
 * values, and method overrides from the parent, with the option to add new
 * values. Any initialization method, destroy method, and/or static factory
 * method settings that you specify will override the corresponding parent
 * settings.
 * 
 * The remaining settings are always taken from the child definition: depends
 * on, autowire mode, dependency check, singleton, scope, lazy init.
 */

public class Student extends Person {

	private String address;

	public Student() {
		System.out.println("inside the Student Constructor");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void displayDetail() {
		System.out.println("First Name :" + firstName + "Middle Name : " + middleName + "Last Name : " + lastName
				+ "Adress : " + address);
	}

}
