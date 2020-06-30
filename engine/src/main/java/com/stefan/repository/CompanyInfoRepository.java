package com.stefan.repository;

import java.util.List;

import com.stefan.model.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {

	
	public CompanyInfo findOneByid(Long id);
	
	public List<CompanyInfo> findAll();
	
}