package com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.entity.Course;
import com.repository.ICourseRepository;

@Named
public class CourseService implements Serializable, ICourseService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICourseRepository courseRespository;

	@Override
	public Course saveCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		return courseRespository.save(c);
	}

	@Override
	public Course updateCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		return courseRespository.update(c);
	}

	@Override
	public List<Course> getAllCourses() throws Exception {
		// TODO Auto-generated method stub
		return courseRespository.findAll();
	}



	

}
