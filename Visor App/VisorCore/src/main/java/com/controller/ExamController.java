package com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.entity.Course;
import com.entity.Year;
import com.entity.Exam;
import com.entity.Student;
import com.entity.TipoExamen;
import com.service.ICourseService;
import com.service.IExamService;

@Named
@ViewScoped
public class ExamController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IExamService examService;
	@Inject
	private ICourseService courseService;

	private List<Exam> exams;
	private Exam exam;
	private Exam examSelection;

	private Course course;
	private List<Course> courses;

	private UploadedFile pdf;

	@PostConstruct
	public void init() {
		exams = new ArrayList<>();
		exam = new Exam();
		course = new Course();
		examSelection = new Exam();

		this.getAllExam();
		this.getTipoExams();
		this.getYears();
		this.getAllCourses();
	}

	public void clean() {
		exam = new Exam();
	}

	public String newExam() {
		this.clean();
		return "../user/newExam?faces-redirect=true";
	}

	public void getAllCourses() {
		try {
			courses = courseService.getAllCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllExam() {
		try {
			exams = examService.getAllExams();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public TipoExamen[] getTipoExams() {
		return TipoExamen.values();
	}

	public Year[] getYears() {
		return Year.values();
	}

	public String descargarExamen() {
		String rpta = null;

		if (examSelection != null) {
			this.exam = this.examSelection;
			rpta = "/user/descargarExam?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Carrera no seleccionada", "Carrera no seleccionada"));
		}
		return rpta;
	}

	public void getByFilter(String course, int cycle, String tipoExam) {
		try {
			exams=examService.getAllByFilter(course, cycle, tipoExam);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void saveExam(Student s) {
		try {

			exam.setIdStudent(s);
			exam.setIdCourse(course);
			if (pdf != null) {
				exam.setFile(this.pdf.getContents());
				examService.saveExam(exam);
				s.setPuntos(s.getPuntos() + 5);
			}
			FacesMessage message = new FacesMessage("Succesful", pdf.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);

			this.getAllExam();
			// this.clean();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public UploadedFile getPdf() {
		return pdf;
	}

	public void setPdf(UploadedFile pdf) {
		this.pdf = pdf;
	}

	public Exam getExamSelection() {
		return examSelection;
	}

	public void setExamSelection(Exam examSelection) {
		this.examSelection = examSelection;
	}
}
