package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class Station 
{
	//Station:
	//Name: String identifier
	String name;
	//Capacity: int limit of Persons
	int capacity;
	List<Person> personList;
	
	public Station(String name, int capacity)
	{
		this.name = name;
		this.capacity = capacity;
		this.personList = new ArrayList();
	}
	
	//addPersonToStation()
	public void addPersonToStation(Person somePerson)
	{
		personList.add(somePerson);
	}
	
	//removePersonFromStation()
	public void removePersonFromStation(Person somePerson)
	{
		for(int x = 0; x < personList.size(); x++)
		{
			if(somePerson.getName().equals(personList.get(x).getName()))
			{
				personList.remove(x);
			}
		}
	}

	public String getName() {
		return name;
	}
}
