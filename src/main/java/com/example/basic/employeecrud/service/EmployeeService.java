package com.example.basic.employeecrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.employeecrud.dao.Employee;
import com.example.basic.employeecrud.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
    public Employee createEmployee(Employee employee) {
    	return employeeDao.save(employee);
    }
    
    public List<Employee> createEmployees(List<Employee> employees) {
    	return employeeDao.saveAll(employees);
    }
    
    public Employee getEmployeeById(long id) {
    	return employeeDao.findById(id).orElse(null);
    }
    
    public List<Employee> getEmployees() {
    	return employeeDao.findAll();
    }
    
    public Employee updateEmployee(Employee emp) {
    	Optional<Employee> optionalEmp = employeeDao.findById(emp.getId());
    	Employee oldEmp=null;
    	if(optionalEmp.isPresent()) {
    		oldEmp= optionalEmp.get();
    		oldEmp.setName(emp.getName());
    		oldEmp.setDescription(emp.getDescription());
    		employeeDao.save(oldEmp);
    	}
    	else {
    		return new Employee();
    	}
    	return oldEmp;
    }
    
    public String deleteEmployeeById(long id) {
    	employeeDao.deleteById(id);
    	return "emp deleted";
    }
}