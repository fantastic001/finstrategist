package com.stefan.model;

import java.util.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Portfolio {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Transient
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

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
