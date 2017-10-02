package com.fdmgroup.AbstractClasses.Eg03;

public class Protoss extends Xenos
{
	String race;
	String name;
	
	public Protoss(String name)
	{
		this.name = name;
		this.race = "Protoss";
	}
	
	@Override
	public void Assimilate() {
		// TODO Auto-generated method stub
		System.out.println("The " + designation + " of " + race + " are assimilating the population!");
	}

	@Override
	public void Invade() {
		// TODO Auto-generated method stub
		System.out.println("The " + designation + " of " + race + " are invading the planet!");
	}

	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		System.out.println("The " + designation + " of " + race + " are attacking the system!");
	}

}
