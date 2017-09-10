//Kemerait, Christopher
//CSIS 2302
//Assignment 10
//Descending order Sorting


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.lang.Object;
import java.util.Random;




public class SortingDriverPanel extends JPanel
{


	//Establish Objects	
	private JTextArea Display = new JTextArea ("");
	private String result = "";
	
	//Establish Array
	private String Kam[];


	public SortingDriverPanel()
	{
	
	//Define Array
	 String[] Kam =
	{
		new String("Ace"), new String("One"),
		new String("Two"), new String("Three"),
		new String("Four"), new String("Five"),
		new String("Six"), new String("Seven"),
		
	};
		
	//Sort Array with Selection Sort
	
		Sorting.selectionSort(Kam);			
					
	//Compound Sorted Array to Result
	
		for(int x = 0; x < Kam.length; x++)
			result += Kam[x] + "\n";
	
	//Display result
		Display.setText( result );
	
	//RE-define array
	Kam[0] = "Ace";
	Kam[1] = "One";
	Kam[2] = "Two";
	Kam[3] = "Three";
	Kam[4] = "Four";
	Kam[5] = "Five";
	Kam[6] = "Six";
	Kam[7] = "Seven";
	
	
	//Sort Array with Insertion Sort
		Sorting.insertionSort(Kam);
		
		
	//Compund Second sorted Array to Result
		result += "\n";
		
		for(int x = 0; x < Kam.length; x++)
			result += Kam[x] + "\n";

	//Display result
		Display.setText( result );
	

	
	
	//Add objects
	add (Display);
		
	//Set Text Area
	Display.setBackground (Color.white);


	//display output
	Display.setText( result );
		
	//Set Panel
	setBackground (Color.white);
   setPreferredSize (new Dimension (200, 300));
		
   }


}
