package com.springstarter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstarter.model.Person;
import com.springstarter.model.SingletonWithAbstract;
import com.springstarter.model.Student;

public class AppMain {

	public static void main(String[] args) {

		// Instantiating a container
		// ApplicationContext context =new ClassPathXmlApplicationContext(new String[]
		// {"services.xml", "daos.xml"});

		ApplicationContext l_appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		Person l_childBean = (Person) l_appContext.getBean("childBean1");
		l_childBean.displayDetail();

		// calling the abstract bean defination result into error
		Person l_person = (Person) l_appContext.getBean("mainBean");
		l_person.displayDetail();

		// singletonBean with Abstract Attribute
		SingletonWithAbstract l_singletonWithAbstract = (SingletonWithAbstract) l_appContext
				.getBean("singletonWithAbstract");
		l_singletonWithAbstract.display();
	}

}
