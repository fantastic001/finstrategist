package com.stefan.model;

import java.util.Date;
import java.time.LocalDate;

public class Option {
	
	
	private String name; 
	
	private String ticker; 
	
	private String type; 
	
	private double payoff; 
	
	private LocalDate maturityDate; 
	
	public Option() 
	{
	}
	public Option(String _name, String _ticker, String _type, double _payoff, LocalDate _maturityDate) {
		super();
		 
		this.name = _name;
		 
		this.ticker = _ticker;
		 
		this.type = _type;
		 
		this.payoff = _payoff;
		 
		this.maturityDate = _maturityDate;
		
	}
	
	 
	public String getName() 
	{
		return this.name;
	}

	public void setName(String newValue) 
	{
		this.name = newValue;
	}
	 
	public String getTicker() 
	{
		return this.ticker;
	}

	public void setTicker(String newValue) 
	{
		this.ticker = newValue;
	}
	 
	public String getType() 
	{
		return this.type;
	}

	public void setType(String newValue) 
	{
		this.type = newValue;
	}
	 
	public double getPayoff() 
	{
		return this.payoff;
	}

	public void setPayoff(double newValue) 
	{
		this.payoff = newValue;
	}
	 
	public LocalDate getMaturityDate() 
	{
		return this.maturityDate;
	}

	public void setMaturityDate(LocalDate newValue) 
	{
		this.maturityDate = newValue;
	}
	
}