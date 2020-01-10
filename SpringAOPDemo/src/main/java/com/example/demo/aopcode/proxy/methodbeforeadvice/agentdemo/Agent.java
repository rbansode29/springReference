package com.example.demo.aopcode.proxy.methodbeforeadvice.agentdemo;

import com.example.demo.aopcode.proxy.methodbeforeadvice.singerdemo.JdkProxyImpl;

public class Agent implements JdkProxyImpl {

	public Agent() {
	}

	@Override
	public void speak() {
		System.out.print("Bond");
	}

	@Override
	public void display() {
		System.out.println("JDK Proxy Implemented");
	}
}
