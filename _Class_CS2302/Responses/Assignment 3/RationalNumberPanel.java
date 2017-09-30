//Kemerait, Christopher
//CSIS 2302
//Rational Number / Comaparable interface Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
//import javax.swing.String;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;





public class RationalNumberPanel extends JPanel
{
	//Establish variables
	String result;
	RationalNumber One, Two;
	int Num1, Den1, Num2, Den2, y;
	float Rational1, Rational2, Rational3;
	
	/***********************************************
	All instance fields should be private.  These should
	be local variables instead of instance fields.
	***********************************************/

	//Establish Objects	
	private JButton Compare = new JButton ("Compare Rational Numbers");

	private JTextField InputNumerator1 = new JTextField (5);
	private JTextField InputDenomenator1 = new JTextField (5);
	private JTextField InputNumerator2 = new JTextField (5);
	private JTextField InputDenomenator2 = new JTextField (5);

	private JLabel Ratio1 = new JLabel ("/");
	private JLabel Ratio2 = new JLabel ("/");
	private JLabel Display = new JLabel ("------");
	
				
	public RationalNumberPanel()
	{
		//Set ActionListeners
		Compare.addActionListener (new Compare());
		
		//Add objects
		add (InputNumerator1);
		add (Ratio1);
		add (InputDenomenator1);

		add (InputNumerator2);
		add (Ratio2);
		add (InputDenomenator2);

		add (Compare);
		add (Display);

		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (300, 200));
		
   }
	
private class Compare implements ActionListener
  {
  public void actionPerformed (ActionEvent event)
  {

	//input numbers into variables
		Num1 = Integer.parseInt( InputNumerator1.getText() );
		Den1 = Integer.parseInt( InputDenomenator1.getText() );
		Num2 = Integer.parseInt( InputNumerator2.getText() );
		Den2 = Integer.parseInt( InputDenomenator2.getText() );
		
	//variables into rational numbers
		RationalNumber One =  new RationalNumber (Num1, Den1);
		RationalNumber Two =  new RationalNumber (Num2, Den2);

	//convert rational numbers to float
		Rational1 = One.floatconversion(Num1, Den1);
		Rational2 = Two.floatconversion(Num2, Den2);
		
	//compare numbers and define result
		
		y = One.compareTo ( Two );
		
		if ( y == 0 )
			result = "These rational numbers are the same.";
		else
			if ( y < 0 )
				result = "The first number is less than the second."; 
			else
				if ( y > 0 )
					result = "The first number is greater than the second."; 
				else
					result = "There seems to be an error.";

			
	// optional code
/*		
		if (Rational1 == Rational2)
			result = "These rational numbers are the same.";
		else
			result = "These rational numbers are not the same.";
*/		
			

	//Output Result
		Display.setText( result );
			
  	}
	
	}




}
