package com.fdmgroup.com;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.fdmgroup.serialization.game.Backpack;

public class CharacterBackpack extends Backpack implements Serializable
{
	/*
	int packs = 0;
	

	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.defaultWriteObject();
		
		out.writeObject(getNumPacks());
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		in.defaultReadObject();
		
		setNumPacks( Integer.parseInt((String) in.readObject()) );
	}

	private void setNumPacks(int numPacks) 
	{
		packs = numPacks;
		
	}
	*/
}
