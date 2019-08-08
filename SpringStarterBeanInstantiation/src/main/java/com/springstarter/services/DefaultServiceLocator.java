package com.springstarter.services;

public class DefaultServiceLocator {

	private static ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
	private static AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	private DefaultServiceLocator() {
	}

	public ClientServiceImpl createClientServiceImpInstance() {
		return clientServiceImpl;
	}
	
	public AccountServiceImpl createAccountServiceImpInstance() {
		return accountServiceImpl;
	}
}
