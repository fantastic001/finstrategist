package com.stefan.service;

import java.util.List;

import com.stefan.model.Estimate;
import com.stefan.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstimateService {

	
	@Autowired
	EstimateRepository estimateRepository;
	
	
	public Estimate findOneByid(Long id) {
		return estimateRepository.findOneByid(id);
	}
	
	public List<Estimate> findAll() {
		return estimateRepository.findAll();
	}

	public Estimate save(Estimate estimate) {
		return null;
	}
}