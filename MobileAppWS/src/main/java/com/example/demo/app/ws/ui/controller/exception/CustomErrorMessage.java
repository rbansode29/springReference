package com.example.demo.app.ws.ui.controller.exception;

import java.util.Date;

public class CustomErrorMessage {
	private Date timestamp;
	private String message;
	private String messageStack;

	public CustomErrorMessage() {
		super();
	}

	public CustomErrorMessage(Date timestamp, String message, String messageStack) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.messageStack = messageStack;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageStack() {
		return messageStack;
	}

	public void setMessageStack(String messageStack) {
		this.messageStack = messageStack;
	}

}
