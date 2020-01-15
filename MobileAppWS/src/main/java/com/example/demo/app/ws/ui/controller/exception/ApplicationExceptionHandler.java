package com.example.demo.app.ws.ui.controller.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handelAnyException(Exception ex, WebRequest request) {
		String messageDescription = ex.getLocalizedMessage();

		if (messageDescription == null) {
			messageDescription = ex.toString();
		}

		CustomErrorMessage customMessage = new CustomErrorMessage(new Date(), messageDescription,
				ex.getStackTrace().toString());

		return new ResponseEntity<Object>(customMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
	public ResponseEntity<Object> handelSpecificException(Exception ex, WebRequest request) {
		String messageDescription = ex.getLocalizedMessage();

		if (messageDescription == null) {
			messageDescription = ex.toString();
		}

		CustomErrorMessage customMessage = new CustomErrorMessage(new Date(), messageDescription,
				ex.getStackTrace().toString());

		return new ResponseEntity<Object>(customMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> handelUserServiceException(UserServiceException ex, WebRequest request) {
		String messageDescription = ex.getLocalizedMessage();

		if (messageDescription == null) {
			messageDescription = ex.toString();
		}

		CustomErrorMessage customMessage = new CustomErrorMessage(new Date(), messageDescription,
				ex.getStackTrace().toString());

		return new ResponseEntity<Object>(customMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handelNullPointerException(NullPointerException ex, WebRequest request) {
		String messageDescription = ex.getLocalizedMessage();

		if (messageDescription == null) {
			messageDescription = ex.toString();
		}

		CustomErrorMessage customMessage = new CustomErrorMessage(new Date(), messageDescription,
				ex.getStackTrace().toString());

		return new ResponseEntity<Object>(customMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}*/

}
