package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.methodreplacement.MyValueCalculator;
import com.springstarter.model.SingletonChanged;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// lookup method injection
		SingletonChanged l_singletonChanged = (SingletonChanged) l_appContext.getBean("singleton");
		l_singletonChanged.doSomething();
		l_singletonChanged.doSomethingElse();

		// Arbitary method replacement
		MyValueCalculator l_MyValueCalculatorOriginal = (MyValueCalculator) l_appContext
				.getBean("myValueCalculatorOriginal");
		l_MyValueCalculatorOriginal.computeValue("India");

		MyValueCalculator l_MyValueCalculatorReplacer = (MyValueCalculator) l_appContext
				.getBean("myValueCalculatorReplaced");
		l_MyValueCalculatorReplacer.computeValue("Ravindra");
	}

}
