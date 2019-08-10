package com.springstarter.methodreplacement;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ReplacementComputeValue implements MethodReplacer {

	public ReplacementComputeValue() {
		// TODO Auto-generated constructor stub
	}

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("inside the ReplacementComputeValue::reimplement() " + args[0]);
		return "Welcome to HelloWorld" + args[0];
	}

}
