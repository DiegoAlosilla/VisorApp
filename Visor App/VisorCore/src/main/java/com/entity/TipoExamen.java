package com.entity;

public enum TipoExamen {
	TIPOEXAMEN1("Practica Calificada 1"),
	TIPOEXAMEN2("Practica Calificada 2"),
	TIPOEXAMEN3("Practica Calificada 3"),
	TIPOEXAMEN4("Examen Parcial"),
	TIPOEXAMEN5("Examen Final");
	
	
	private String name;

	
	private TipoExamen(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
