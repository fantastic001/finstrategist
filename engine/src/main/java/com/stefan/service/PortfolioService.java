package com.stefan.service;

import java.util.List;

import com.stefan.model.Portfolio;
import com.stefan.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

	
	@Autowired
	PortfolioRepository portfolioRepository;
	
	
	public Portfolio findOneByid(Long id) {
		return portfolioRepository.findOneByid(id);
	}
	
	public List<Portfolio> findAll() {
		return portfolioRepository.findAll();
	}
	public Portfolio save(Portfolio portfolio) {
		return null;
	}
}