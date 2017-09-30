//Kemerait, Christopher
//CSIS 2302
//Phone Pad Button Assignment



import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.border.*;
//import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;


public class UserPanel extends JPanel
{
	//Establish Subsquent Panel
		//No More!

	//Establish Buttons
		JButton Numbers[] =
		{
			new JButton("1"),
			new JButton("2"),	
			new JButton("3"),
			new JButton("4"),	
			new JButton("5"),
			new JButton("6"),	
			new JButton("7"),
			new JButton("8"),	
			new JButton("9"),
			new JButton("*"),	
			new JButton("0"),
			new JButton("#"),	
		};
		

				
	public UserPanel()
	{
	
						
		//Set Panel
		setBackground (Color.black);
      //Set Layout
		setLayout ( new GridLayout(4, 3) );
		
		


		//Add Objects
		for(int counter=0; counter < 12; counter++)
		{
			add (Numbers[counter]);
			//Set ActionListeners
			Numbers[counter].addActionListener (new NumberListener() );
		}
	}
	
	private class NumberListener implements ActionListener
	{
	
		//Establish Variables
		String Output = "0";
		int Num = 0;

		public void actionPerformed (ActionEvent event)
  		{
					
		//take number and input it into variable
		for(int counter=0; counter < 12; counter++)
		{
			if ( event.getSource() == Numbers[counter] )
			{	
			
				if ( counter < 9)
				{
					Num = counter + 1;
					//Convert to String
					Output = Integer.toString( Num );
				}
				else if (counter == 9)
					Output = "*";
					else if (counter == 10)
						Output = "0";
						else if (counter == 11)
						Output = "#";
						
			
			
			};
		};
				
		//Ensure that string Adds to string in Display Label in the Result Panel
			//Output = Display.getText() + Output;
		//Move Output to the Display Label in the Result Panel
			//Display.setText( Output );
			//ResultPanel.SetResults();
			
		}
	
	}

}
