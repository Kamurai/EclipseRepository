//Kemerait, Christopher
//CSIS 2302
//Pig Latin Translator GUI Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;




public class PigLatinPanel extends JPanel
{
	//Establish variables
	String sentence, result;
	
	/**************************************************
	All instance fields should be private and these should
	not be instance fields.
	***************************************************/

	//Establish Objects	
	private JButton Translate = new JButton ("Translate to Pig Latin");
	private JTextField Input = new JTextField (10);
	private JLabel display = new JLabel ("------");
	
				
	public PigLatinPanel()
	
	/****************************************************
	Your constructor is private so it can be used in the
	driver.
	****************************************************/
	
	{
		//Set ActionListeners
		Translate.addActionListener (new Translate());
		
		//Add objects
		add (Input);
		add (Translate);
		add (display);

		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (175, 100));
		
   }
	
private class Translate implements ActionListener
  {
  public void actionPerformed (ActionEvent event)
  {

	//change information in text field to string for translation
		sentence = Input.getText();
	//implement translation
		result = PigLatinTranslator.translate ( sentence );
	//Output Results
		display.setText( result );
	
			
  	}
	
	}




}
