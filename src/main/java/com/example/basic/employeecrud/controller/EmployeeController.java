package com.example.basic.employeecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.employeecrud.dao.Employee;
import com.example.basic.employeecrud.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@PostMapping("/addEmps")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees){
		return employeeService.createEmployees(employees);
	}
	
	@GetMapping("/emp/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/emps")
	public List<Employee> getAllEmployees() {
		return employeeService.getEmployees();
	}
	
	@PutMapping("/updateemp")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/deleteemp/{id}")
	public String deleteEmp(@PathVariable long id) {
		return employeeService.deleteEmployeeById(id);
	}

}
