//Kemerait, Christopher
//CSIS 2302
//Increment / Decrement Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;


public class Incrementpanel extends JPanel
{
	//Establish variables
	int counter = 0;

	//Establish Objects	
	JButton Increment = new JButton ("Increase Counter");
	JButton Decrement = new JButton ("Decrease Counter");
	JLabel sign = new JLabel ("Counter =");
	JLabel display = new JLabel ("0");
	
				
	public Incrementpanel()
	{
		//Set ActionListeners
		Increment.addActionListener (new Incrementation());
		Decrement.addActionListener (new Decrementation());		

		//Add buttons
		add (Increment);
		add (Decrement);
		add (sign);
		add (display);

		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (150, 150));
		
   }
	
private class Incrementation implements ActionListener
  {
  public void actionPerformed (ActionEvent event)
  {

	//change variable to string for output
	counter++;
	
	//Output Results
	display.setText( Integer.toString( counter ) );
	
			
  	}
	
	}

private class Decrementation implements ActionListener
  {
  public void actionPerformed (ActionEvent event)
  {

	//change variable to string for output
	counter--;
				
	//translate integer
				
	//Output Results
	display.setText( Integer.toString( counter ) );
	
			
  	}
	
	}



}
