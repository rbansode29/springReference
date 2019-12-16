package com.spring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.model.Person;

public class PersonValidator extends AbstractValidator implements Validator {

	private MessageSource messageSource;

	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", getMessage("name.empty", null));

		if (null != target && target instanceof Person) {
			Person p = (Person) target;

			if (p.getAge() < 0) {
				errors.rejectValue("age", getMessage("negativevalue", null));
			} else if (p.getAge() > 110) {
				errors.rejectValue("age", getMessage("too.darn.old", null));
			}
		}
	}

	@Override
	public String getMessage(String str, Object[] obj) {
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
