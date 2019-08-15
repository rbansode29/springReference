package com.springstarter.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InstanceValidationBeanPostProcessor implements BeanPostProcessor, Ordered {

	private int order;

	public InstanceValidationBeanPostProcessor() {
		System.out.println("inside InstanceValidationBeanPostProcessor constructor");
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("inside InstanceValidationBeanPostProcessor::postProcessBeforeInitialization method");
		if (bean instanceof InstanceValidator) {
			((InstanceValidator) bean).validateInstance();
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("inside InstanceValidationBeanPostProcessor::postProcessAfterInitialization method");
		if (bean instanceof InstanceValidator) {
			((InstanceValidator) bean).validateInstance();
		}
		return bean;
	}

	public int getOrder() {
		// TODO Auto-generated method stub
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
