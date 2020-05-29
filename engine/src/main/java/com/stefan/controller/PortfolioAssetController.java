package com.stefan.controller;

import com.stefan.service.PortfolioAssetService;

import java.util.List;

import com.stefan.model.PortfolioAsset;


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
@RequestMapping(value = "")
public class PortfolioAssetController {
	
	@Autowired 
	PortfolioAssetService portfolioAssetService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<PortfolioAsset>> findAll(){
		return new ResponseEntity<>(portfolioAssetService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PortfolioAsset> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(portfolioAssetService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody PortfolioAsset dto){
		
		PortfolioAsset portfolioAsset = portfolioAssetService.save(dto);
		return new ResponseEntity<>(portfolioAsset.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody PortfolioAsset dto){
		
		PortfolioAsset data = portfolioAssetService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
