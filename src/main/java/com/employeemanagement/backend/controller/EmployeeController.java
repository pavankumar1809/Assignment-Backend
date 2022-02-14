package com.employeemanagement.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.backend.model.Employee;
import com.employeemanagement.backend.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/Employees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	@PostMapping("/Employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@PostMapping("/Employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@RequestMapping("/Employees/{id}")
	public Employee getEmployee(@PathVariable(name = "id") Long id) {
		Employee employee = service.get(id);
		return employee;
	}
	
	@DeleteMapping("/Employees/{id}")
	public void deleteEmployee(@PathVariable(name = "id") Long id) {
		Employee employee = service.get(id);
		service.delete(employee);
	}
}
	
