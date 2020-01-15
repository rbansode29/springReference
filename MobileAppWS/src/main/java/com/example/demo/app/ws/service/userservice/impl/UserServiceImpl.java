package com.example.demo.app.ws.service.userservice.impl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.ws.service.userservice.UserService;
import com.example.demo.app.ws.service.util.Utils;
import com.example.demo.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.demo.app.ws.ui.model.response.UserRest;

@Service
public class UserServiceImpl implements UserService {
	private Map<String, UserRest> users = new HashMap<String, UserRest>();
	private Utils util;

	@Autowired
	public UserServiceImpl(Utils util) {
		super();
		this.util = util;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {
		UserRest userRest = new UserRest();
		userRest.setFirstName(userDetailsRequestModel.getFirstname());
		userRest.setLastName(userDetailsRequestModel.getLastname());
		userRest.setEmail(userDetailsRequestModel.getEmail());
		if (users == null) {
			users = new HashMap<String, UserRest>();
		}
		String userId = util.generateRandomID();
		userRest.setUserId(userId);
		users.put(userId, userRest);
		return users.get(userId);
	}

	@Override
	public UserRest updateUser(String userId, UserDetailsRequestModel userModel) {
		UserRest userUpdated = users.get(userId);
		userUpdated.setFirstName(userModel.getFirstname());
		userUpdated.setLastName(userModel.getLastname());
		userUpdated.setEmail(userModel.getEmail());
		users.put(userId, userUpdated);
		return users.get(userId);
	}

	@Override
	public void deleteUser(String userId) {
		users.remove(userId);
	}

	@Override
	public UserRest getSpecificUser(String userId) {
		return users.get(userId);
	}

	@Override
	public List<UserRest> getAllUser() {
		List<UserRest> userRestList = new ArrayList<UserRest>();
		for (String key : users.keySet()) {
			userRestList.add(users.get(key));
		}
		return userRestList;
	}

}
