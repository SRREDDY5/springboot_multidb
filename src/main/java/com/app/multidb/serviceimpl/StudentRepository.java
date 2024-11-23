package com.app.multidb.serviceimpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.multidb.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
