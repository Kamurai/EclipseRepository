package com.fdmgroup.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.DAO.CartRecordDAO;

public class Cart 
{
	int id;
	List<CartRecord> recordList;
	CartRecordDAO cartRecordDAO;
	
	//bean constructor
	public Cart()
	{
		this.id = -1;
		this.recordList = new ArrayList<CartRecord>();
		this.cartRecordDAO = new CartRecordDAO();
	}
	
	//new constructor
	public Cart(List<CartRecord> recordList)
	{
		this.id = -1;
		this.recordList = recordList;
		this.cartRecordDAO = new CartRecordDAO();
	}
	
	//new constructor, empty List
	public Cart(int id)
	{
		this.id = restrictId(id);
		this.recordList = new ArrayList<CartRecord>();
		this.cartRecordDAO = new CartRecordDAO();
	}
	
	//existing constructor
	public Cart(int id, List<CartRecord> recordList)
	{
		this.id = restrictId(id);
		this.recordList = new ArrayList<CartRecord>();
		this.cartRecordDAO = new CartRecordDAO();
	}
	
	public int restrictId(int id)
	{
		int result = id;
		
		if(result < -1)
			result = -1;
		
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CartRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<CartRecord> recordList) {
		this.recordList = recordList;
	}

	public void addRecord(CartRecord record) 
	{
		recordList.add(record);
	}
	
	
	
}
