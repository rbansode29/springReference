package com.example.demo.aopcode.proxy.methodbeforeadvice.agentdemo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {

	public AgentDecorator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("James ");
		Object retVal = invocation.proceed();
		System.out.println("!");
		return retVal;
	}

}
