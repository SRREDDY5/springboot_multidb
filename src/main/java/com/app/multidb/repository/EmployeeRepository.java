package com.app.multidb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.multidb.documents.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{
	
	Optional<Employee> findByEmailId(String emailId);
	
	List<Employee> findAllByName(String name);

}
