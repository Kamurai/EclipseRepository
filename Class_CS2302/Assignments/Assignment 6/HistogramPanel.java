//Kemerait, Christopher
//CSIS 2302
//Histogram Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;




public class HistogramPanel extends JPanel
{
	//Establish variables
	private String result = " ";
	private int number = 0,	tracker = 0, limit = 10;
	
			
	// boolean marking (0) size of array, (1) 2nd to last entry of array, (2) last entry
	private boolean flag[] = new boolean[3];
	
	
		
	//Establish and Define arrays
	private int arbitrary[] = new int[limit], counter[] = new int[101];


	
	//Establish Subsequent Panels
	
	private JPanel NorthPanel = new JPanel();
	private JPanel CenterPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();	
	
	//Establish Objects	
	private JButton Process = new JButton ("Enter");
	private JTextField Input = new JTextField(5);
	private JTextArea Display = new JTextArea ("Enter the first number, 0-100");
	
	
	
				
	public HistogramPanel()
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
      setPreferredSize (new Dimension (200, 270));
		
   }
	
private class Worker implements ActionListener
  {
  		  
  public void actionPerformed (ActionEvent event)
  {
  		//Get Input
  		result = Input.getText();
		number = Integer.parseInt( result );
		
						
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
			
			Display.setText( "Enter the first number, 1 - 100");
			Process.setText( "Enter");
		
		}
		else
		{
		flag[0] = true;
			//if arrray is established then trip zeroth flag
				if ( flag[0] == false )
				{	
					//Trip Button Text
					Display.setText("Enter the first number, 1 - 100");
										
				}
				//if array is established then enter array elements
				else			
				{
					//if number is 0 - 50 enter array element
					if ( number > 0 && number < 101 )
					{
						//Enter element of the array
						arbitrary[tracker] = number;
						
						//Change counter
							counter[ (arbitrary[tracker]) ]++;							
												
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
							result = "Ranges\t| Occurences\n";
							
							//Display the final tabled result
							
							//Counter Array is divided into 10 ranges
							for(int x = 0; x < 10; x++)
							{
								//puts each number range into the table
								result += (x*10 + 1) + " - " + (x*10 + 10) + "\t| ";
								
								//Each range equals 1/10th of counter array
								//puts relative counter into result BY ASTERISK
								for(int y = 1; y < 11; y++)
								{
									//goto counter and display astericks that many times
									for(int z = 0; z < (counter[ x*10 + y ]); z++) 
										result += "*";									
								};
								result += "\n";
																						
							};
							Display.setText( result );
							Process.setText( "Restart");

						}
						//if all elements have been entered, then display results
						else if( flag[1] == true )
						{
							Display.setText("Enter the last number, 1 - 100");
						}
						else
						{
							Display.setText("Enter a number, 1 - 100");
						};


						
					}
					else
					{
						Display.setText("PLEASE, 1 - 100");
					};
						
				};
				
		};	
		
	
	
			
  	}
	
	}




}
