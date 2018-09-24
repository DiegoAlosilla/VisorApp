package com.service;

import java.util.List;

import com.entity.Career;

public interface ICareerServive {
	public Career saveCareer(Career c)throws Exception;
	public List<Career> findAllCareer() throws Exception;
	public Career updateCareer(Career c)throws Exception;
	public Career deleteCareer(Career c)throws Exception;

}
