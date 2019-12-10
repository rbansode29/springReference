package com.spring.dependancyinjection;

import com.spring.dependancyinjection.project.Project;

public class ProjectDirector {
	
	private Project project;
	
	public ProjectDirector() {
		super();
		System.out.println("Initializing the Project Director");		
	}

	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public void displayProjectInformation() {
		
		
	}

}
