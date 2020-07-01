package com.stefan.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PortfolioAsset {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	private String ticker; 
	
	private int count; 
	
	public PortfolioAsset() 
	{
	}
	public PortfolioAsset(String _ticker, int _count) {
		super();
		 
		this.ticker = _ticker;
		 
		this.count = _count;
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	 
	public String getTicker() 
	{
		return this.ticker;
	}

	public void setTicker(String newValue) 
	{
		this.ticker = newValue;
	}
	 
	public int getCount() 
	{
		return this.count;
	}

	public void setCount(int newValue) 
	{
		this.count = newValue;
	}
	
}