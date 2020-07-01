package com.stefan.service;

import java.util.List;

import com.stefan.model.PortfolioAsset;
import com.stefan.repository.PortfolioAssetRepository;
import com.stefan.repository.PortfolioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioAssetService {

	
	@Autowired
	PortfolioAssetRepository portfolioAssetRepository;
	
	
	public PortfolioAsset findOneByid(Long id) {
		return portfolioAssetRepository.findOneByid(id);
	}
	
	public List<PortfolioAsset> findAll() {
		return portfolioAssetRepository.findAll();
	}

	public PortfolioAsset save(PortfolioAsset asset) {
		return portfolioAssetRepository.save(asset);
	}

	public void deleteAll() {
		portfolioAssetRepository.deleteAll();
	}
}