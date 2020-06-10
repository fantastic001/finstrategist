package com.stefan.model;

import java.util.Date;

public class CompanyInfo {
	
	
	private String ticker; 
	
	private double totalRevenue; 
	
	private double netIncome; 
	
	private double assets; 
	
	private double cash; 
	
	private double netReceivables; 
	
	private double inventory; 
	
	private double otherCurrentAssets; 
	
	private double liabilities; 
	
	private double currentLiabilities; 
	
	public CompanyInfo() 
	{
	}
	public CompanyInfo(String _ticker, double _totalRevenue, double _netIncome, double _assets, double _cash, double _netReceivables, double _inventory, double _otherCurrentAssets, double _liabilities, double _currentLiabilities) {
		super();
		 
		this.ticker = _ticker;
		 
		this.totalRevenue = _totalRevenue;
		 
		this.netIncome = _netIncome;
		 
		this.assets = _assets;
		 
		this.cash = _cash;
		 
		this.netReceivables = _netReceivables;
		 
		this.inventory = _inventory;
		 
		this.otherCurrentAssets = _otherCurrentAssets;
		 
		this.liabilities = _liabilities;
		 
		this.currentLiabilities = _currentLiabilities;
		
	}
	
	 
	public String getTicker() 
	{
		return this.ticker;
	}

	public void setTicker(String newValue) 
	{
		this.ticker = newValue;
	}
	 
	public double getTotalRevenue() 
	{
		return this.totalRevenue;
	}

	public void setTotalRevenue(double newValue) 
	{
		this.totalRevenue = newValue;
	}
	 
	public double getNetIncome() 
	{
		return this.netIncome;
	}

	public void setNetIncome(double newValue) 
	{
		this.netIncome = newValue;
	}
	 
	public double getAssets() 
	{
		return this.assets;
	}

	public void setAssets(double newValue) 
	{
		this.assets = newValue;
	}
	 
	public double getCash() 
	{
		return this.cash;
	}

	public void setCash(double newValue) 
	{
		this.cash = newValue;
	}
	 
	public double getNetReceivables() 
	{
		return this.netReceivables;
	}

	public void setNetReceivables(double newValue) 
	{
		this.netReceivables = newValue;
	}
	 
	public double getInventory() 
	{
		return this.inventory;
	}

	public void setInventory(double newValue) 
	{
		this.inventory = newValue;
	}
	 
	public double getOtherCurrentAssets() 
	{
		return this.otherCurrentAssets;
	}

	public void setOtherCurrentAssets(double newValue) 
	{
		this.otherCurrentAssets = newValue;
	}
	 
	public double getLiabilities() 
	{
		return this.liabilities;
	}

	public void setLiabilities(double newValue) 
	{
		this.liabilities = newValue;
	}
	 
	public double getCurrentLiabilities() 
	{
		return this.currentLiabilities;
	}

	public void setCurrentLiabilities(double newValue) 
	{
		this.currentLiabilities = newValue;
	}
	
}