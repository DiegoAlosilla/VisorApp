package com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.entity.Student;

@Named
public class StudentRepository implements Serializable,IStudentRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "VisorE")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Student login(Student u) throws Exception {
		
		Student student=null;// = new Student();
		Query query = em.createQuery("FROM Student s WHERE s.tiu = ?1 and s.password = ?2");
		
		query.setParameter(1, u.getTiu());
		query.setParameter(2, u.getPassword());

		List<Student> students = query.getResultList();
		if (!students.isEmpty()) 
			student = students.get(0);
		
		return student;
	}

	@Transactional
	@Override
	public Student update(Student s) throws Exception {
		em.merge(s);
		return s;
	}
	


}
