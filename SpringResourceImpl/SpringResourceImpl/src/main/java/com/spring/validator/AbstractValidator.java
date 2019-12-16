package com.spring.validator;

import org.springframework.context.MessageSource;

public abstract class AbstractValidator {

	public abstract String getMessage(String str, Object[] obj);

	public abstract MessageSource getMessageSource();

	public abstract void setMessageSource(MessageSource messageSource);
}
