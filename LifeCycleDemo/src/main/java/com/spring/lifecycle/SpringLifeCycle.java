package com.spring.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*
 * Multiple lifecycle mechanisms configured for the same bean 
   
   fist any Aware interfaces are implemented by spring bean then they call first as below order
   1. method setBeanName called
   2. method setBeanFactory called
   3. method setApplicationContext called
   
   secondly if BeanPostProcessor are register in context then that case 
   1. postProcessBeforeInitialization get called before calling initialization call back method
   
   initialization methods are called as follows:
	1. Methods annotated with @PostConstruct
	2. afterPropertiesSet() as defined by the InitializingBean callback interface
	3. A custom configured init() method
	
   2.  postProcessAfterInitialization get called after calling initialization call back method
	
	Destroy methods are called in the same order:
	1. Methods annotated with @PreDestroy
	2. destroy() as defined by the DisposableBean callback interface
	3. A custom configured destroy() method
 * 
 */

public class SpringLifeCycle implements InitializingBean, DisposableBean,ApplicationContextAware,BeanNameAware,BeanFactoryAware {
	private int stepCounter = 0;
	
	private String message;
		
	public int getStepCounter() {
		return stepCounter;
	}

	public SpringLifeCycle() {
		System.out.println("SpringLifeCycle : default constructor called first : "+stepCounter++);
	}

	public void destroy() throws Exception {
		System.out.println("SpringLifeCycle : destroy called  : "+stepCounter++);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("SpringLifeCycle : afterPropertiesSet called  : "+stepCounter++);
	}
	
	public void customInit() {
		System.out.println("SpringLifeCycle : customInit called  : "+stepCounter++);
	}
	
	public void customDestroy() {
		System.out.println("SpringLifeCycle : customDestroy called  :"+stepCounter++);
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("SpringLifeCycle : postConstruct called  : "+ stepCounter++);
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("SpringLifeCycle : preDestroy called  : "+ stepCounter++);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("SpringLifeCycle : setApplicationContext called  : "+ stepCounter++);		
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("SpringLifeCycle : setBeanFactory called  : "+ stepCounter++);		
	}

	public void setBeanName(String name) {
		System.out.println("SpringLifeCycle : setBeanName called  : "+ stepCounter++);		
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("SpringLifeCycle : setMessage called  : "+stepCounter++);
	}

	
}
