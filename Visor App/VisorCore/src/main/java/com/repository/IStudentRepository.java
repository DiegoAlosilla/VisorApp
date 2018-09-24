package com.repository;

import com.entity.Student;

public interface IStudentRepository {
	
	Student login(Student s) throws Exception;
	Student update(Student s) throws Exception;
}
