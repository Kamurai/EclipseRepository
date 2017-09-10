//Kemerait, Christopher
//CSIS 2302
//Search Assignment



   import java.awt.*;
   import javax.swing.JFrame;
   import javax.swing.JTextArea;
   import javax.swing.*;
   import java.util.Random;
   import java.awt.event.*;
	import java.io.*;




    public class SearchPanel extends JPanel
   {
   //Establish variables
      private String result;
      public String phonetic[];
		private int num = 0;
		
   //Establish Subsequent Panels
		private JPanel NorthPanel = new JPanel();
		private JPanel CenterPanel = new JPanel();
		private JPanel SouthPanel = new JPanel();	

   //Establish Objects	
      private JButton Check = new JButton ("Search for Input");
      private JTextField Input = new JTextField (10);
      private JTextArea Display = new JTextArea ("------");
   
   
   			
       public SearchPanel()
      {
		
		//Define Array
			String phonetic[] = 
			{
				"Zulu", "Tango", "November", "Lima", "Juliet",
				"Hotel", "Foxtrot", "Delta", "Bravo", "Alpha"
			
		//	"Alpha", "Bravo", "Charlie", "Delta", "Echo",
		//	"Victor", "Whiskey", "Xray", "Yankee", "Zulu"
			};
				
		//Set Borderlayout
			setLayout ( new BorderLayout() );
		
		//Set Subsequent Panels
			add (NorthPanel, BorderLayout.NORTH);
			add (CenterPanel, BorderLayout.CENTER);
			add (SouthPanel, BorderLayout.SOUTH);
					
      //Set ActionListeners
         Check.addActionListener (new Process());
      
      //Add objects
      	NorthPanel.add (Input);
			CenterPanel.add (Check);
			SouthPanel.add (Display);
		
		//Set Text Area
			Display.setBackground (Color.white);

      //Set Panel
         setBackground (Color.white);
         setPreferredSize (new Dimension (300, 250));
      
      }
   
       private class Process implements ActionListener 
      {
          public void actionPerformed (ActionEvent event) 
         {
			
         //establish and define variables
            result = Input.getText();
						
						
				Sorting.selectionSort(phonetic);
			//use binary search algorithm
     	      //Searching.binarySearch( phonetic, result);
			
			
			
         //Output Results
            Display.setText( result );
         }
      
      }
   
	 
   
   
          
   }