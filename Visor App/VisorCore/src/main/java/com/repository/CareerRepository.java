package com.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.entity.Career;

@Named
public class CareerRepository implements Serializable,ICareerRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="VisorE")
	private EntityManager em;
	
	@Transactional
	@Override
	public Career save(Career c) throws Exception {
		em.persist(c);
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Career> findAll() throws Exception {
		List<Career> careers = new ArrayList<>();
		Query query =em.createQuery("SELECT c FROM Career c");
		careers =(List<Career>)query.getResultList();
		return careers;
		
	}

	
	@Transactional
	@Override
	public Career update(Career c) throws Exception {
		em.merge(c);
		return c;
	}

	@Transactional
	@Override
	public Career delete(Career c) throws Exception {
		// TODO Auto-generated method stub
		em.remove(c);
		return c;
	}
	
	

}
