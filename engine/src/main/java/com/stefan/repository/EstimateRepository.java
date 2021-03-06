package com.stefan.repository;

import java.util.List;

import com.stefan.model.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {

	
	public Estimate findOneByid(Long id);
	
	public List<Estimate> findAll();

	
	
}