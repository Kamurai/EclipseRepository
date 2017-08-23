package colorize;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextPaneExample implements ActionListener 
{
	JTextPane textPane;
	Style[] styles;

	public static void main(String[] args) 
	{
		TextPaneExample example = new TextPaneExample();
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(example.getTextComponent());
		f.getContentPane().add(example.getButtonBox(), "Last");
		f.setSize(400,400);
		f.setLocation(200,200);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		int start = textPane.getSelectionStart();
		int end = textPane.getSelectionEnd();
		if(start != -1 && end != -1 && start != end) 
		{
			int index = Integer.parseInt(e.getActionCommand());
			StyledDocument doc = textPane.getStyledDocument();
			int length = end - start;
			doc.setCharacterAttributes(start, length, styles[index], false);
		}
	}

	private JScrollPane getTextComponent() 
	{
		System.setProperty("swing.aatext", "true");
		String text = "This component models paragraphs that are composed " +
		"of runs of character level attributes. Each paragraph may " +
		"have a logical style attached to it which contains the default " +
		"attributes to use if not overridden by attributes set on the " +
		"paragraph or character run. Components and images may be " +
		"embedded in the flow of text.";
		textPane = new JTextPane();
		StyledDocument doc = textPane.getStyledDocument();
		Style logicalStyle = doc.addStyle("base", null);
		StyleConstants.setFontFamily(logicalStyle, "Lucida Sans Unicode");
		StyleConstants.setFontSize(logicalStyle, 20);
		StyleConstants.setLineSpacing(logicalStyle, 0.125f);
		doc.setLogicalStyle(0, logicalStyle);
		try 
		{
			doc.insertString(0, text, logicalStyle);
		} 
		catch(BadLocationException e) 
		{
			System.out.println("BadLocation: " + e.getMessage());
		}
			return new JScrollPane(textPane);
	}

		private Box getButtonBox() 
		{
			Color[] colors = {Color.red, Color.green, Color.pink, Color.orange};
			createStyles(colors);
			Dimension d = new Dimension(75, 25);
			Box box = Box.createHorizontalBox();
			box.setBorder(BorderFactory.createTitledBorder("set " +
					"background for selected text"));
			box.add(Box.createHorizontalGlue());
			for(int j = 0; j < colors.length; j++) 
			{
				JButton button = new JButton();
				button.setActionCommand(String.valueOf(j));
				button.setPreferredSize(d);
				button.setMinimumSize(d);
				button.setMaximumSize(d);
				button.setBackground(colors[j]);
				button.addActionListener(this);
				box.add(button);
				box.add(Box.createHorizontalGlue());
			}
			return box;
		}
		
	private void createStyles(Color[] colors) 
	{
		styles = new Style[colors.length];
		StyledDocument doc = textPane.getStyledDocument();
		for(int j = 0; j < styles.length; j++) 
		{
			String name = "color " + j;
			styles[j] = doc.addStyle(name, null);
			StyleConstants.setBackground(styles[j], colors[j]);
		}
	}

	
}