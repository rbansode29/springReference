package com.example.demo.app.ws.ui.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.demo.app.ws.ui.model.response.UserRest;

public class DummyUserRestController {

	// EXAMPLE URL : http:localhost:8080/users/111

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest getUser(@PathVariable String userId) {
		UserRest userRest = new UserRest();
		userRest.setFirstName("Ravindra");
		userRest.setLastName("Bansode");
		userRest.setUserId(userId);
		userRest.setEmail("ravindra29989@gmail.com");
		return userRest;
	}

	// EXAMPLE URL :http://localhost:8080/users?page=1&limit=50
	@GetMapping()
	public String getUserWithMultipalOption(
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer p_page,
			@RequestParam(value = "limit", required = true, defaultValue = "51") Integer p_limit) {
		return "get User was called with page= " + p_page + " and Limit =" + p_limit;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userModel) {
		UserRest userRest = new UserRest();
		userRest.setFirstName(userModel.getFirstname());
		userRest.setLastName(userModel.getLastname());
		userRest.setEmail(userModel.getEmail());
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createUserWithValidation(@Valid @RequestBody UserDetailsRequestModel userModel) {
		UserRest userRest = new UserRest();
		userRest.setFirstName(userModel.getFirstname());
		userRest.setLastName(userModel.getLastname());
		userRest.setEmail(userModel.getEmail());
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUserWithResponseEntity(@PathVariable String userId) {

		UserRest userRest = new UserRest();
		userRest.setFirstName("Ravindra");
		userRest.setLastName("Bansode");
		userRest.setUserId(userId);
		userRest.setEmail("ravindra29989@gmail.com");
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
	}

}
