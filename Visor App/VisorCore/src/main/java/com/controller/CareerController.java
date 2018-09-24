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
import com.service.ICareerServive;

@Named
@SessionScoped
public class CareerController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICareerServive careerService;
	
	private List<Career> careers;
	private Career career;
	private Career careerSelection;
	
	@PostConstruct
	public void init()
	{
		careers = new ArrayList<>();
		career = new Career();
		careerSelection = new Career();
		
		this.getAllCareers();
	}
	
	public void cleanCareer()
	{
		career=new Career();
	}
	
	public String newCareer()
	{
		this.cleanCareer();
		return "/admin/newCareer?faces-redirect=true";
	}
	
	public String editCareer()
	{
		String rpta = null;
		
		if(this.careerSelection!=null)
		{
			this.career = this.careerSelection;
			rpta ="/admin/editCareer?faces-redirect=true";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Carrera no seleccionada", "Carrera no seleccionada"));
		}
		
		return rpta;
	}
	
	public void deleteCareer()
	{
		try {
			if(this.careerSelection!=null)
			{
				careerService.deleteCareer(careerSelection);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Carrera Eliminada", "Carrera Eliminada"));
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Carrera no seleccionada", "Carrera no seleccionada"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void saveCareer() {
		try {
			careerService.saveCareer(career);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Carrera registrada", "Carrera registrada"));
			this.getAllCareers();
			this.cleanCareer();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
	}
	
	public void updateCareeer() {
		try {
			careerService.updateCareer(career);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Carrera actualizado", "Carrera actualizado"));
			this.cleanCareer();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
	}
	
	public void getAllCareers()
	{
		try {
			careers=careerService.findAllCareer();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public Career getCareerSelection() {
		return careerSelection;
	}

	public void setCareerSelection(Career careerSelection) {
		this.careerSelection = careerSelection;
	}

}
