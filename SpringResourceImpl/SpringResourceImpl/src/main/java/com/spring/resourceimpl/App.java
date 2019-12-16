package com.spring.resourceimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Person;

/**
 * Spring Resource!
 *
 */
public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Person p = (Person) context.getBean("person");
		
		p.setName(null);
		p.setAge(120);
		p.setAdress(null);

	}
}
