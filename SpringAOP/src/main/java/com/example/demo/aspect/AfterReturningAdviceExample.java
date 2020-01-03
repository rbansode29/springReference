package com.example.demo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturningAdviceExample {

	public AfterReturningAdviceExample() {
		// TODO Auto-generated constructor stub
	}

	@AfterReturning("execution(public void passIntegrArgument()) && args(a)")
	public void afterAdviceExecutionWithReturn (Integer a) {
		System.out.println("AFTER Returing Advice ::" + a);
	}
}
