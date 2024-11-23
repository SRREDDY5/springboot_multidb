package com.app.multidb.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.multidb.entity.Student;
import com.app.multidb.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentCtrl {

	
	@Autowired
	StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = service.getAllStudents();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student response = service.createStudent(student);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
