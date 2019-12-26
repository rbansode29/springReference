package com.spring.javajee.mail;

public interface MailSender {
	void send(String to, String subject, String from);
}
