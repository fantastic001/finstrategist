package com.stefan.controller;

import com.stefan.service.CompanyInfoService;

import java.util.List;

import com.stefan.model.CompanyInfo;

import com.stefan.model.CompanyInfo;

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
@RequestMapping(value = "companyInfo")
public class CompanyInfoController {
	
	@Autowired 
	CompanyInfoService companyInfoService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<CompanyInfo>> findAll(){
		return new ResponseEntity<>(companyInfoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CompanyInfo> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(companyInfoService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody CompanyInfo dto){
		
		CompanyInfo companyInfo = companyInfoService.save(dto);
		return new ResponseEntity<>(companyInfo.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody CompanyInfo dto){
		
		CompanyInfo data = companyInfoService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}