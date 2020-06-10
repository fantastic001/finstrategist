package com.stefan.model;

import java.util.Date;
import java.time.LocalDate;

public class Bond {
	
	
	private String name; 
	
	private String riskCategory; 
	
	private double startPrice; 
	
	private double couponValue; 
	
	private LocalDate maturityDate; 
	
	public Bond() 
	{
	}
	public Bond(String _name, String _riskCategory, double _startPrice, double _couponValue, LocalDate _maturityDate) {
		super();
		 
		this.name = _name;
		 
		this.riskCategory = _riskCategory;
		 
		this.startPrice = _startPrice;
		 
		this.couponValue = _couponValue;
		 
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
	 
	public String getRiskCategory() 
	{
		return this.riskCategory;
	}

	public void setRiskCategory(String newValue) 
	{
		this.riskCategory = newValue;
	}
	 
	public double getStartPrice() 
	{
		return this.startPrice;
	}

	public void setStartPrice(double newValue) 
	{
		this.startPrice = newValue;
	}
	 
	public double getCouponValue() 
	{
		return this.couponValue;
	}

	public void setCouponValue(double newValue) 
	{
		this.couponValue = newValue;
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