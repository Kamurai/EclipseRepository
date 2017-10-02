//Kemerait, Christopher
//CSIS 2302
//Yearly Rainfall Class Assignment

package assignment7;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;





public class RainfallDriverPanel extends JPanel
{
	//Establish variables
	private String result;
	private int tracker;
	
	//Establish test class
	private YearlyRainfall level;
		
			
	//Establish Objects	
	private JTextArea Display;
	
	//Test generator
	private Random generator = new Random();
	
				
	public RainfallDriverPanel()
	{
		//Define variables
			result = "";
			tracker = 0;
		//Define test class
			level = new YearlyRainfall();
		//Define Objects
			Display = new JTextArea ("");
	
	
		//Assign rainfalls to months of year
		for(int x = 0; x < 12; x++)
			level.setMonthlyRainfall(x, generator.nextInt(12) );
	
	
		//Add objects
		add (Display);
		
		//Set Text Area
		Display.setBackground (Color.white);


		//Driver code
		//test each method
		
		//get method
		for(int x = 0; x < 12; x++)
			result += (x+1) + ")\t" + Double.toString( level.getMonthlyRainfall(x) ) + "\n";
		//level.getMonthlyRainfall(0);
		//result = Double.toString( level.getMonthlyRainfall(0) );
		
		//display output
		Display.setText( result );
		
		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (175, 220));
		
   }


}
