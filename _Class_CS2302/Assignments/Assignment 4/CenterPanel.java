//Kemerait, Christopher
//CSIS 2302
//Phone Pad Button Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.*;
//import java.util.Random;
import java.awt.event.*;
//import java.util.ArrayList;


public class CenterPanel extends JPanel
{
	//Establish Subsquent Panel
	JPanel ResultPanel = new JPanel();
	JPanel NumberPanel = new JPanel();
	JPanel ClearPanel = new JPanel();
	
	//Establish Label
	JLabel Display = new JLabel("0");
	
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
		
		JButton Clear = new JButton("Clear");
		
		Boolean Cherry = true;
		
	
				
	public CenterPanel()
	{
		//Set Panel
//		setBackground (Color.green);
      //Set Layout
		setLayout ( new BorderLayout() );
		//Border
		NumberPanel.setBorder (BorderFactory.createLineBorder (Color.black, 1));


		//Add Objects

		//Add Subsequent Panel
		add (NumberPanel, BorderLayout.CENTER);
		add (ResultPanel, BorderLayout.NORTH);
		add (ClearPanel, BorderLayout.EAST);
		
		//Modify UserPanel
		
		//Set Panel
		NumberPanel.setBackground (Color.black);
      //Set Layout
		NumberPanel.setLayout ( new GridLayout(4, 3) );

		//Add Objects to UserPanel
		
		for(int counter=0; counter < 12; counter++)
		{
			NumberPanel.add (Numbers[counter]);
			//Set ActionListeners
			Numbers[counter].addActionListener (new NumberListener() );
		}

		
		//Modify DisplayPanel
		
		//Set Panel
		ResultPanel.setBackground (Color.white);
      //Set Layout

		//Border
		ResultPanel.setBorder (BorderFactory.createLineBorder (Color.black, 3));

		//Add Objects

				
		//Add Label
		ResultPanel.add (Display);

		//Modify ClearPanel
		
		//Set Panel
		ClearPanel.setBackground (Color.black);
      //Set Layout
		ClearPanel.setLayout ( new GridLayout(1, 1) );
		//Add Objects
		
		//Add Button
		ClearPanel.add (Clear);
		
		//Add ActionListener
		Clear.addActionListener (new NumberListener() );
		
   }
	
	private class NumberListener implements ActionListener
	{
	
		//Establish Variables
		String Output = "";
		int Num = 0;

		public void actionPerformed (ActionEvent event)
  		{
								
		//if Cherry is still true, then do not display initial 0
			if (Cherry == true)
			{
				Display.setText("");
				Cherry = false;
			};
			
		//if Clear is pressed, then Reset Cherry and place Display at 0
			if ( event.getSource() == Clear )
			{
				Display.setText("0");
				Output = "";
				Cherry = true;
			};

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
			Output = Display.getText() + Output;
		//Move Output to the Display Label in the Result Panel
			Display.setText( Output );

			
		}
	
	}

	
}
