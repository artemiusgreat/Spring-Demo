package com.company.controller;

import com.company.model.*;
import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "")
	public Response<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(value = "/{id}")
	public Response<User> getUser(@PathVariable(value = "id") Long id) {
		return userService.getUsers(id);
	}

	@PostMapping(value = "/save")
	public Response<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
}