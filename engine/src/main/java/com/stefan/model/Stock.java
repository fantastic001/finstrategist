package com.stefan.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String ticker; 
	
	private LocalDate date; 
	
	private float open; 
	
	private float close; 
	
	private float high; 
	
	private float low; 
	
	private int volume; 

	private float dividend;
	
	public Stock() 
	{
	}
	public Stock(String _ticker, LocalDate _date, float _open, float _close, float _high, float _low, int _volume, float _dividend) {
		super();
		 
		this.ticker = _ticker;
		 
		this.date = _date;
		 
		this.open = _open;
		 
		this.close = _close;
		 
		this.high = _high;
		 
		this.low = _low;
		 
		this.volume = _volume;
		
		this.dividend = _dividend;
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
	
	public float getDividend() {
		return this.dividend;
	}

	public void setDividend(float _dividend) {
		this.dividend = _dividend;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}