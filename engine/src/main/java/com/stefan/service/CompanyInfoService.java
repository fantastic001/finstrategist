package com.stefan.service;

import java.util.List;

import com.stefan.model.CompanyInfo;
import com.stefan.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoService {

	
	@Autowired
	CompanyInfoRepository companyInfoRepository;
	
	
	public CompanyInfo findOneByid(Long id) {
		return companyInfoRepository.findOneByid(id);
	}
	
	public List<CompanyInfo> findAll() {
		return companyInfoRepository.findAll();
	}

	public CompanyInfo save(CompanyInfo companyInfo) {
		return companyInfoRepository.save(companyInfo);
	}
}