package com.example.demo.app.ws.service.userservice;

import java.util.List;

import com.example.demo.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.demo.app.ws.ui.model.response.UserRest;

public interface UserService {

	UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);

	UserRest updateUser(String userId, UserDetailsRequestModel userModel);

	void deleteUser(String userId);

	UserRest getSpecificUser(String userId);

	List<UserRest> getAllUser();
}
