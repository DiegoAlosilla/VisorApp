package com.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.entity.Exam;

@Named
public class ExamRepository implements Serializable, IExamRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="VisorE")
	private EntityManager em;
	
	@Transactional
	@Override
	public Exam save(Exam e) throws Exception {
		em.persist(e);
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exam> findAll() throws Exception {
		List<Exam> exams = new ArrayList<>();
		Query query = em.createQuery("SELECT e FROM Exam e");
		exams = (List<Exam>) query.getResultList();
	
		return exams;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Exam> findAll( String course, int cycle, String type) throws Exception {
		// TODO Auto-generated method stub
		List<Exam> exams = new ArrayList<>();
		Query query = em.createQuery("SELECT e FROM Exam e WHERE e.idCourse LIKE ?1 AND e.cycle LIKE ?2 AND e.tipoExamen LIKE ?3");
		query.setParameter(1, '%'+course+'%');
		query.setParameter(2, '%'+cycle+'%');
		query.setParameter(3, '%'+type+'%');
		exams = (List<Exam>) query.getResultList();
		return exams;
	}
	
	
	
	
	
	

}
