package com.stefan.model;

import java.util.Date;

public class Estimate {
	
	
	private String ticker; 
	
	private Date date; 
	
	private float risk; 
	
	private float growth; 
	
	public Estimate() 
	{
	}
	public Estimate(String _ticker, Date _date, float _risk, float _growth) {
		super();
		 
		this.ticker = _ticker;
		 
		this.date = _date;
		 
		this.risk = _risk;
		 
		this.growth = _growth;
		
	}
	
	 
	public String getTicker() 
	{
		return this.ticker;
	}

	public void setTicker(String newValue) 
	{
		this.ticker = newValue;
	}
	 
	public Date getDate() 
	{
		return this.date;
	}

	public void setDate(Date newValue) 
	{
		this.date = newValue;
	}
	 
	public float getRisk() 
	{
		return this.risk;
	}

	public void setRisk(float newValue) 
	{
		this.risk = newValue;
	}
	 
	public float getGrowth() 
	{
		return this.growth;
	}

	public void setGrowth(float newValue) 
	{
		this.growth = newValue;
	}
	
}