package com.spring.dependancyinjection.project;

public class HCAProjectImpl implements Project {

	private ProjectManager projectManager;

	public HCAProjectImpl() {
		System.out.println("inside HCA project Implementation");
	}

	public void doProjectActivity(final String p_projectName, final String p_projectManager) {
		System.out.println(p_projectName + " leads by" + p_projectManager);
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	private void showProjectDetail() {
		System.out.println("Manager Name : " + projectManager.getManagerName());
		System.out.println("Year of Experience : " + projectManager.getYearOfExperience());
	}

}
