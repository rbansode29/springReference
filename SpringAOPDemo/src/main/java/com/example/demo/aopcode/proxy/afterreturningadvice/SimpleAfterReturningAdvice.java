package com.example.demo.aopcode.proxy.afterreturningadvice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import com.example.demo.aopcode.proxy.methodbeforeadvice.singerdemo.Guitarist;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After '" + method.getName() + "' put down guitar.");

	}

	public static void main(String... args) {
		Guitarist target = new Guitarist();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleAfterReturningAdvice());
		pf.setTarget(target);
		Guitarist proxy = (Guitarist) pf.getProxy();
		proxy.sing();
	}

}
