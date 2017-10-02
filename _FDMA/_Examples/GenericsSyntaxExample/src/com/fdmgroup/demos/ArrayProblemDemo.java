package com.fdmgroup.demos;

import java.util.ArrayList;
import java.util.List;

/* This demonstrates a typing problem with Java arrays.
 * 
 * When using arrays, the situation below would result in 
 * runtime errors.
 * 
 * With generics, these are prevented at compile time.
 * 
 * */

public class ArrayProblemDemo {
	
	// This method adds a Dog to the Animal array.
	// However, a Cats-only array could be passed in
	// and will compile. The program will crash at runtime.
	public static void addAnimalToArray(Animal[] animals)
	{
		animals[0] = new Dog(); 
	}
	
	// With generics, we can do any of the following:
	
	public static void addAnimalToList(List<Animal> animalList)
	{
		animalList.add(new Dog());
		animalList.add(new Cat());
	}
	
	public static void addCat(List<Cat> catList)
	{
		catList.add(new Cat());
		//catList.add(new Dog());  // Not allowed
	}
	
	public static void addDog(List<Dog> dogList)
	{
		dogList.add(new Dog());
		//dogList.add(new Cat());		// Not allowed
	}	
	
	public static void noAddsAllowed(List<? extends Animal> listOfSomeAnimalType)
	{
		// This method parameter will accept a List of some kind of animal,
		// that is, List<Dog>, List<Cat>, or List<Animal>
		
		// Because we do not know exactly what kind of list we are getting
		// (what the restriction is), no add operations are allowed at all!
		
		// listOfSomeAnimalType.add(new Dog());
		// listOfSomeAnimalType.add(new Cat()); 
		// listOfSomeAnimalType.add(new Animal()); 

	}	
	
	public static void main(String[] args) {
		
		Cat[] cats = new Cat[2];
		cats[0] = new Cat();
		cats[1] = new Cat();
//		addAnimalToArray(cats);    // This will crash
		
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());		
		
		addAnimalToList(animals);
		
		addCat(new ArrayList<Cat>());

		addDog(new ArrayList<Dog>());
		
		noAddsAllowed(new ArrayList<Animal>());
		noAddsAllowed(new ArrayList<Dog>());
		noAddsAllowed(new ArrayList<Cat>());
	}
}
