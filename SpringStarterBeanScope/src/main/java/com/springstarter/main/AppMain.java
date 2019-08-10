package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.model.HelloWorldDemo;
import com.springstarter.services.CustomAccountService;
import com.springstarter.services.DefaultAccountService;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// singleton scope
		showSingletonBean(l_appContext);

		// protorype scope
		showPrototypeBean(l_appContext);

		showRequestScopeBean(l_appContext);

		showSessionScopeBean(l_appContext);

		showGlobalSessionScopeBean(l_appContext);
	}

	private static void showGlobalSessionScopeBean(ApplicationContext l_appContext) {
		// TODO Auto-generated method stub

	}

	private static void showSessionScopeBean(ApplicationContext l_appContext) {
		// TODO Auto-generated method stub

	}

	private static void showRequestScopeBean(ApplicationContext l_appContext) {
		// TODO Auto-generated method stub

	}

	private static void showSingletonBean(ApplicationContext p_appContext) {
		DefaultAccountService l_defAccountService = (DefaultAccountService) p_appContext
				.getBean("defaultAccountService");
		System.out.println("Hash  code of defaultAccountService :: 1 call - " + l_defAccountService.hashCode());
		l_defAccountService.callMyService();

		DefaultAccountService l_defAccountService1 = (DefaultAccountService) p_appContext
				.getBean("defaultAccountService1");
		System.out.println("Hash  code of defaultAccountService :: 1 call - " + l_defAccountService1.hashCode());
		l_defAccountService1.callMyService();

		DefaultAccountService l_defAccountService2 = (DefaultAccountService) p_appContext
				.getBean("defaultAccountService");
		System.out.println("Hash  code of defaultAccountService :: 1 call - " + l_defAccountService2.hashCode());
		l_defAccountService2.callMyService();
	}

	private static void showPrototypeBean(ApplicationContext p_appContext) {
		CustomAccountService l_customAccountService1 = (CustomAccountService) p_appContext
				.getBean("customAccountService");
		System.out.println("Hash  code of customAccountService :: 1 call - " + l_customAccountService1.hashCode());
		l_customAccountService1.callMyService();

		CustomAccountService l_customAccountService2 = (CustomAccountService) p_appContext
				.getBean("customAccountService");
		System.out.println("Hash  code of customAccountService :: 1 call - " + l_customAccountService2.hashCode());
		l_customAccountService2.callMyService();

	}

}
