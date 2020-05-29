package com.stefan.repository;

import java.util.List;

import com.stefan.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

	
	public Stock findOneByid(Long id);
	
	public List<Stock> findAll();
	
}