package com.fdmgroup.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.DAO.CartRecordDAO;
import com.fdmgroup.Utility.Constant;

public class Cart 
{
	int id;
	List<CartRecord> recordList;
	CartRecordDAO cartRecordDAO;
	
	//bean constructor
	public Cart()
	{
		this.id = Constant.invalidId();
		this.recordList = new ArrayList<CartRecord>();
		this.cartRecordDAO = new CartRecordDAO();
	}
	
	//new constructor
	public Cart(List<CartRecord> recordList)
	{
		this.id = Constant.invalidId();
		this.recordList = recordList;
		this.cartRecordDAO = new CartRecordDAO();
	}
	
	//existing constructor, empty List
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
		
		if(result < Constant.invalidId())
			result = Constant.invalidId();
		
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
	
	public CartRecord getRecordById(int targetId)
	{
		CartRecord result = Constant.emptyRecord();
		//restrict parameter by database requirements
		if(targetId <= Constant.invalidId())
		{
			return result;
		}
		
		for(int x = 0; x < recordList.size(); x++)
		{
			if(recordList.get(x).getItem().getId() == targetId)
			{
				result = recordList.get(x);
			}
		}
		
		return result;
	}
	
}
