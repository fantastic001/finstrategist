package com.stefan.controller;

import com.stefan.service.DecisionService;

import java.util.List;

import com.stefan.model.Decision;


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
@RequestMapping(value = "decision")
public class DecisionController {
	
	@Autowired 
	DecisionService decisionService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<Decision>> findAll(){
		return new ResponseEntity<>(decisionService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Decision> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(decisionService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Decision dto){
		
		Decision decision = decisionService.save(dto);
		return new ResponseEntity<>(decision.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody Decision dto){
		
		Decision data = decisionService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
