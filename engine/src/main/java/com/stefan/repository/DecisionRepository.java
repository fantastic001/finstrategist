package com.stefan.repository;

import java.util.List;

import com.stefan.model.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository extends JpaRepository<Decision, Long> {

	
	public Decision findOneByid(Long id);
	
	public List<Decision> findAll();
	
}