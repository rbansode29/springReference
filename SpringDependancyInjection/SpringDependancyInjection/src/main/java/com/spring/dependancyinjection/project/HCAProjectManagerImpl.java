package com.spring.dependancyinjection.project;

public class HCAProjectManagerImpl implements ProjectManager {

	private String managerName;
	private int yearOfExperience;

	public HCAProjectManagerImpl(final String managerName, final int yearOfExperience) {
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
