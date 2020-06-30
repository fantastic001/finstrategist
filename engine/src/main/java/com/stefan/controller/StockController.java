package com.stefan.controller;

import com.stefan.service.CompanyInfoService;
import com.stefan.service.PortfolioService;
import com.stefan.service.StockService;

import java.util.Collection;
import java.util.List;

import com.stefan.main.Engine;
import com.stefan.model.Portfolio;
import com.stefan.model.Stock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "stock")
public class StockController {
	
	@Autowired 
	StockService stockService;

	@Autowired
	PortfolioService portfolioService;
	
	@Autowired
	CompanyInfoService companyInfoService;
	
	@GetMapping(value="/")
	public ResponseEntity<List<Stock>> findAll(){
		return new ResponseEntity<>(stockService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Stock> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(stockService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Stock dto){
		
		Collection<Stock> stocks = stockService.findAll();
		Portfolio portfolio = portfolioService.findAll().get(0);
		Engine engine = new Engine(stocks, portfolio, companyInfoService.findAll());
		Stock stock = stockService.save(dto);
		portfolioService.save(engine.decideOnStock(dto));
		return new ResponseEntity<>(stock.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody Stock dto){
		
		Stock data = stockService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
