package com.spring.appcontextfeature.messagesource;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class CustomMessageSource implements MessageSourceAware {

	private MessageSource messageSource;
	
	public CustomMessageSource() {
		super();	
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void showMessage() {
		String message = messageSource.getMessage("argument.required", new Object[] { "userDao" }, "", null);
		System.out.println(message);
	}

}
