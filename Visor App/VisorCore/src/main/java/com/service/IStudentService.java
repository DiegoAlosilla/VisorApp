package com.service;

import com.entity.Student;

public interface IStudentService {

	Student login(Student s)throws Exception;
	Student updateStudent(Student s)throws Exception;
}
