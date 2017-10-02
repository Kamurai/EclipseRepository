package com.fdmgroup.AbstractClasses.Eg01;

public class Knight extends Character
{
	String stance; //enum: shield, two-handed, dual wielding
	
	public Knight(String name)
	{
		this.job = "Knight";
		this.name = name;
	}
	
	
	public void RaiseShield()
	{
		System.out.println("The Knight raises its shield.");
	}


	@Override
	public void Defend() {
		// TODO Auto-generated method stub
		System.out.println("The Knight takes a defensive stance.");
	}
	
}
