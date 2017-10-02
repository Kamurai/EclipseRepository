package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class Driver 
{
	//Train Station problem
	//People have to ride a train?
		//Requirements:
			//Person:
			//Train(s)
	//People have to show up at a platform
		//Requirements: People, station, People.arrive()
			//Person:
				//Name: String identifier
				//Destination: Station with String identifier
				//arrive(): arrive at station
			//Station:
				//Name: String identifier
				//Capacity: int limit of Persons
	//People have to board a train
		//Requirements: People, train, People.board()
			//Person:
				//board(): get on train
			//Train:
				//Name: String identifier
				//Capacity: int limit of Persons
	//People have to off board a train
		//Requirements: People, train, People.offBoard()
			//Person:
				//offBoard(): get off train	
			//Train:
	//People may leave a platform
		//Requirements: People, station, People.leave()
			//Person:
				//leave(): leave station
		//Station:
	
	static List<Station> stationList;
	static List<Train> trainList;
	static List<Person> personList;
	
	static final int stationLimit = 10;
	static final int trainLimit = stationLimit/5;

	public static void main(String[] args) 
	{
		stationList = new ArrayList<Station>();
		trainList = new ArrayList<Train>();
		personList = new ArrayList<Person>();
		
		Station alphaStation = new Station("Alpha Station", stationLimit);
		Station bravoStation = new Station("Bravo Station", stationLimit);
		
		stationList.add(alphaStation);
		stationList.add(bravoStation);
		
		List<Station> tempDestinationList = new ArrayList<Station>();
		tempDestinationList.add(alphaStation);
		tempDestinationList.add(bravoStation);
		
		Train alphaTrain = new Train("Alpha Train", trainLimit, tempDestinationList);
		
		trainList.add(alphaTrain);
		
		Person person01 = new Person("Person01", bravoStation);
		alphaStation.addPersonToStation(person01);
		Person person02 = new Person("Person02", bravoStation);
		alphaStation.addPersonToStation(person02);
		Person person03 = new Person("Person03", bravoStation);
		alphaStation.addPersonToStation(person03);
		Person person04 = new Person("Person04", bravoStation);
		alphaStation.addPersonToStation(person04);
		Person person05 = new Person("Person05", bravoStation);
		alphaStation.addPersonToStation(person05);
		Person person06 = new Person("Person06", bravoStation);
		alphaStation.addPersonToStation(person06);
		Person person07 = new Person("Person07", bravoStation);
		alphaStation.addPersonToStation(person07);
		Person person08 = new Person("Person08", bravoStation);
		alphaStation.addPersonToStation(person08);
		Person person09 = new Person("Person09", bravoStation);
		alphaStation.addPersonToStation(person09);
		Person person10 = new Person("Person10", bravoStation);
		alphaStation.addPersonToStation(person10);
		
		Person person11 = new Person("Person11", alphaStation);
		bravoStation.addPersonToStation(person11);
		Person person12 = new Person("Person12", alphaStation);
		bravoStation.addPersonToStation(person12);
		Person person13 = new Person("Person13", alphaStation);
		bravoStation.addPersonToStation(person13);
		Person person14 = new Person("Person14", alphaStation);
		bravoStation.addPersonToStation(person14);
		Person person15 = new Person("Person15", alphaStation);
		bravoStation.addPersonToStation(person15);
		Person person16 = new Person("Person16", alphaStation);
		bravoStation.addPersonToStation(person16);
		Person person17 = new Person("Person17", alphaStation);
		bravoStation.addPersonToStation(person17);
		Person person18 = new Person("Person18", alphaStation);
		bravoStation.addPersonToStation(person18);
		Person person19 = new Person("Person19", alphaStation);
		bravoStation.addPersonToStation(person19);
		Person person20 = new Person("Person20", alphaStation);
		bravoStation.addPersonToStation(person20);
	}

}
