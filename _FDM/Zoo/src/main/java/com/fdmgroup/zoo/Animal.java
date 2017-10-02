package com.fdmgroup.zoo;

public abstract class Animal 
{
	private int animalId;
	private String name;
	private Enclosure enclosure;
	
	
	public Animal(int animalId, String name, Enclosure enclosure) {
		super();
		this.animalId = animalId;
		this.name = name;
		this.enclosure = enclosure;
	}
	
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Enclosure getEnclosure() {
		return enclosure;
	}
	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}
	
}
