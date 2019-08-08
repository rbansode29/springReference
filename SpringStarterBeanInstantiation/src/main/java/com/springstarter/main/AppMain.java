package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.model.ExampleBean;
import com.springstarter.model.ExampleBeanTwo;
import com.springstarter.services.AccountServiceImpl;
import com.springstarter.services.ClientService;
import com.springstarter.services.ClientServiceImpl;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Instantiation with a constructor method
		ExampleBean l_exampleBean = (ExampleBean) l_appContext.getBean("exampleBean");
		ExampleBeanTwo l_exampleBeanTwo = (ExampleBeanTwo) l_appContext.getBean("anotherExample");

		l_exampleBean.showExampleOne();
		l_exampleBeanTwo.showExampleTwo();

		// Instantiation with a static factory method
		ClientService l_clientService = (ClientService) l_appContext.getBean("clientService");
		l_clientService.callClientService();

		// Instantiation with a Instance factory method
		ClientServiceImpl l_clientServiceImpl = (ClientServiceImpl) l_appContext.getBean("clientServiceImpl");
		l_clientServiceImpl.callClientServiceImpl();
		
		AccountServiceImpl l_accountServiceImpl = (AccountServiceImpl) l_appContext.getBean("accountServiceImpl");
		l_accountServiceImpl.callAccountServiceImpl();
	}

}
