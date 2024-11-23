package com.app.multidb.service;

import java.util.List;

import com.app.multidb.entity.Student;

public interface StudentService {

	Student createStudent(Student student);
	
	Student updateStudent(Student student);
	
	List<Student> getAllStudents();
}
