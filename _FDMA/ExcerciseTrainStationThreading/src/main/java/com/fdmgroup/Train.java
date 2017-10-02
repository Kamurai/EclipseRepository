package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class Train
{
	//Train:
	//Name: String identifier
	String name;
	//Capacity: int limit of Persons
	int capacity;
	List<Person> personList;
	//Destination List: list of stations on route
	List<Station> destinationList;
	//Current destination: where the train is
	Station currentDestination;
	//Current destination index: the index of the current destination
	int currentDestinationIndex;
	//Direction on route
	boolean forward;
	
	public Train(String name, int capacity, List<Station> tempDestinationList)
	{
		this.name = name;
		this.capacity = capacity;
		this.personList = new ArrayList();
		this.destinationList = tempDestinationList;
		this.currentDestinationIndex = 0;
		forward = true;
	}
	
	//addPersonToTrain()
	public void addPersonToTrain(Person somePerson)
	{
		personList.add(somePerson);
	}
	
	//removePersonFromTrain()
	public void removePersonFromTrain(Person somePerson)
	{
		for(int x = 0; x < personList.size(); x++)
		{
			if(somePerson.getName().equals(personList.get(x).getName()))
			{
				personList.remove(x);
			}
		}
	}
	
	//moveToNextDestination()
	public void moveToNextDestination()
	{
		//if at 1st, then go to 2nd
		if( currentDestinationIndex == 0 )
		{
			//wait? then move
			forward = true;
			currentDestinationIndex++;
		}
		//if going forward, then go to n+1
		else if( forward )
		{
			//wait? then move
			currentDestinationIndex++;
		}
		//if going backward, then go to n-1
		else if( !forward )
		{
			//wait? then move
			currentDestinationIndex--;
		}
		//if at last, then go to 2nd to last
		else if( currentDestinationIndex == destinationList.size()-1 )
		{
			//wait? then move
			forward = false;
			currentDestinationIndex--;
		}
	}
}
