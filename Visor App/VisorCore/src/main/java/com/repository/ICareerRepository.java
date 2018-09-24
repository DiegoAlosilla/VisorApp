package com.repository;

import java.util.List;

import com.entity.Career;

public interface ICareerRepository{
	public Career save(Career c)throws Exception;
	public List<Career> findAll() throws Exception;
	public Career update(Career c)throws Exception;
	public Career delete(Career c)throws Exception;
	
}
