package com.employeemanagement.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.backend.model.Employee;
import com.employeemanagement.backend.model.User;
import com.employeemanagement.backend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public User addUser(User user) {
		return repository.save(user);
	}

	public User get(Long id) {
		return repository.findById(id).get();
	}

	public void delete(User user) {
		repository.delete(user);
	}
}
