package com.app.multidb.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.multidb.documents.Employee;
import com.app.multidb.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee", produces = "application/json")
public class EmployeeCtrl {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee response = employeeService.addemployee(employee);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeEmailId(@PathVariable int id, @RequestParam String emailId) {
		Employee employee = employeeService.updateEmployee(emailId, id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/emailid")
	public ResponseEntity<Employee> getEmployeeByEmailId(@RequestParam(required = true) String emailId) {
		Employee employee = employeeService.getEmployeeByEmailId(emailId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	@GetMapping("/byname")
	public ResponseEntity<List<Employee>> getAllEmployeesByName(@RequestParam String name) {
		List<Employee> employeeList = employeeService.getEmployeesByName(name);
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
}
