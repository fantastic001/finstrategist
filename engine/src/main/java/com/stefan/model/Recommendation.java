package com.stefan.model;

import java.util.Date;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Recommendation {
	
	
	private String ticker; 
	
	private String action; 
	
	private LocalDate date; 
	
	public Recommendation() 
	{
	}
	public Recommendation(String _ticker, String _action, LocalDate _date) {
		super();
		 
		this.ticker = _ticker;
		 
		this.action = _action;
		 
		this.date = _date;
		
	}
	
	 
	public String getTicker() 
	{
		return this.ticker;
	}

	public void setTicker(String newValue) 
	{
		this.ticker = newValue;
	}
	 
	public String getAction() 
	{
		return this.action;
	}

	public void setAction(String newValue) 
	{
		this.action = newValue;
	}
	 
	public LocalDate getDate() 
	{
		return this.date;
	}

	public void setDate(LocalDate newValue) 
	{
		this.date = newValue;
	}
	
}