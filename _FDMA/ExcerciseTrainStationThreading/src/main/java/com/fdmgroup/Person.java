package com.fdmgroup;

public class Person 
{
	//Person:
	//Name: String identifier
	String name;
	//Destination: Station with String identifier
	Station destination;
	
	public Person(String name, Station destination)
	{
		this.name = name;
		this.destination = destination;
	}

	public String getName() {
		return name;
	}
	
	//arriveAtStation(Station targetStation)
	public void arriveAtStation(Station targetStation)
	{
		targetStation.addPersonToStation(this);
	}
	
	//boardTrain(Train targetTrain)
	public void boardTrain(Train targetTrain)
	{
		targetTrain.addPersonToTrain(this);
	}
	
	//offBoardTrain()
	public void offBoardTrain(Train targetTrain)
	{
		targetTrain.removePersonFromTrain(this);
	}
	
	//leaveStation()
	public void leaveStation(Station targetStation)
	{
		targetStation.removePersonFromStation(this);
	}
}
