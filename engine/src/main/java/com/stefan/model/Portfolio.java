package com.stefan.model;

import java.util.Date;
import java.util.Collection;

public class Portfolio {
	
	
	private Collection<PortfolioAsset> assets; 
	
	private float cash; 
	
	public Portfolio() 
	{
	}
	public Portfolio(Collection<PortfolioAsset> _assets, float _cash) {
		super();
		 
		this.assets = _assets;
		 
		this.cash = _cash;
		
	}
	
	 
	public Collection<PortfolioAsset> getAssets() 
	{
		return this.assets;
	}

	public void setAssets(Collection<PortfolioAsset> newValue) 
	{
		this.assets = newValue;
	}
	 
	public float getCash() 
	{
		return this.cash;
	}

	public void setCash(float newValue) 
	{
		this.cash = newValue;
	}
	
}
