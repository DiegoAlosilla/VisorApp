package com.repository;

import java.util.List;


import com.entity.Course;


public interface ICourseRepository {
	
	public Course save (Course c) throws Exception;
	public Course update(Course c) throws Exception;
	public List<Course> findAll() throws Exception;



}
