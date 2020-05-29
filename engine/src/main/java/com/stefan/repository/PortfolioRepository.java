package com.stefan.repository;

import java.util.List;

import com.stefan.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

	
	public Portfolio findOneByid(Long id);
	
	public List<Portfolio> findAll();
	
}