package com.app.multidb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.multidb.entity.Student;
import com.app.multidb.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;
	
	@Override
	public Student createStudent(Student student) {
		return repository.save(student);
	}
	
	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}
	
	@Override
	public Student updateStudent(Student student) {
		Student dbStudent = repository.findById(student.getId()).get();
		dbStudent.setName(student.getName());
		dbStudent.setClassNumber(student.getClassNumber());
		
		return repository.save(dbStudent);
	}
}
