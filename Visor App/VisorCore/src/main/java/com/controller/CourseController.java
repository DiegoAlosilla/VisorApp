package com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.entity.Career;
import com.entity.Course;
import com.service.ICareerServive;
import com.service.ICourseService;

@Named
@SessionScoped
public class CourseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICourseService courseService;
	
	@Inject
	private ICareerServive careerService;
	
	
	private List<Course> courses;



	private Course course;
	private Course courseSelection;
	
	
	private List<Career> careers;
	private Career career;
	private List<Career> careerSelections;
	

	@PostConstruct
	public void init() {
		courses = new ArrayList<>();
		course = new Course();
		courseSelection = new Course();
		
		careers = new ArrayList<>();
		career = new Career();
		careerSelections = new ArrayList<>();

		this.getAllCourses();
		this.getAllCareers();
	}



	



	// Action
	public void cleanCourse() {
		course = new Course();
		careerSelections = new ArrayList<>();
		this.getAllCareers();
	}

	public String newCourse() {
		this.cleanCourse();
		return "/admin/newCourse?faces-redirect=true";
	}

	public String editCourse() {
		String rpta = "";

		if (this.courseSelection != null && this.courseSelection.getCourse().length() >= 0) {
			this.course = this.courseSelection;
			
			rpta = "/admin/editCourse?faces-redirect=true";
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso no seleccionado", "Curso no seleccionado"));
		}

		return rpta;
	}
	
	public void updateCategory() {
		try {
			courseService.updateCourse(courseSelection);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso Actualizado", "Curso Actualizado"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
	}
	


	// Controller-Service
	public void getAllCourses() {
		try {
			courses = courseService.getAllCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllCareers() {
		try {
			careers = careerService.findAllCareer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	
	
	

	public void saveCourse() {
		try {
			
			course.setCareers(careerSelections);
			courseService.saveCourse(course);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso registrado", "Curso registrado"));
			this.getAllCourses();
			this.cleanCourse();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
	}

	public void updateCourse() {
		try {
			courseService.updateCourse(course);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso actualizado", "Curso actualizado"));
			this.cleanCourse();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
	}

	// get set

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourseSelection() {
		return courseSelection;
	}

	public void setCourseSelection(Course courseSelection) {
		this.courseSelection = courseSelection;
	}

	
	
	
	public List<Career> getCareers() {
		return careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}
	
	public List<Career> getCareerSelections() {
		return careerSelections;
	}

	public void setCareerSelections(List<Career> careerSelections) {
		this.careerSelections = careerSelections;
	}
	

}
