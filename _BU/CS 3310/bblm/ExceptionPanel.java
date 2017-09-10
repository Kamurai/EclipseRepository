//Kemerait, Christopher
//CSIS 2302
//Exception, Try and Catch Assignment

package bblm;

   import java.awt.*;
   import javax.swing.JFrame;
   import javax.swing.JTextArea;
   import javax.swing.*;
   import java.util.Random;
   import java.awt.event.*;
	import java.io.*;




    public class ExceptionPanel extends JPanel
   {
   //Establish variables
      private String sentence, result;
      private int cap = 5;
   
   //Establish Objects	
      private JButton Check = new JButton ("Check String Length");
      private JTextField Input = new JTextField (10);
      private JTextArea display = new JTextArea ("------");
   
   //Establish Exceptions
      StringTooLongException tosser = new StringTooLongException ("Too Many Characters in string input.");
   
   			
       public ExceptionPanel()
      {
      //Set ActionListeners
         Check.addActionListener (new Process());
      
      //Add objects
         add (Input);
         add (Check);
         add (display);
      
		
		
		
      //Set Panel
         setBackground (Color.white);
         setPreferredSize (new Dimension (300, 100));
      
      }
   
       private class Process implements ActionListener 
      {
          public void actionPerformed (ActionEvent event)
         {
			
         //establish and define variables
            result = Input.getText();
         
			//Error Handling "try"
			try
			{			
    	     //check String against "cap" and
     	       result = CheckString(result);
			}
			catch(StringTooLongException tosser)
			{
				result += " did not have the correct number of characters.";
				result += "\n\tPlease continue.";
				
				/**********************************
				What is continue?
				**********************************/
			}	
         
         //Output Results
            display.setText( result );
         
         
         }
      
      }
   
   
   
       public class StringTooLongException extends Exception
      {
          StringTooLongException( String message)
         {
            super (message);
         }
      }
   
       public String CheckString(String subject) throws StringTooLongException
      {
      //Establish and define variables
         int number = 0;
      
  		//if user enters DONE, end program
		if (subject.equals("DONE"))
			System.exit(0);
		
      //check length of string
      	number = subject.length();
		
      //balance number of characters versus the "cap"
         if( number > cap)
         	throw tosser;
         
            return subject += " has a correct number of characters.";
      }
   
   
   
   
   
   }