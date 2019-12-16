package com.spring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.model.Address;

public class AddressValidator extends AbstractValidator implements Validator {

	private MessageSource messageSource;

	public AddressValidator() {
		super();
	}

	public boolean supports(Class<?> clazz) {

		return Address.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

	}

	@Override
	public String getMessage(String str,Object[] obj ) {
		return messageSource.getMessage(str, obj, null);
	}

	@Override
	public MessageSource getMessageSource() {
		return messageSource;
	}

	@Autowired
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
