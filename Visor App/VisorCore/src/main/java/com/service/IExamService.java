package com.service;

import java.util.List;

import com.entity.Exam;

public interface IExamService {

	public Exam saveExam(Exam e) throws Exception;
	public List<Exam> getAllExams() throws Exception;
	public List<Exam> getAllByFilter(String course,int cycle,String type)throws Exception;
}
