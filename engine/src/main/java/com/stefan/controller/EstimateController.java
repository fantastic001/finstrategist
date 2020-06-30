package com.stefan.controller;

import com.stefan.service.EstimateService;

import java.util.List;

import com.stefan.model.Estimate;


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
@RequestMapping(value = "estimate")
public class EstimateController {
	
	@Autowired 
	EstimateService estimateService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<Estimate>> findAll(){
		return new ResponseEntity<>(estimateService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Estimate> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(estimateService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Estimate dto){
		
		Estimate estimate = estimateService.save(dto);
		return new ResponseEntity<>(estimate.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody Estimate dto){
		
		Estimate data = estimateService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
