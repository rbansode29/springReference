package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;


public abstract class RequestProcessor {

	@Autowired
	ResourceB resourceB;

	public ResourceB getResourceB() {
		return resourceB;
	}

	abstract ResourceA getResourceA();
}
