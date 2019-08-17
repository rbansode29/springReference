package com.springstarter.resourceannotation;

import javax.annotation.Resource;

public class MovieRecommender {

	@Resource(name = "customerPreferenceDao")
	/*
	 * @Resource takes a name attribute, and by default Spring interprets that value
	 * as the bean name to be injected. In other words, it follows by-name semantics
	 */
	private CustomerPreferenceDao customerPreferenceDao;

	public MovieRecommender() {
		// TODO Auto-generated constructor stub
	}

	public void showCustomer() {
		customerPreferenceDao.showCustomer();
	}

}
