package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "year", nullable = false, length = 40)
	@Enumerated(EnumType.STRING)
	private Year year;

	@Column(name = "cycle", nullable = false, length = 10)
	private int cycle;

	@Column(name = "tipo", nullable = true, length = 40)
	@Enumerated(EnumType.STRING)
	private TipoExamen tipo;

	@Column(name = "tipoExamen", nullable = false, length = 50)
	private String tipoExamen;

	@Column(name = "file", nullable = false)
	private byte[] file;

	@ManyToOne
	private Course idCourse;

	@ManyToOne
	private Student idStudent;

	///////////
	// get-set//
	///////////

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public TipoExamen getTipo() {
		return tipo;
	}

	public void setTipo(TipoExamen tipo) {
		this.tipo = tipo;
	}

	public String getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Course getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Course idCourse) {
		this.idCourse = idCourse;
	}

	public Student getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Student idStudent) {
		this.idStudent = idStudent;
	}

}
