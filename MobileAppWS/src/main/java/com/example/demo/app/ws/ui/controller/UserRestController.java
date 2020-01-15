package com.example.demo.app.ws.ui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.ws.service.userservice.UserService;
import com.example.demo.app.ws.ui.controller.exception.UserServiceException;
import com.example.demo.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.demo.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users") // http:localhost:8080/users/....
public class UserRestController {

	private UserService userService;

	public UserRestController() {
		super();
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<UserRest>> getAllUsers() {
		List<UserRest> users = userService.getAllUser();
		if (users != null) {
			return new ResponseEntity<List<UserRest>>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<UserRest>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getSpecificUser(@PathVariable String userId) {
		exceptionHandelExample(userId);
		UserRest user = userService.getSpecificUser(userId);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	private void exceptionHandelExample(String userId) {
		if (null == userId) {
			throw new UserServiceException("User Service exception is thrown");
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createUserWithTempStore(@Valid @RequestBody UserDetailsRequestModel userModel) {
		return new ResponseEntity<UserRest>(userService.createUser(userModel), HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
			@Valid @RequestBody UserDetailsRequestModel userModel) {
		return new ResponseEntity<UserRest>(userService.updateUser(userId, userModel), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
}
