package com.fdmgroup.com;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.HealthPack;
import com.fdmgroup.serialization.game.Player;

public abstract class JobClass extends Player implements Serializable
{
	CharacterBackpack backpack;
	
	
	public JobClass()
	{
		backpack = new CharacterBackpack();
		setHealthPoints(10);
	}
	
	public void gainHealthPack(int numHealthPacks) 
	{
		for( int x = 0; x < numHealthPacks; x++)
		{
			
			backpack.addHealthPack( new HealthPack(3) );
		}
		
	}
	
	public void useHealthPack()
	{
		int gainHP = 3;
		
		if(backpack.getNumPacks() > 0)
		{
			setHealthPoints(getHealthPoints()+gainHP);
			backpack.useHealthPack();
			System.out.println(getName()+" healed "+gainHP+" pts!");
		}
		else
		{
			System.out.println("No health packs left!");
		}
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.defaultWriteObject();
		
		out.writeObject(getHealthPoints());
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		in.defaultReadObject();
		
		setHealthPoints((Integer)in.readObject());
	}
}
