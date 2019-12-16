package com.spring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.model.Address;
import com.spring.model.Customer;

public class CustomerValidator extends AbstractValidator implements Validator {

	private final Validator addressValidator;

	private MessageSource messageSource;

	public CustomerValidator(Validator addressValidator) {
		if (addressValidator == null) {
			throw new IllegalArgumentException(getMessage("Validator.required", new Object[] { "Validator" }));
		}
		if (!addressValidator.supports(Address.class)) {
			throw new IllegalArgumentException(
					getMessage("The supplied [Validator] must " + "support the validation of [Address] instances.",
							new Object[] { "Validator", "Address" }));
		}
		this.addressValidator = addressValidator;
	}

	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", getMessage("field.required", null));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", getMessage("field.required", null));
		Customer customer = (Customer) target;
		try {
			errors.pushNestedPath("address");
			ValidationUtils.invokeValidator(this.addressValidator, customer.getAddress(), errors);
		} finally {
			errors.popNestedPath();
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
