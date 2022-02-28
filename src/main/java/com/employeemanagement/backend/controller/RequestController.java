package com.employeemanagement.backend.controller;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.backend.exception.InvalidInputsException;
import com.employeemanagement.backend.exception.ResourceNotFoundException;
import com.employeemanagement.backend.model.Request;
import com.employeemanagement.backend.service.RequestService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class RequestController {

	@Autowired
	RequestService service;

	@GetMapping("/Requests")
	public List<Request> getUsers() {
		return service.getUsers();
	}

	@PostMapping("/Requests")
	public Request addEmployee(@RequestBody Request user) throws Exception {
		if (user.getAge() >= 19 && user.getFirstName().length() > 1
				&& (user.getDept().equals("HR") || user.getDept().equals("IT") || user.getDept().equals("Salary"))
				&& (user.getGender().equals("Male") || user.getGender().equals("Female"))
				&& user.getUsername().length() >= 4 && user.getPassword().length() >= 8) {
			List<Request> users = service.getUsers();
			Iterator<Request> it = users.iterator();
			int x = 0;
			while (it.hasNext()) {
				Request u = it.next();
				System.out.println();
				if (u.getUsername().equals(user.getUsername())) {
					x = 1;
					break;
				}
			}
			if (x == 0 && Pattern.matches("(?=.*)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}", user.getPassword())) {
				return service.addUser(user);
			} else {
				throw new ResourceNotFoundException(null);
			}
		} else {
			throw new InvalidInputsException("Invalid");
		}
	}
	
	@PostMapping("/Requests/{id}")
	public Request updateEmployee(@RequestBody Request user) throws Exception {
		if (user.getAge() >= 19 && user.getFirstName().length() > 1
				&& (user.getDept().equals("HR") || user.getDept().equals("IT") || user.getDept().equals("Salary"))
				&& (user.getGender().equals("Male") || user.getGender().equals("Female"))
				&& user.getUsername().length() >= 4 && user.getPassword().length() >= 8) {
			List<Request> users = service.getUsers();
			Iterator<Request> it = users.iterator();
			int x = 0;
			while (it.hasNext()) {
				Request u = it.next();
				System.out.println();
				if (!u.getId().equals(user.getId()) && u.getUsername().equals(user.getUsername())) {
					x = 1;
					break;
				}
			}
			if (x == 0 && Pattern.matches("(?=.*)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}", user.getPassword())) {
				return service.addUser(user);
			} else {
				throw new ResourceNotFoundException(null);
			}
		} else {
			throw new InvalidInputsException("Invalid");
		}
	}

	@RequestMapping("/Requests/{id}")
	public Request getUser(@PathVariable(name = "id") Long id) {
		Request user = service.get(id);
		return user;
	}

	@DeleteMapping("/Requests/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		Request user = service.get(id);
		service.delete(user);
	}
}
