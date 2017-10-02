package tourney1000pts;

import java.util.ArrayList;
import java.util.Random;


public class bracketgenerator 
{
	public static void main(String[] args) 
	{
		Random generator = new Random();
		int num = 0;
		
		ArrayList<String> brackets = new ArrayList<String>();
		
		//1
		brackets.add("Kroot");
		//2
		brackets.add("Grey Knights");
		//3
		brackets.add("Necrons");
		//4
		brackets.add("Sisters of Battle");
		//5
		brackets.add("Tau");
		brackets.add("Wyches");
		brackets.add("Dark Eldar");
		brackets.add("Chaos Marines");
		brackets.add("Chaos Daemons");
		brackets.add("Imperial Guard");
		brackets.add("Space Marine Armor");
			brackets.add("Space Marine Infantry");
		brackets.add("Orks");
		brackets.add("Tyranids Winged");
		brackets.add("Tyranids Armored");
		brackets.add("Eldar");
		
		int limit = 16;
		
		for( int x = 0; x < 16; x++)
		{
			// randomly pick # from 0-15
			num = generator.nextInt(limit);
			limit--;
			
			System.out.println( "Slot " + (x+1) + " goes to " + brackets.get(num) );
			brackets.remove(brackets.get(num));
			
		}
	}	
}
