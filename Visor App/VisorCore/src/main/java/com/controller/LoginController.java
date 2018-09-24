package com.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.entity.Student;
import com.entity.Role;
import com.service.IStudentService;

@Named
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IStudentService studentService;
	private Student student;

	@PostConstruct
	public void init() {
		this.student = new Student();
	}
	
	public void updateCategory() {
		try {
			studentService.updateStudent(student);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Estudiante actualizado", "Estudiante actualizado"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
	}

	public String login() {
		String redirect = "";
		try {
			student = this.studentService.login(this.student);

			if (student != null) {
				if (student.getRole().equals(Role.ROLE_ADMIN)) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("student", student);
					redirect = "admin/career?faces-redirect=true";
				} else if (student.getRole().equals(Role.ROLE_USER)) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("student", student);
					redirect = "user/index?faces-redirect=true";
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Credenciales incorrectas", "Credenciales incorrectas"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirect;
	}

	public void checkSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Student student = (Student) context.getExternalContext().getSessionMap().get("student");

			if (student == null) {
				context.getExternalContext().redirect("../login.xhtml");
			}

		} catch (Exception e) {

		}
	}

	public void closeSesion() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

	}



	public Student getStudent() {
		return student;
	}

	public void setStudent(Student s) {
		this.student = s;
	}

}
