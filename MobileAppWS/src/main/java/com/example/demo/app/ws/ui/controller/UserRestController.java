package com.example.demo.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

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

import com.example.demo.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.demo.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users") // http:localhost:8080/users/....
public class UserRestController {

	private Map<String, UserRest> users = new HashMap<String, UserRest>();

	public UserRestController() {
		super();
	}

	// EXAMPLE URL : http:localhost:8080/users/111
	/*
	 * @GetMapping(path = "/{userId}", produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) public
	 * UserRest getUser(@PathVariable String userId) { UserRest userRest = new
	 * UserRest(); userRest.setFirstName("Ravindra");
	 * userRest.setLastName("Bansode"); userRest.setUserId(userId);
	 * userRest.setEmail("ravindra29989@gmail.com"); return userRest; }
	 */

	// EXAMPLE URL :http://localhost:8080/users?page=1&limit=50
	/*
	 * @GetMapping() public String getUserWithMultipalOption(
	 * 
	 * @RequestParam(value = "page", required = true, defaultValue = "1") Integer
	 * p_page,
	 * 
	 * @RequestParam(value = "limit", required = true, defaultValue = "51") Integer
	 * p_limit) { return "get User was called with page= " + p_page + " and Limit ="
	 * + p_limit; }
	 */

	/*
	 * @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE }, produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) public
	 * ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel
	 * userModel) { UserRest userRest = new UserRest();
	 * userRest.setFirstName(userModel.getFirstname());
	 * userRest.setLastName(userModel.getLastname());
	 * userRest.setEmail(userModel.getEmail()); return new
	 * ResponseEntity<UserRest>(userRest, HttpStatus.OK); }
	 */

	/*
	 * @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE }, produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) public
	 * ResponseEntity<UserRest> createUserWithValidation(@Valid @RequestBody
	 * UserDetailsRequestModel userModel) { UserRest userRest = new UserRest();
	 * userRest.setFirstName(userModel.getFirstname());
	 * userRest.setLastName(userModel.getLastname());
	 * userRest.setEmail(userModel.getEmail()); return new
	 * ResponseEntity<UserRest>(userRest, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping(path = "/{userId}", produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) public
	 * ResponseEntity<UserRest> getUserWithResponseEntity(@PathVariable String
	 * userId) {
	 * 
	 * UserRest userRest = new UserRest(); userRest.setFirstName("Ravindra");
	 * userRest.setLastName("Bansode"); userRest.setUserId(userId);
	 * userRest.setEmail("ravindra29989@gmail.com"); return new
	 * ResponseEntity<UserRest>(userRest, HttpStatus.OK); // return new
	 * ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK); }
	 */

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUserFromTempStore(@PathVariable String userId) {
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createUserWithTempStore(@Valid @RequestBody UserDetailsRequestModel userModel) {
		UserRest userRest = new UserRest();
		userRest.setFirstName(userModel.getFirstname());
		userRest.setLastName(userModel.getLastname());
		userRest.setEmail(userModel.getEmail());
		if (users == null) {
			users = new HashMap<String, UserRest>();
		}
		String userId = UUID.randomUUID().toString();
		userRest.setUserId(userId);
		users.put(userId, userRest);
		return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
	}

	@PutMapping
	public String updateUser() {
		return "Update User was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User was called";
	}

	// @GetMapping()
	public String getUserEmpty() {
		return "get User was called";
	}
}
