package com.stefan.controller;

import java.util.List;

import com.stefan.main.Configuration;

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
@RequestMapping(value = "config")
public class ConfigurationController {

	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Double> findOneByid(@PathVariable("id") String id){
		return new ResponseEntity<>((Double) Configuration.getInstance().getProperty(id, 0.), HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Double> update(@PathVariable("id") String id, @RequestBody Double dto){
		
		Configuration.getInstance().setProperty(id, dto);
		return new ResponseEntity<>((Double) Configuration.getInstance().getProperty(id, 0), HttpStatus.OK);
	}
}