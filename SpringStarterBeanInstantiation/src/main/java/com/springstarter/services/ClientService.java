package com.springstarter.services;

public class ClientService {
	private static ClientService clientService = null;

	private ClientService() {
	}

	public static ClientService createInstance() {
		if (null == clientService) {
			synchronized (ClientService.class) {
				if (null == clientService) {
					clientService = new ClientService();
				}
			}
		}
		return clientService;
	}

	public void callClientService() {
		System.out.println("Inside the client Service call");
	}
}
