package com.app.multidb.service;

import java.util.List;

import com.app.multidb.documents.Employee;

public interface EmployeeService {

	Employee addemployee(Employee employee);
	
	Employee getEmployeeById(int id);
	
	Employee getEmployeeByEmailId(String emailId);
	
	Employee updateEmployee(String emailId, int id);
	
	List<Employee> getAllEmployees();
	
	List<Employee> getEmployeesByName(String name);
	
	
}
