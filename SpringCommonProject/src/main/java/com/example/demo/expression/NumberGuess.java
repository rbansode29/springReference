package com.example.demo.expression;

import org.springframework.beans.factory.annotation.Value;

public class NumberGuess {
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private Integer  randomNumber;

	public Integer getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(Integer randomNumber) {
		this.randomNumber = randomNumber;
	}
}
