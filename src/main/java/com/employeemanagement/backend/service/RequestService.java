package com.employeemanagement.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.backend.model.Request;
import com.employeemanagement.backend.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;
	
	public List<Request> getUsers(){
		return repository.findAll();
	}
	
	public Request addUser(Request user) {
		return repository.save(user);
	}

	public Request get(Long id) {
		return repository.findById(id).get();
	}

	public void delete(Request user) {
		repository.delete(user);
	}
}
