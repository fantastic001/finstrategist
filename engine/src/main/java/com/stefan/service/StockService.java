package com.stefan.service;

import java.util.List;

import com.stefan.model.Stock;
import com.stefan.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	
	@Autowired
	StockRepository stockRepository;
	
	
	public Stock findOneByid(Long id) {
		return stockRepository.findOneByid(id);
	}
	
	public List<Stock> findAll() {
		return stockRepository.findAll();
	}
	public Stock save(Stock stock) {
		return stockRepository.save(stock);
	}
}