package com.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.entity.Student;
import com.repository.IStudentRepository;

@Named
public class StudentService implements Serializable, IStudentService{

	/**
	 * 
	 **/
	private static final long serialVersionUID = 1L;

	@Inject
	private IStudentRepository studentRepository;
	
	@Override
	public Student login(Student s) throws Exception {
		// TODO Auto-generated method stub
		return studentRepository.login(s);
	}

	@Override
	public Student updateStudent(Student s) throws Exception {
		return studentRepository.update(s);
	}

	
}
