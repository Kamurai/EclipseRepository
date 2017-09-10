package Muhr.src;
/*
 * Project Muhr : This is a program that will simulate something like an evolved Tamagotchi or a virtual pet or child.
 * Main class
 * @author Ashley Rayborn and Joel Cox
 * @version 19 January 2010
 */

import java.io.*;
import java.util.*;

public class Main 
{	
    public static void main(String[] args) 
    {
        ArrayList<String> food = findFood();
        
        for (String f : food)
        {
            System.out.println(f);
        }
    }

    public static ArrayList<String> findFood() 
    {
        File dsaf = new File(".");
        File[] fileList = dsaf.listFiles();
        ArrayList<String> foods = new ArrayList<String>();

        for (File f : fileList) 
        {
            if (f.getName().length() > 4) 
            {
                if (f.getName().substring(f.getName().length()-4).equals(".txt")) 
                {
                    foods.add(f.getName());
                }
            }
        }

        return foods;
    }
    
    public static void eatFood() throws FileNotFoundException
    {
    	ArrayList<String> food = findFood();
    	int hunger = 0;
    	boolean status = false;
    	
    	for (Health.hunger(hunger);;)
    	{
    		if (status == true)
    		{
    			for (String f : food)
    			{
    				Scanner input = new Scanner(new File(f));
    				ArrayList<String> contents = new ArrayList<String>();
    				
    				while (input.hasNext())
    				{
    					contents.add(input.next());
    				}
    				
    				hunger = hunger - contents.size();
    			}
    		}
    	}    	
    }
    
    /*
     * Make method that will increase value of tired.
     * Humans usually get tired after about 16 hours of being awake, assuming they've had 8 hours of sleep prior.
     * But since this will be a little person/animal/thing, should it be half or a fraction of that time?
     * Would it even need to sleep since it's a virtual thing and rest is a real-world function?
     * Humans try to personify way too many things...
     */
    }
