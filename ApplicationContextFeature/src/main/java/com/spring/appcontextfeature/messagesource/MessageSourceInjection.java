package com.spring.appcontextfeature.messagesource;

import org.springframework.context.MessageSource;

public class MessageSourceInjection {

	private MessageSource messageSource;

	public MessageSourceInjection() {
		super();
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void getMessage() {
		String msg = this.messageSource.getMessage("argument.required", new Object[] { "userDao" }, "", null);
		System.out.println(msg);
	}

}
