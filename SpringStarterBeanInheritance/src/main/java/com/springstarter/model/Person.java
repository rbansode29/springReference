package com.springstarter.model;

public class Person {

	protected String firstName;	
	protected String middleName;
	protected String lastName;

	public Person() {
		System.out.println("inside the Person Constructor");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void displayDetail() {
		System.out.println("First Name :" + firstName + "Middle Name : " + middleName + "Last Name : " + lastName);
	}

}
