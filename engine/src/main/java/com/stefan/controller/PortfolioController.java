package com.stefan.controller;

import com.stefan.service.PortfolioService;

import java.util.List;

import com.stefan.model.Portfolio;


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
@RequestMapping(value = "portfolio")
public class PortfolioController {
	
	@Autowired 
	PortfolioService portfolioService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<Portfolio>> findAll(){
		return new ResponseEntity<>(portfolioService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Portfolio> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(portfolioService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Portfolio dto){
		
		Portfolio portfolio = portfolioService.save(dto);
		return new ResponseEntity<>(portfolio.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody Portfolio dto){
		portfolioService.deleteAll();
		Portfolio data = portfolioService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
