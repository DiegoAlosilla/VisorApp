package com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.entity.Year;
import com.entity.Exam;
import com.entity.TipoExamen;
import com.repository.IExamRepository;

@Named
public class ExamService implements Serializable, IExamService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IExamRepository examRepository;

	@Override
	public Exam saveExam(Exam e) throws Exception {
		// TODO Auto-generated method stub
		int number = numberCycle(e.getYear());
		e.setCycle(number);
		String examen = tipoExamen(e.getTipo());
		e.setTipoExamen(examen);
			
		return examRepository.save(e);
	}

	@Override
	public List<Exam> getAllExams() throws Exception {
		// TODO Auto-generated method stub
		return examRepository.findAll();
	}
	
	@Override
	public List<Exam> getAllByFilter(String course, int cycle, String type) throws Exception {
		
		return examRepository.findAll(course, cycle, type);
	}

	private String tipoExamen(TipoExamen t) {
		String examen = "";

		switch (t) {
		case TIPOEXAMEN1:
			examen = "Practica Calificada 1";
			break;
		case TIPOEXAMEN2:
			examen = "Practica Calificada 2";
			break;
		case TIPOEXAMEN3:
			examen = "Practica Calificada 3";
			break;
		case TIPOEXAMEN4:
			examen = "Examen Parcial";
			break;
		case TIPOEXAMEN5:
			examen = "Examen Final";
			break;
		default:
			break;
		}

		return examen;
	}

	private int numberCycle(Year cycle) {
		int number = 0;

		switch (cycle) {
		case YEAR1:
			number = 20150;
			break;
		case YEAR2:
			number = 20151;
			break;
		case YEAR3:
			number = 20152;
			break;
		case YEAR4:
			number = 20160;
			break;
		case YEAR5:
			number = 20161;
			break;
		case YEAR6:
			number = 20162;
			break;
		case YEAR7:
			number = 20170;
			break;
		case YEAR8:
			number = 20171;
			break;
		case YEAR9:
			number = 20172;
			break;
		case YEAR10:
			number = 20180;
			break;
		case YEAR11:
			number = 20181;
			break;
		case YEAR12:
			number = 20182;
			break;

		default:
			break;
		}

		return number;
	}

	

}
