package com.stefan.model;

import java.util.Date;

public class Decision {
	
	
	private String ticker; 
	
	private Date date; 
	
	private int count; 
	
	private Action action; 
	
	public Decision() 
	{
	}
	public Decision(String _ticker, Date _date, int _count, Action _action) {
		super();
		 
		this.ticker = _ticker;
		 
		this.date = _date;
		 
		this.count = _count;
		 
		this.action = _action;
		
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
	 
	public int getCount() 
	{
		return this.count;
	}

	public void setCount(int newValue) 
	{
		this.count = newValue;
	}
	 
	public Action getAction() 
	{
		return this.action;
	}

	public void setAction(Action newValue) 
	{
		this.action = newValue;
	}
	
}