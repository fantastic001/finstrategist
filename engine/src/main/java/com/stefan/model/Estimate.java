package com.stefan.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estimate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	private String ticker; 
	
	private LocalDate date; 
	
	private float risk; 
	
	private float growth; 
	
	public Estimate() 
	{
	}
	public Estimate(String _ticker, LocalDate _date, float _risk, float _growth) {
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
	 
	public LocalDate getDate() 
	{
		return this.date;
	}

	public void setDate(LocalDate newValue) 
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


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
}