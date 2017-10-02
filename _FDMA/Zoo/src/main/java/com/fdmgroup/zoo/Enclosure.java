package com.fdmgroup.zoo;

import java.util.ArrayList;
import java.util.List;

public class Enclosure 
{
	private List<Animal> animalList = new ArrayList<Animal>();

	public List<Animal> getAnimalList() 
	{
		return animalList;
	}

	public void addAnimal(Animal animal) 
	{
		animalList.add(animal);
		
	}

}
