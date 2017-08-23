package usanIDE;

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
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import java.awt.GraphicsEnvironment;

import javax.swing.text.Highlighter;

import usanIDE.MainController;
import usanIDE.Underliner;

public class MainWindow9 extends JFrame 
{
	private boolean ColorFlag = false;
	private boolean loadingFlag = false;
	
	private JButton goButton;
	
	private JButton boldTestButton;
	private JButton italicTestButton;
	private JButton ColorTestButton;
	
	
	private JButton loadButton;
	private JButton saveButton;
	private JButton eButton;
	
	private JLabel LineLabel;
	private JLabel PositionLabel;
	
	JTextPane mainBox;
	JTextPane outLabel;
	
	JScrollPane mainScroll;
	JScrollPane lineScroll;

	JFileChooser fChooser = new JFileChooser();

	MainController controller;
	
	//public Highlighter highlighter = new Hmarker(null);
	public Underliner painter = new Underliner(Color.red);

	/**
	 * 
	 */
	public MainWindow9() 
	{
		controller = new MainController(mainBox, outLabel);
				
		JPanel panel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		
		int frameWidth = 1900;
		int frameHeight = 1000;
		
		int westPanelWidth = 100;
		int centerPanelWidth = 1600;
		int eastPanelWidth = 100;
		
		int westPanelHeight = 1000;
		int centerPanelHeight = 1000;
		int eastPanelHeight = 1000;
		
		int northScrollHeight = 825;
		int midPanelHeight = 40;
		int southScrollHeight = 100;
						
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		StyleContext sc = new StyleContext();
		DefaultStyledDocument doc = new DefaultStyledDocument(sc);
		mainBox = new JTextPane(doc);//"This is where the input goes.", 50, 30);
		mainBox.setText("/*23456*/90\nThis is where the input goes. [ASSIGN ");
		mainBox.setHighlighter(new Colorizer3());
		
		
				
		mainBox.setEditable(true);
		//mainBox.setWrapStyleWord(true);
		//mainBox.setSize(100,800);
		
		mainScroll = new JScrollPane(mainBox);
				
		
		goButton = new JButton("Test It");
		boldTestButton = new JButton("Bold Selection Test");
		italicTestButton = new JButton("Italic Selection Test");
		ColorTestButton = new JButton("Color Selection Test");
		
		
		mainBox.getDocument().addDocumentListener(new DeltaListener());
		mainBox.addCaretListener(new GammaListener());		
		
		goButton.addActionListener(new ButtonListener());
		
		boldTestButton.addActionListener(new BoldListener());
		italicTestButton.addActionListener(new ItalicListener());
		ColorTestButton.addActionListener(new ColorListener());
		
		JPanel midPanel = new JPanel();
		midPanel.add(goButton);
		midPanel.add(boldTestButton);
		midPanel.add(italicTestButton);
		midPanel.add(ColorTestButton);
		
		loadButton = new JButton("Load File.");
		saveButton = new JButton("Save File.");
		
		eButton = new JButton("East Panel.");
				
		loadButton.addActionListener(new TauListener());
		saveButton.addActionListener(new SigmaListener());
		
		westPanel.add(loadButton);
		westPanel.add(saveButton);
		
		LineLabel = new JLabel("Line:  " + "0");
		PositionLabel = new JLabel("Position:  " + "0");
		
		eastPanel.add(LineLabel);
		eastPanel.add(PositionLabel);
		
		
		outLabel = new JTextPane();//"This is where the output goes.", 5, 30);
		outLabel.setText("This is where the output goes.");
		
		outLabel.setEditable(false);
		
		JScrollPane southScroll = new JScrollPane(outLabel);
				
		centerPanel.add(mainScroll);
		centerPanel.add(midPanel);
		centerPanel.add(southScroll);
		
		mainBox.setMinimumSize(new Dimension(centerPanelWidth, 10));
		mainBox.setPreferredSize(new Dimension(centerPanelWidth, northScrollHeight));
		mainBox.setMaximumSize(new Dimension(centerPanelWidth, northScrollHeight));
		
		mainScroll.setMinimumSize(new Dimension(centerPanelWidth, 10));
		mainScroll.setPreferredSize(new Dimension(centerPanelWidth, northScrollHeight));
		mainScroll.setMaximumSize(new Dimension(centerPanelWidth, northScrollHeight));
		
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
		
		//setup threads
		controller.setupThreads(mainBox, mainScroll,outLabel);
		controller.setThreadTarget(mainBox, outLabel);
		controller.beginThreadTarget();
		
		SwingUtilities.invokeLater
		(
			new Runnable()
			{
				public void run()
				{
					controller.colorByThread(mainBox, outLabel,mainScroll);
				}
			}
		);
	}

	//Listner for caret changes
	private class GammaListener implements CaretListener
	{
		public void caretUpdate(CaretEvent caretEvent)
		{
			LineLabel.setText("Line:  " + getCurrentLine(mainBox.getText()));
            PositionLabel.setText("Position:  " + getCurrentPosition(mainBox.getText()));
         }
	}
	
	
	//Listener for document changes
	private class DeltaListener implements DocumentListener
	{
		public void insertUpdate(DocumentEvent e)
		{
			SwingUtilities.invokeLater
			(
				new Runnable()
				{
					public void run()
					{
						if(!loadingFlag)
						{
							//controller.colorByThread(mainBox, outLabel,mainScroll);
							controller.setRun(true);
						}
					}
				}
			);
		}
		
		public void removeUpdate(DocumentEvent e)
		{
			SwingUtilities.invokeLater
			(
				new Runnable()
				{
					public void run()
					{
						if(!loadingFlag)
						{
							//controller.colorByThread(mainBox, outLabel,mainScroll);
							controller.setRun(true);
						}
					}
				}
			);
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	//Listener for saving a file
	private class SigmaListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			//Handle save button action.
		    if (e.getSource() == saveButton) 
		    {
		    	//declare where to save file
		    	
		    	//write to file
		    	controller.SaveToFile(mainBox.getText());
		    }
		}

	}
	
	//Listener for opening a file
	private class TauListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			ColorFlag = true; //prevent colorizing
			String alpha = "";
			String delta = "";
			
			//Handle open button action.
		    if (e.getSource() == loadButton) 
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
					
					loadingFlag = true;
		        	//This is where a real application would open the file.
					
					//controller.stopThreadTarget();
					
					delta = controller.separateFilename(alpha);
					controller.setFilename(delta);
					
					//Load file into mainBox
					mainBox.setText(controller.LoadFile(alpha));
						
					controller.setRun(true);
					//controller.startThreadTarget();
					//controller.beginThreadTarget();
					
					//Severe issue loading file:  find proper tutorial on it
										
					//set mainBox to use uniform character spacing
					//mainBox.setColumns(100);
					
					Font font = new Font("Monaco", Font.PLAIN ,12);
					mainBox.setFont(font);
					mainBox.revalidate();
					mainBox.grabFocus();
		            //position cursor at the beginning the mainBox JTextArea
		            mainBox.setCaretPosition(0);
		            
		            LineLabel.setText("Line:  " + getCurrentLine(mainBox.getText()));
		            PositionLabel.setText("Position:  " + getCurrentPosition(mainBox.getText()));
		            
		            loadingFlag = false;
		            controller.colorByThread(mainBox, outLabel,mainScroll);
		            
		            //controller.Colorize(mainBox.getText());
		        } 
		   }
		    ColorFlag = false; //enable colorizing
		    //controller.seekToColor(mainBox,outLabel);
		    //controller.seekToColor2(mainBox,outLabel,mainScroll);
		}

	}

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
	
	public String getCurrentLine(String content)
	{
		String output = "-1";
		int line = 1;
		int tracker = 0;
		char testChar = '_';
		
		for(; tracker < mainBox.getCaretPosition(); tracker++)
		{
			testChar = content.charAt(tracker);
			
			if((content.charAt(tracker) == '\n'))
			{
				line++;
			}
				
		}
		
		output = Integer.toString(line);
		return output;
	}
	
	public String getCurrentPosition(String content)
	{
		String output = "-1";
		int line = 1;
		int lineIndex = 0;
		int tracker = 0;
		char testChar = '_';
		
		
		for(; tracker < mainBox.getCaretPosition(); tracker++)
		{
			testChar = content.charAt(tracker);
			
			if((content.charAt(tracker) == '\n'))
			{
				line++;
				lineIndex = tracker+1;
			}
		}
		
		
		int position = tracker - lineIndex;
		position++;
		output = Integer.toString(position);
		return output;
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
		controller.getColorAction().actionPerformed(e);

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
					controller.getColorAction().docUpdate();//e);
					
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
}