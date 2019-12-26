package com.spring.javajee.beanwrapper;

public class Company {
	private String name;
	private Employee managingDirector;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManagingDirector() {
		return this.managingDirector;
	}

	public void setManagingDirector(Employee managingDirector) {
		this.managingDirector = managingDirector;
	}

	@Override
	public String toString() {		
		return "Name : "+ this.name + " Employee : " + this.managingDirector;
	}
	
	
}
