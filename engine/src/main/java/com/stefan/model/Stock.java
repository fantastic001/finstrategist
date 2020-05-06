package com.stefan.model;

import java.util.Date;

public class Stock {
	
	
	private String ticker; 
	
	private Date date; 
	
	private float open; 
	
	private float close; 
	
	private float high; 
	
	private float low; 
	
	private int volume; 
	
	public Stock() 
	{
	}
	public Stock(String _ticker, Date _date, float _open, float _close, float _high, float _low, int _volume) {
		super();
		 
		this.ticker = _ticker;
		 
		this.date = _date;
		 
		this.open = _open;
		 
		this.close = _close;
		 
		this.high = _high;
		 
		this.low = _low;
		 
		this.volume = _volume;
		
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
	 
	public float getOpen() 
	{
		return this.open;
	}

	public void setOpen(float newValue) 
	{
		this.open = newValue;
	}
	 
	public float getClose() 
	{
		return this.close;
	}

	public void setClose(float newValue) 
	{
		this.close = newValue;
	}
	 
	public float getHigh() 
	{
		return this.high;
	}

	public void setHigh(float newValue) 
	{
		this.high = newValue;
	}
	 
	public float getLow() 
	{
		return this.low;
	}

	public void setLow(float newValue) 
	{
		this.low = newValue;
	}
	 
	public int getVolume() 
	{
		return this.volume;
	}

	public void setVolume(int newValue) 
	{
		this.volume = newValue;
	}
	
}