//Kemerait, Christopher
//CSIS 2302
//Coin Flip Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;


public class Flippanel extends JPanel
{
	//Establish variables
	Random generator = new Random(1);		
	int number = 0;
	String result = ("-----");
	
	Coin myCoin = new Coin();

	//Establish Objects	
	JButton Flip = new JButton ("Flip a coin!");
	JLabel display = new JLabel (result);
	
				
	public Flippanel()
	{
		//Set ActionListeners
		Flip.addActionListener (new Flipit());
		
				
		//Add buttons
		add (Flip);
		add (display);
		
		
		

		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (100, 75));
		
   }
	
private class Flipit implements ActionListener
  {
  public void actionPerformed (ActionEvent event)
  {

	//flip coin
	//get resulting side
	
	myCoin.flip();
	
	//display side of coin

	if (myCoin.isHeads())
		display.setText( myCoin.toString() );
	else
		display.setText( myCoin.toString() );
	
			
  	}
	
	}


}
