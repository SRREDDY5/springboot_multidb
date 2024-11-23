package com.app.multidb.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.multidb.documents.Employee;
import com.app.multidb.exception.EmployeeAlreadyExistsException;
import com.app.multidb.exception.EmployeeNotFoundException;
import com.app.multidb.repository.EmployeeRepository;
import com.app.multidb.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addemployee(Employee employee) {
		logger.info("employee input {}", employee);
		boolean exists = employeeRepository.existsById(employee.getEmpId());
		if(exists) {
			throw new EmployeeAlreadyExistsException("Employee already exists with id : "+employee.getEmpId());
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		logger.info("employee id {}", id);
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new EmployeeNotFoundException("Employee not found with id : "+id);
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		Optional<Employee> employee = employeeRepository.findByEmailId(emailId);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new EmployeeNotFoundException("Employee not found with EmailId : "+emailId);
	}

	@Override
	public Employee updateEmployee(String emailId, int id) {
		Employee employee = getEmployeeById(id);
		employee.setEmailId(emailId);
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return employeeRepository.findAllByName(name);
	}

}
