package com.example.demo;

public abstract class ResourceA {
	String url ="http://localhost:8080";
	public ResourceA(){
		System.out.println("Resource A instance creation");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
