package com.repository;

import java.util.List;

import com.entity.Exam;

public interface IExamRepository {
	public Exam save(Exam e) throws Exception;
	public List<Exam> findAll() throws Exception;
	public List<Exam> findAll(String course,int cycle,String type)throws Exception;
	

}
