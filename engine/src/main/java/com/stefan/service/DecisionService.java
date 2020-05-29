package com.stefan.service;

import java.util.List;

import com.stefan.model.Decision;
import com.stefan.repository.DecisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecisionService {

	
	@Autowired
	DecisionRepository decisionRepository;
	
	
	public Decision findOneByid(Long id) {
		return decisionRepository.findOneByid(id);
	}
	
	public List<Decision> findAll() {
		return decisionRepository.findAll();
	}
	public Decision save(Decision decision) {
		return null;
	}
}
