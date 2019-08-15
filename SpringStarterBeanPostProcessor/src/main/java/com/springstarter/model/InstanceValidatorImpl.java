package com.springstarter.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InstanceValidatorImpl implements InstanceValidator, InitializingBean, DisposableBean {

	private String propertyName;

	public InstanceValidatorImpl() {
		System.out.println("Inside InstanceValidatorImpl class");
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		System.out.println("Inside InstanceValidatorImpl::setPropertyName method");
		this.propertyName = propertyName;
	}

	public void validateInstance() {
		System.out.println("Inside InstanceValidatorImpl :: validateInstance method");
		if (null == propertyName) {
			System.out.println("propertyName is not set into configuration");
		} else {
			System.out.println("propertyName is set by configuration : " + propertyName);
		}

	}

	public void display() {
		System.out.println("Property Name =" + propertyName);
	}

	public void destroy() throws Exception {
		System.out.println("Inside InstanceValidatorImpl ::destroy method");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside InstanceValidatorImpl ::afterPropertiesSet method");
	}

	public void init() {
		System.out.println("Inside InstanceValidatorImpl ::init method");
	}

	public void dispose() {
		System.out.println("Inside InstanceValidatorImpl ::dispose method");
	}

}
