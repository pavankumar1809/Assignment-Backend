package com.employeemanagement.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.backend.model.User;
import com.employeemanagement.backend.service.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return service.getUsers();
	}

	@PostMapping("/users")
	public User addEmployee(@RequestBody User user) {
		return service.addUser(user);
	}
}
