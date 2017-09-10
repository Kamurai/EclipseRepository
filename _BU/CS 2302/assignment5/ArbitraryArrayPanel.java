//Kemerait, Christopher
//CSIS 2302
//Arbitrary Array Assignment

package assignment5;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;




public class ArbitraryArrayPanel extends JPanel
{
	//Establish variables
	String result = " ";
	int number = 0;
	int tracker = 0;
	int limit = 10;
	
	/********************************************
	All instance fields should be private.
	*********************************************/
		
	// boolean marking (0) size of array, (1) 2nd to last entry of array, (2) last entry
	boolean flag[] = new boolean[3];
	
	/********************************************
	You are making this assignment MUCH MORE complicated
	than it needs to be.
	************************************************/

	// array for numbers entered as elements
	//int arbitary[] = new int[number];
	// array to mirror elements as counters
	//int counter[] = new int[number];
	
	//Establish arrays
	//Define arrays
		int arbitrary[] = new int[limit];
		int counter[] = new int[51];


	
	//Establish Subsequent Panels
	
	private JPanel NorthPanel = new JPanel();
	private JPanel CenterPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();	
	
	//Establish Objects	
	private JButton Process = new JButton ("Enter");
	private JTextField Input = new JTextField(5);
	private JTextArea Display = new JTextArea ("Enter the first number, 0-50");
	
	
	
				
	public ArbitraryArrayPanel()
	{
		//Set booleans
		for(int number=0; number < 3; number++)
			flag[number] = false;
			number = 0;
			
		//Set Borderlayout
			setLayout ( new BorderLayout() );
			
		//Set Subsequent Panels
			add (NorthPanel, BorderLayout.NORTH);
			add (CenterPanel, BorderLayout.CENTER);
			add (SouthPanel, BorderLayout.SOUTH);
			
		//Set ActionListeners
		Process.addActionListener ( new Worker() );
		
		//Add objects
		NorthPanel.add (Input);
		CenterPanel.add (Process);
		SouthPanel.add (Display);
		
		//Set Text Area
		Display.setBackground (Color.white);

		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (175, 440));
		
   }
	
private class Worker implements ActionListener
  {
  		  
  public void actionPerformed (ActionEvent event)
  {
  		//Get Input
  		result = Input.getText();
		number = Integer.parseInt( result );
		
		/*********************************************
		All you have to do here is increment the
		counter that is at index number.
		*********************************************/
										
				
			//process has been completed one array, restart
  		if( flag[0] == true && flag[1] == true && flag[2] == true )
		{
			for(number=0; number < 3; number++)
				flag[number] = false;

			for(number=0; number < arbitrary.length; number++)
				arbitrary[number] = 0;

			for(number=0; number < counter.length; number++)
				counter[number] = 0;
			
			tracker = 0;
			number = 0;
			result = "";
			
			Display.setText( "Enter the first number, 0 - 50");
			Process.setText( "Enter");
		
		}
		else
		{
		flag[0] = true;
			//if arrray is established then trip zeroth flag
				if ( flag[0] == false )
				{	
					
					
					
					//Trip Button Text
					Display.setText("Enter the first number, 0 - 50");
					//Display.setText( Integer.toString( tracker ) );
				
					
				}//if array is established then enter array elements
				else			
				{
				
				//if number is 0 - 50 enter array element
					if ( number > -1 && number < 51 )
					{
					
					
						//Enter element of the array
						arbitrary[tracker] = number;
						
						//Change counter
						for(int z = 0; z < counter.length; z++)
						{
							if( z == number)
								counter[z]++;							
						};
						
						//increment tracker
						tracker++;

							
						//if second to last element, then trip first flag
						if( tracker >= arbitrary.length - 1 )
							flag[1] = true;
			
						//if last element, then trip second flag
						if( tracker >= arbitrary.length - 0 )
							flag[2] = true;
		
												
						
				
						//Trip Button Text
						
						//if last element must be entered
						if( flag[2] == true )	
						{
							result = "Elements \t Occurences\n\n";
							
							//Display.setText( "Final Result" );
							for(int x = 0; x < arbitrary.length; x++)
							{
								//puts each element of arbitrary into result
								result += arbitrary[x] + "\t";
								
								//puts relative counter into result
								
								//go through and check number against the counters
								for(int y = 0; y < counter.length; y++)
								{
									//if arbitrary element equals the counter then add to result
									if( arbitrary[x] == y )
										result += counter[y] + "\n\n";
										
										
								};
															
							};
							Display.setText( result );
							Process.setText( "Restart");

						}
						//if all elements have been entered, then display results
						else if( flag[1] == true )
						{
							Display.setText("Enter the last number, 0 - 50");
							//Display.setText( Integer.toString( arbitrary[tracker-1] ) );	
						}
						else
						{
							//Display.setText( Integer.toString( arbitrary[tracker-1] ) );
							Display.setText("Enter a number, 0 - 50");
						};


						
					}
					else
					{
						Display.setText("PLEASE, 0 - 50");
					};
						
				};
				
		};	
		
	
	
			
  	}
	
	}




}
