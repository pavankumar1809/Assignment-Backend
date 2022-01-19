package com.employeemanagement.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.backend.model.Employee;
import com.employeemanagement.backend.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee get(Long id) {
		return repository.findById(id).get();
	}

	public void delete(Employee employee) {
		repository.delete(employee);
	}
}
