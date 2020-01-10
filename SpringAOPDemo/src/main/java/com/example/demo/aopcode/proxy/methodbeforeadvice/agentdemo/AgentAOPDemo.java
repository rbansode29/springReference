package com.example.demo.aopcode.proxy.methodbeforeadvice.agentdemo;

import org.springframework.aop.framework.ProxyFactory;

import com.example.demo.aopcode.proxy.methodbeforeadvice.singerdemo.JdkProxyImpl;

public class AgentAOPDemo {

	public AgentAOPDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JdkProxyImpl target = new Agent();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new AgentDecorator());
		pf.setTarget(target);
		Agent proxy = (Agent) pf.getProxy();
		target.speak();
		System.out.println("");
		proxy.speak();
	}

}

/* 
 * ProxyFactory = DefaultAopProxyFactory - AopProxyFactory -Cglib2AopProxy( No Interface Implemented into target class) / JdkDynamicAopProxy(Interface Implemented), 
 */
 
