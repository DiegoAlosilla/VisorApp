package com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


import com.entity.Career;
import com.repository.ICareerRepository;

@Named
public class CareerService  implements Serializable, ICareerServive{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICareerRepository careerRepository;
	
	@Override
	public Career saveCareer(Career c) throws Exception {
		// TODO Auto-generated method stub
		return careerRepository.save(c);
	}

	@Override
	public List<Career> findAllCareer() throws Exception {
		// TODO Auto-generated method stub
		return careerRepository.findAll();
	}
	
	
	@Override
	public Career updateCareer(Career c) throws Exception {
		// TODO Auto-generated method stub
		return careerRepository.update(c);
	}

	@Override
	public Career deleteCareer(Career c) throws Exception {
		// TODO Auto-generated method stub
		return careerRepository.delete(c);
	}
	

}
