package com.employeemanagement.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employeemanagement.backend.model.Employee;
import com.employeemanagement.backend.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	@PostMapping("employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@PostMapping("employee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable(name = "id") Long id) {
		Employee employee = service.get(id);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable(name = "id") Long id) {
		Employee employee = service.get(id);
		service.delete(employee);
	}
}
	
