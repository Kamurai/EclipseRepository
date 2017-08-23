package usanIDE.DeComm;

/**
 *
 * @author Chris Kemerait
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Highlighter;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import usanIDE.MainController;
import usanIDE.Underliner;

import java.awt.GraphicsEnvironment;

public class MainWindow7 extends JFrame 
{
	private boolean ColorFlag = false;
	
	private JButton goButton;
	
	private JButton boldTestButton;
	private JButton italicTestButton;
	private JButton ColorTestButton;
	
	
	private JButton wButton;
	private JButton eButton;
	
	JTextPane mainBox;
	JTextPane outLabel;

	JFileChooser fChooser = new JFileChooser();

	MainController controller;
	
	public Highlighter highlighter = new Hmarker(null);
	public Underliner painter = new Underliner(Color.red);

	/**
	 * 
	 */
	public MainWindow7() 
	{
		controller = new MainController();
				
		JPanel panel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		
		int frameWidth = 1900;
		int frameHeight = 1000;
		
		int westPanelWidth = 100;
		int centerPanelWidth = 1600;
		int eastPanelWidth = 50;
		
		int westPanelHeight = 1000;
		int centerPanelHeight = 1000;
		int eastPanelHeight = 1000;
		
		int northScrollHeight = 825;
		int midPanelHeight = 40;
		int southScrollHeight = 100;
						
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		mainBox = new JTextPane();//"This is where the input goes.", 50, 30);
		mainBox.setText("This is where the input goes.");
		mainBox.setHighlighter(new Colorizer());
		
		
				
		mainBox.setEditable(true);
		//mainBox.setWrapStyleWord(true);
		//mainBox.setSize(100,800);
		
		JScrollPane northScroll = new JScrollPane(mainBox);
				
		
		goButton = new JButton("Check text");
		boldTestButton = new JButton("Bold Selection Test");
		italicTestButton = new JButton("Italic Selection Test");
		ColorTestButton = new JButton("Color Selection Test");
		
		
		mainBox.getDocument().addDocumentListener(new DeltaListener()); //SigmaListener());
				
		goButton.addActionListener(new ButtonListener());
		
		boldTestButton.addActionListener(new BoldListener());
		italicTestButton.addActionListener(new ItalicListener());
		ColorTestButton.addActionListener(new ColorListener());
		
		JPanel midPanel = new JPanel();
		midPanel.add(goButton);
		midPanel.add(boldTestButton);
		midPanel.add(italicTestButton);
		midPanel.add(ColorTestButton);
		
		wButton = new JButton("Load File.");
		eButton = new JButton("East Panel.");
				
		wButton.addActionListener(new TauListener());
		
		westPanel.add(wButton);
				
		outLabel = new JTextPane();//"This is where the output goes.", 5, 30);
		outLabel.setText("This is where the output goes.");
		
		outLabel.setEditable(false);
		
		JScrollPane southScroll = new JScrollPane(outLabel);
				
		centerPanel.add(northScroll);
		centerPanel.add(midPanel);
		centerPanel.add(southScroll);
		
		mainBox.setMinimumSize(new Dimension(centerPanelWidth, 10));
		mainBox.setPreferredSize(new Dimension(centerPanelWidth, northScrollHeight));
		mainBox.setMaximumSize(new Dimension(centerPanelWidth, northScrollHeight));
		
		northScroll.setMinimumSize(new Dimension(centerPanelWidth, 10));
		northScroll.setPreferredSize(new Dimension(centerPanelWidth, northScrollHeight));
		northScroll.setMaximumSize(new Dimension(centerPanelWidth, northScrollHeight));
		
		midPanel.setMinimumSize(new Dimension(centerPanelWidth, midPanelHeight));
		midPanel.setPreferredSize(new Dimension(centerPanelWidth, midPanelHeight));
		midPanel.setMaximumSize(new Dimension(centerPanelWidth, midPanelHeight));
		
		southScroll.setMinimumSize(new Dimension(centerPanelWidth, 10));
		southScroll.setPreferredSize(new Dimension(centerPanelWidth, southScrollHeight));
		southScroll.setMaximumSize(new Dimension(centerPanelWidth, southScrollHeight));
		
		centerPanel.setMinimumSize(new Dimension(centerPanelWidth, centerPanelHeight));
		centerPanel.setPreferredSize(new Dimension(centerPanelWidth, centerPanelHeight));
		centerPanel.setMaximumSize(new Dimension(centerPanelWidth, centerPanelHeight));
			
		
		westPanel.setMinimumSize(new Dimension(westPanelWidth, westPanelHeight));
		westPanel.setPreferredSize(new Dimension(westPanelWidth, westPanelHeight));
		westPanel.setMaximumSize(new Dimension(westPanelWidth, westPanelHeight));
		/*westPanel.setAlignmentY(TOP_ALIGNMENT);
		*/
		
		eastPanel.setMinimumSize(new Dimension(eastPanelWidth, eastPanelHeight));
		eastPanel.setPreferredSize(new Dimension(eastPanelWidth, eastPanelHeight));
		eastPanel.setMaximumSize(new Dimension(eastPanelWidth, eastPanelHeight));
		
		panel.add(westPanel);
		panel.add(centerPanel);
		panel.add(eastPanel);
		
		
		add(panel);
		setSize(frameWidth, frameHeight);
		setVisible(true);
		
		
		mainBox.grabFocus();
		//Begin processing document
		//processDoc(mainBox,0);
		//controller.seekToColor(mainBox,outLabel); //pivot!!!
		controller.setThreadTarget(mainBox, outLabel);
		controller.startThreadTarget();
		
		SwingUtilities.invokeLater
		(
			new Runnable()
			{
				public void run()
				{
					controller.colorByThread(mainBox, outLabel);
				}
			}
		);
	}

	private class DeltaListener implements DocumentListener
	{
		public void insertUpdate(DocumentEvent e)
		{
			//pivot
			int test1 = mainBox.getText().length();
			int test2 = mainBox.getDocument().getLength();
			
			if(!(ColorFlag))
			{
				ColorFlag = true;
				//controller.seekToColor(mainBox,outLabel); //pivot
				controller.colorByThread(mainBox, outLabel);
				ColorFlag = false;
			}
		}
		
		public void removeUpdate(DocumentEvent e)
		{
			if(!(ColorFlag))
			{
				ColorFlag = true;
				//tcontroller.seekToColor(mainBox,outLabel); //pivot
				controller.colorByThread(mainBox, outLabel);
				ColorFlag = false;
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	private class SigmaListener implements DocumentListener
	{
		public void insertUpdate(DocumentEvent e)
		{
 			int temp = 0;
			
			temp = mainBox.getCaretPosition() + e.getLength();
			
			if( temp > mainBox.getText().length())
			{
				temp = (mainBox.getText().length()-1);
			}
			
			//Begin processing document
			processDoc(mainBox,temp);
			
			
			
		}
		
		public void removeUpdate(DocumentEvent e)
		{
			
			int temp = 0;
			
			temp = mainBox.getCaretPosition();// - e.getLength();
			
			if( temp < 0)
			{
				temp = 0;
			}
			
			temp = (-1);
			//Begin processing document
			processDoc(mainBox,temp);
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	private class TauListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			ColorFlag = true; //prevent colorizing
			String alpha = "";
			
			//Handle open button action.
		    if (e.getSource() == wButton) 
		    {
		    	File Bulbasaur = new File(controller.GetLineFromFile(0));
				
				fChooser.setSelectedFile(Bulbasaur);
				
				
		        int returnVal = fChooser.showOpenDialog(fChooser);

		        if (returnVal == JFileChooser.APPROVE_OPTION) 
		        {
		        	alpha = fChooser.getSelectedFile().getPath();
		        	
		        	//Save file path to reference file
		        	controller.ClearReferenceFile();
					controller.SaveLineToFile(alpha);
					
		        	
		        	//This is where a real application would open the file.
					//Load file into mainBox
					mainBox.setText(controller.LoadFile(alpha));
					//mainBox.setStyledDocument(controller.LoadDoc(alpha); //pivot!!!
					
					//Sever issue loading file:  find proper tutorial on it
					
					
					//set mainBox to use uniform character spacing
					//mainBox.setColumns(100);
					
					Font font = new Font("Monaco", Font.PLAIN ,12);
					mainBox.setFont(font);
					mainBox.revalidate();
					mainBox.grabFocus();
		            //position cursor at the beginning the mainBox JTextArea
		            mainBox.setCaretPosition(0);
		            
		            //controller.Colorize(mainBox.getText());
		        } 
		   }
		    ColorFlag = false; //enable colorizing
		    controller.seekToColor(mainBox,outLabel);
		}

	}

	//pivot this option causes large delays when interacting with the loaded document
	//most likely this is using an excessive amount of memory.
	private class ButtonListener implements ActionListener  
	{

		public void actionPerformed(ActionEvent e) 
		{
			//next test: compile
			
		}

	}
	
	private class BoldListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			//controller.getBoldAction().actionPerformed(e);
		}

	}
	private class ItalicListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			//controller.getItalicAction().actionPerformed(e);
		}

	}
	private class ColorListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			ArrayList<Integer> targetList = new ArrayList<Integer>();
			
			targetList = controller.findIt(mainBox,"input");			
			ColorAndReturn(mainBox,targetList.get(0),targetList.get(1),Color.red,e);
		}

	}
	
	public void ColorAndReturn(JTextPane targetPane, int startRange, int startEnd, Color colorChoice, ActionEvent e)
	{
		int temp = 0;
		
		temp = mainBox.getCaretPosition();
		
		mainBox.grabFocus();
		
		//set the coordinates to Color
		mainBox.setSelectionStart(startRange);
		mainBox.setSelectionEnd(startEnd);
		controller.setColorPane(targetPane);
		controller.setColorAction(colorChoice);
		//controller.getColorAction().actionPerformed(e);

		mainBox.setCaretPosition(temp);
		
	}
	
	public void ColorAndGo(final JTextPane targetPane, final int startRange, final int startEnd, final int placement, Color colorChoice)
	{
		mainBox.grabFocus();
		
		//set the coordinates to Color
		mainBox.setSelectionStart(startRange);
		mainBox.setSelectionEnd(startEnd);
				
		controller.setColorPane(targetPane);
		controller.setColorAction(colorChoice);
		
		//leading problem: Document listener is not allowed to modify file
			//solution: wrap modification in an "invokeLater" method
		SwingUtilities.invokeLater
		(
			new Runnable()
			{
				public void run()
				{
					//controller.getColorAction().docUpdate();//e);
					
					//fix to black
					//set the coordinates to Color
					mainBox.setSelectionStart(startEnd);
					mainBox.setSelectionEnd(startEnd+1);
							
					controller.setColorPane(targetPane);
					controller.setColorAction(Color.BLACK);
					
					//if assigned to move cursor
					if(placement >= 0)
					{
						//return cursor to position
						mainBox.setCaretPosition(placement);
					}
					
				}
			}
		);
		
	}
	
	public void processDoc(JTextPane targetPane, int reposition)
	{
		ArrayList<ArrayList<String>> targetList = new ArrayList<ArrayList<String>>();
		String colorString = "";
		Color  colorColor = Color.black;
		
		//Call processor
		targetList = controller.processDoc(mainBox.getText());
		
		//if CaretPosition is outside the end of document
		//set CarePosition to end of document
		
		//if targetList is not empty
		if(targetList.size() > 0)
		{	
			//reposition++;  //pivot?
			
			for(int x = 0; x < targetList.size(); x++)
			{
				colorString = targetList.get(x).get(2);
				colorColor  = Color.decode(colorString);
				ColorAndGo(mainBox,Integer.parseInt(targetList.get(x).get(0)),Integer.parseInt(targetList.get(x).get(1)),reposition,colorColor);
			}
		}
		
		
	}
	
	
	
}