package com.spring.appcontextfeature;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.appcontextfeature.messagesource.CustomMessageSource;
import com.spring.appcontextfeature.messagesource.MessageSourceInjection;

/**
 * Application Context Feature!
 *
 */
public class ApplicationContextFeature {
	public static void main(String[] args) {
		System.out.println("Application Context Feature!");

		// getApplicationContext from classpath

		// ClassPathXmlApplicationContext("applicationContext.xml"); same effect
		ApplicationContext resources = new ClassPathXmlApplicationContext("applicationContext.xml");
		String message = resources.getMessage("message", null, "Default", null);
		String exceptionMessage = resources.getMessage("argument.required", new Object[] { 10 }, "Default", null);
		System.out.println(message);
		System.out.println(exceptionMessage);

		MessageSourceInjection msgSourceInjection = (MessageSourceInjection) resources
				.getBean("messageSourceInjection");
		msgSourceInjection.getMessage();

				
		System.out.println(msgSourceInjection.getMessageSource().getMessage("argument.required1",
				new Object[] { "userDao" }, "", Locale.UK));
		
		
		CustomMessageSource customMessageSource = (CustomMessageSource)resources.getBean("customMessageSource");
		customMessageSource.showMessage();
	}
}
