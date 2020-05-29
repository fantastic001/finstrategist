package com.stefan.repository;

import java.util.List;

import com.stefan.model.PortfolioAsset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioAssetRepository extends JpaRepository<PortfolioAsset, Long> {

	
	public PortfolioAsset findOneByid(Long id);
	
	public List<PortfolioAsset> findAll();
	
}