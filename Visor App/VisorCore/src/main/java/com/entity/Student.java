package com.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name ="students")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre",nullable=false,length=30)
	private String nombre;
	
	@Column(name="apellidos",nullable=false,length=30)
	private String apellidos;
	
	@Column(name = "tiu",nullable = false,length = 10)
	private String tiu;
	
	@Column(name = "password",nullable = false,length = 10)
	private String password;
	
	@Column(name="puntos",nullable=false,length=30)
	private int puntos;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	/////////////
	//GET--SET///
	/////////////
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTiu() {
		return tiu;
	}

	public void setTiu(String tiu) {
		this.tiu = tiu;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
