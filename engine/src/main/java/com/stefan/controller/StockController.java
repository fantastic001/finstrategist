package com.stefan.controller;

import com.stefan.service.CompanyInfoService;
import com.stefan.service.PortfolioAssetService;
import com.stefan.service.PortfolioService;
import com.stefan.service.StockService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.stefan.main.Engine;
import com.stefan.model.Portfolio;
import com.stefan.model.PortfolioAsset;
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

	@Autowired
	PortfolioAssetService portfolioAssetService;
	
	@GetMapping(value="")
	public ResponseEntity<List<Stock>> findAll(){
		System.err.println("Stock list");
		return new ResponseEntity<>(stockService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Stock> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(stockService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Stock dto){
		System.out.println("Getting all stocks");
		Collection<Stock> stocks = stockService.findAll();
		System.out.println("Getting portfolio");
		Collection<Portfolio> portfolios = portfolioService.findAll();
		Portfolio portfolio = new Portfolio(new ArrayList<>(), 0);
		if (portfolios.size() > 0) portfolio = portfolios.stream().findFirst().get();
		System.out.println("Adding assets to portfolio");
		portfolio.setAssets(portfolioAssetService.findAll());
		System.out.println("Creating engine");
		Engine engine = new Engine(stocks, portfolio, companyInfoService.findAll());
		System.out.println("Saving stock to db");
		Stock stock = stockService.save(dto);
		portfolioService.deleteAll();
		System.out.println("Deciding on stock");
		portfolioService.save(engine.decideOnStock(dto));
		System.out.println("Deleting old portfolio state");
		portfolioAssetService.deleteAll();
		System.out.println("setting up new portfolio state");
		for (PortfolioAsset asset : portfolio.getAssets()) {
			System.out.println("Saving " + asset.getTicker());
			portfolioAssetService.save(asset);
		}
		System.out.println("Finished!");
		return new ResponseEntity<>(stock.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody Stock dto){
		
		Stock data = stockService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
