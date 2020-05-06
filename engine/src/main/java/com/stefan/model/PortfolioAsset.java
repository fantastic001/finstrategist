package com.stefan.model;

import java.util.Date;

public class PortfolioAsset {
	
	
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