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
	
	@Autowired
	PortfolioAssetService portfolioAssetService;
	
	
	public Portfolio findOneByid(Long id) {
		Portfolio portfolio = portfolioRepository.findOneByid(id);
		portfolio.setAssets(portfolioAssetService.findAll());
		return portfolio;
	}
	
	public List<Portfolio> findAll() {
		return portfolioRepository.findAll();
	}
	public Portfolio save(Portfolio portfolio) {
		return portfolioRepository.save(portfolio);
	}
	public void deleteAll() {
		portfolioRepository.deleteAll();
	}
}
