package com.spring.dependancyinjection.project;

public class HCSProjectManagerImpl implements ProjectManager {

	private String managerName;
	private int yearOfExperience;

	public HCSProjectManagerImpl(final String managerName, final int yearOfExperience) {
		super();
		this.managerName = managerName;
		this.yearOfExperience = yearOfExperience;
	}

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public String getManagerName() {
		return managerName;
	}

}
