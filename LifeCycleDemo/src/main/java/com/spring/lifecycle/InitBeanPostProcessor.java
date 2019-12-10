package com.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitBeanPostProcessor implements BeanPostProcessor {

	public InitBeanPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SpringLifeCycle : postProcessBeforeInitialization called for Bean : " + beanName);
		if (bean instanceof SpringLifeCycle) {
			System.out.println("Step counter of SpringLifeCycle : " + ((SpringLifeCycle) bean).getStepCounter());
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SpringLifeCycle : postProcessAfterInitialization called for Bean : " + beanName);
		if (bean instanceof SpringLifeCycle) {
			System.out.println("Step counter of SpringLifeCycle : " + ((SpringLifeCycle) bean).getStepCounter());
		}
		return bean;
	}

}
