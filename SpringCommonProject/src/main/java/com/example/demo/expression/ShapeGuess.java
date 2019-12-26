package com.example.demo.expression;

import org.springframework.beans.factory.annotation.Value;

public class ShapeGuess {
	
	@Value("#{ systemProperties['user.region'] }")
	private String initialShapeSeed;

	public String getInitialShapeSeed() {
		return initialShapeSeed;
	}

	public void setInitialShapeSeed(String initialShapeSeed) {
		this.initialShapeSeed = initialShapeSeed;
	}
}
