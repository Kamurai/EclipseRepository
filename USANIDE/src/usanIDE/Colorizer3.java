package usanIDE;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.StyleConstants;
import javax.swing.text.View;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Colorizer3 extends DefaultHighlighter 
{

	// Shared painter used for default highlighting
	protected static final Highlighter.HighlightPainter sharedPainter = new Underliner(null);
	// Painter used for this highlighter
	protected Highlighter.HighlightPainter painter;
	
	StyleContext masterStyleContext = new StyleContext();
	Style defaultStyle = masterStyleContext.getStyle(StyleContext.DEFAULT_STYLE);
	Style currentStyle = defaultStyle;
	
	ArrayList<Style> StyleList = new ArrayList<Style>();
	
	public Colorizer3()
	{
		StyleConstants.setForeground(defaultStyle, Color.black);
		
	}
	
	public Colorizer3(JTextPane textpane, ArrayList<ArrayList<String>> input)
	{
		StyleConstants.setForeground(defaultStyle, Color.black);
	}
	
	public Colorizer3(JTextPane textpane, ArrayList<ArrayList<String>> input, JScrollPane targetScroll)
	{
		StyleConstants.setForeground(defaultStyle, Color.black);
	}
	
	public Colorizer3(JTextPane textpane, JScrollPane targetScroll)
	{
		StyleConstants.setForeground(defaultStyle, Color.black);
	}
	
	public void HighlightItAll(JTextPane textpane, ArrayList<ArrayList<String>> input)
	{
		Highlighter highlighter = textpane.getHighlighter();
		Color c = new Color(0,0,0);
		painter = new Underliner(c);
		String tempColor = "0";

		highlighter.removeAllHighlights();
		
		if(input.size() > 0)
		{
			try 
			{
				for(int x = 0; x < input.size(); x++)
				{
					if( x == 0)
					{
						//designate original color to paint
						if(input.get(x).get(4).compareTo("1") == 0)
						{
							//red
							tempColor = "16711680";  //FF0000;
						}
						else if(input.get(x).get(4).compareTo("2") == 0)
						{
							//orange
							tempColor = "16744448"; //FF8000;
						}
						else if(input.get(x).get(4).compareTo("3") == 0)
						{
							//yellow
							tempColor = "16776960"; //FFFF00;
						}
						c = Color.decode(tempColor);
						
						painter = (c == null ? sharedPainter : new Underliner(c));
					}
					else if(input.get(x).get(2) != input.get(x-1).get(2))
					{
						//if there is a new color designate the new color
						
						c = Color.decode(input.get(x).get(2)); //pivot: change to yellow, orange, or red
						if(input.get(x).get(4).compareTo("1") == 0)
						{
							//red
							tempColor = "16711680";  //FF0000;
						}
						else if(input.get(x).get(4).compareTo("2") == 0)
						{
							//orange
							tempColor = "16744448"; //FF8000;
						}
						else if(input.get(x).get(4).compareTo("3") == 0)
						{
							//yellow
							tempColor = "16776960"; //FFFF00;
						}
						c = Color.decode(tempColor);
						
						painter = (c == null ? sharedPainter : new Underliner(c));
					}
					
					highlighter.addHighlight(Integer.parseInt(input.get(x).get(0)), Integer.parseInt(input.get(x).get(1)), painter);
				}
			}
			catch(BadLocationException e)
			{
				
			}
		}
	}
	
	//colors everything on edit
	public void ColorItAll5(JTextPane textpane, ArrayList<ArrayList<String>> input)
	{
		Color c = new Color(0,0,0);
		String ColorName = new String();
		
		StyleConstants.setForeground(defaultStyle, Color.black);
		
		int Start = 0;
		int Length = 0;
		
		if(input.size() > 0)
		{
			//from beginning, color black until first word
			if(Integer.parseInt(input.get(0).get(0)) > 0)
			{
				//color black  from the beginning of the document to 1 place before the first colored word 
				Start = 0;
				Length   = ((Integer.parseInt(input.get(0).get(0))-1)-Start);
				//apply default color
				if(Length > 0)
				{
					textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
				}
			}
			
				for(int x = 0; x < input.size(); x++)
				{
					//designate original color to paint
					if( x == 0)
					{
						c = Color.decode(input.get(x).get(2).toString());
						ColorName = input.get(x).get(3).toString();
						currentStyle = masterStyleContext.addStyle(ColorName, null);
						StyleConstants.setForeground(currentStyle, c);
					}
					//if there is a new color designate the new color
					else if(input.get(x).get(2).compareTo(input.get(x-1).get(2)) != 0)
						//else if(input.get(x).get(2) != input.get(x-1).get(2))
					{
						c = Color.decode(input.get(x).get(2).toString());
						ColorName = input.get(x).get(3).toString();
						currentStyle = masterStyleContext.addStyle(ColorName, null);
						StyleConstants.setForeground(currentStyle, c);
					}
					
					Start = Integer.parseInt(input.get(x).get(0));
					Length   = (Integer.parseInt(input.get(x).get(1))-Start);
					//apply color
					if(Length > 0)
					{
						textpane.getStyledDocument().setCharacterAttributes(Start, Length, currentStyle, false);
					}
					
					//if this is not the last word to be colored
					if( x < input.size()-1)
					{
						//if not at end of document
						if(Integer.parseInt(input.get(x).get(1)) < textpane.getStyledDocument().getLength()-1)
						{
							//color black from 1 place after colored word to 1 place before the next colored word 
							Start = Integer.parseInt(input.get(x).get(1));//+1;
							Length   = ((Integer.parseInt(input.get(x+1).get(0)))-Start);
							
							//apply color
							if(Length > 0)
							{
								textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
							}
						}
						//no other case
					}
					else //this is the last word to be colored
					{
						//if not at end of document
						if(Integer.parseInt(input.get(x).get(1)) < textpane.getStyledDocument().getLength()-1)
						{
							//color black from 1 place after colored word to the end of the document
							Start = Integer.parseInt(input.get(x).get(1))+1;
							Length   = ((textpane.getStyledDocument().getLength())-Start);
							
							//apply color
							if(Length > 0)
							{
								textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
							}
						}
					}
					
				}
				
		}
		else if(input.size() == 0)
		{
			//from beginning, color black until end
				//color black  from the beginning of the document to 1 place before the first colored word 
				Start = 0;
				Length   = (textpane.getStyledDocument().getLength());
				//apply default color
				if(Length > 0)
				{
					textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
				}
			
			
		}
	}
	
	//colors what is in the view on an edit
	public void ColorItAll4(JTextPane textpane, ArrayList<ArrayList<String>> input, JScrollPane scrollPane)
	{
		Color c = new Color(0,0,0);
		String ColorName = new String();
		
		StyleConstants.setForeground(defaultStyle, Color.black);
		
		int Start = 0;
		int Length = 0;
		
		int minView = textpane.getCaretPosition() - 5000;
		int maxView = textpane.getCaretPosition() + 5000;
		
		JViewport viewport = scrollPane.getViewport();
		Point startPoint = viewport.getViewPosition();
		Dimension size = viewport.getExtentSize();
		Point endPoint = new Point(startPoint.x + size.width, startPoint.y + size.height);
		
		int startView = textpane.viewToModel( startPoint );
		int endView = textpane.viewToModel( endPoint );
		
		minView = startView;
		maxView = endView;

		if(input.size() > 0)
		{
			//adjust view
			if(minView < 0)
			{
				minView = 0;
			}
			
			if(maxView > (textpane.getStyledDocument().getLength()-1))
			{
				maxView = (textpane.getStyledDocument().getLength()-1);
			}
			
			//reduce list to color
			for(int x = 0; x < input.size(); x++)
			{
				if((Integer.parseInt(input.get(x).get(0))) < minView)
				{
					input.remove(x);
					x--;
				}
				else if((Integer.parseInt(input.get(x).get(0))) > maxView)
				{
					input.remove(x);
					x--;
				}
			}
			
			
			//from beginning, color black until first word
			if(Integer.parseInt(input.get(0).get(0)) > 0)
			{
				//color black  from the beginning of the document to 1 place before the first colored word 
				Start = 0;
				Length   = ((Integer.parseInt(input.get(0).get(1))-1)-Start);
				//apply default color
				if(Length > 0)
				{
					textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
				}
			}
			
				for(int x = 0; x < input.size(); x++)
				{
					//designate original color to paint
					if( x == 0)
					{
						c = Color.decode(input.get(x).get(2).toString());
						ColorName = input.get(x).get(3).toString();
						currentStyle = masterStyleContext.addStyle(ColorName, null);
						StyleConstants.setForeground(currentStyle, c);
					}
					//if there is a new color designate the new color
					else if(input.get(x).get(2).compareTo(input.get(x-1).get(2)) != 0)
						//else if(input.get(x).get(2) != input.get(x-1).get(2))
					{
						c = Color.decode(input.get(x).get(2).toString());
						ColorName = input.get(x).get(3).toString();
						currentStyle = masterStyleContext.addStyle(ColorName, null);
						StyleConstants.setForeground(currentStyle, c);
					}
					
					Start = Integer.parseInt(input.get(x).get(0));
					Length   = (Integer.parseInt(input.get(x).get(1))-Start);
					//apply color
					if(Length > 0)
					{
						textpane.getStyledDocument().setCharacterAttributes(Start, Length, currentStyle, false);
					}
					
					//if this is not the last word to be colored
					if( x < input.size()-1)
					{
						//if not at end of document
						if(Integer.parseInt(input.get(x).get(1)) < textpane.getStyledDocument().getLength()-1)
						{
							//color black from 1 place after colored word to 1 place before the next colored word 
							Start = Integer.parseInt(input.get(x).get(1))+1;
							Length   = ((Integer.parseInt(input.get(x+1).get(0))-1)-Start);
							
							//apply color
							if(Length > 0)
							{
								textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
							}
						}
						//no other case
					}
					else //this is the last word to be colored
					{
						//if not at end of document
						if(Integer.parseInt(input.get(x).get(1)) < textpane.getStyledDocument().getLength()-1)
						{
							//color black from 1 place after colored word to the end of the document
							Start = Integer.parseInt(input.get(x).get(1))+1;
							Length   = ((textpane.getStyledDocument().getLength())-Start);
							
							//apply color
							if(Length > 0)
							{
								textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
							}
						}
					}
					
				}
				
		}
	}
	
	//colors everything in a range from the caret on edit	
	public void ColorItAll3(JTextPane textpane, ArrayList<ArrayList<String>> input)
	{
		Color c = new Color(0,0,0);
		String ColorName = new String();
		
		StyleConstants.setForeground(defaultStyle, Color.black);
		
		int Start = 0;
		int Length = 0;
		
		int minView = textpane.getCaretPosition() - 5000;
		int maxView = textpane.getCaretPosition() + 5000;
		
		

		if(input.size() > 0)
		{
			//adjust view
			if(minView < 0)
			{
				minView = 0;
			}
			
			if(maxView > (textpane.getStyledDocument().getLength()-1))
			{
				maxView = (textpane.getStyledDocument().getLength()-1);
			}
			
			//reduce list to color
			for(int x = 0; x < input.size(); x++)
			{
				if((Integer.parseInt(input.get(x).get(0))) < minView)
				{
					input.remove(x);
					x--;
				}
				else if((Integer.parseInt(input.get(x).get(0))) > maxView)
				{
					input.remove(x);
					x--;
				}
			}
			
			
			//from beginning, color black until first word
			if(Integer.parseInt(input.get(0).get(0)) > 0)
			{
				//color black  from the beginning of the document to 1 place before the first colored word 
				Start = 0;
				Length   = ((Integer.parseInt(input.get(0).get(1))-1)-Start);
				//apply default color
				if(Length > 0)
				{
					textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
				}
			}
			
				for(int x = 0; x < input.size(); x++)
				{
					//designate original color to paint
					if( x == 0)
					{
						c = Color.decode(input.get(x).get(2).toString());
						ColorName = input.get(x).get(3).toString();
						currentStyle = masterStyleContext.addStyle(ColorName, null);
						StyleConstants.setForeground(currentStyle, c);
					}
					//if there is a new color designate the new color
					else if(input.get(x).get(2).compareTo(input.get(x-1).get(2)) != 0)
						//else if(input.get(x).get(2) != input.get(x-1).get(2))
					{
						c = Color.decode(input.get(x).get(2).toString());
						ColorName = input.get(x).get(3).toString();
						currentStyle = masterStyleContext.addStyle(ColorName, null);
						StyleConstants.setForeground(currentStyle, c);
					}
					
					Start = Integer.parseInt(input.get(x).get(0));
					Length   = (Integer.parseInt(input.get(x).get(1))-Start);
					//apply color
					if(Length > 0)
					{
						textpane.getStyledDocument().setCharacterAttributes(Start, Length, currentStyle, false);
					}
					
					//if this is not the last word to be colored
					if( x < input.size()-1)
					{
						//if not at end of document
						if(Integer.parseInt(input.get(x).get(1)) < textpane.getStyledDocument().getLength()-1)
						{
							//color black from 1 place after colored word to 1 place before the next colored word 
							Start = Integer.parseInt(input.get(x).get(1))+1;
							Length   = ((Integer.parseInt(input.get(x+1).get(0))-1)-Start);
							
							//apply color
							if(Length > 0)
							{
								textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
							}
						}
						//no other case
					}
					else //this is the last word to be colored
					{
						//if not at end of document
						if(Integer.parseInt(input.get(x).get(1)) < textpane.getStyledDocument().getLength()-1)
						{
							//color black from 1 place after colored word to the end of the document
							Start = Integer.parseInt(input.get(x).get(1))+1;
							Length   = ((textpane.getStyledDocument().getLength())-Start);
							
							//apply color
							if(Length > 0)
							{
								textpane.getStyledDocument().setCharacterAttributes(Start, Length, defaultStyle, false);
							}
						}
					}
					
				}
				
		}
	}
	
	public void ColorItAll2(JTextPane textpane, ArrayList<ArrayList<String>> input)
	{
		Highlighter highlighter = textpane.getHighlighter();
		Color c = new Color(0,0,0);
		painter = new Underliner(c);

		if(input.size() > 0)
		{
			try 
			{
				for(int x = 0; x < input.size(); x++)
				{
					if( x == 0)
					{
						//designate original color to paint
						c = Color.decode(input.get(x).get(2));
						painter = (c == null ? sharedPainter : new Underliner(c));
					}
					else if(input.get(x).get(2) != input.get(x-1).get(2))
					{
						//if there is a new color designate the new color
						c = Color.decode(input.get(x).get(2));
						painter = (c == null ? sharedPainter : new Underliner(c));
					}
					
					highlighter.addHighlight(Integer.parseInt(input.get(x).get(0)), Integer.parseInt(input.get(x).get(1)), painter);
				}
			}
			catch(BadLocationException e)
			{
				
			}
		}
	}
	
	public void ColorItAll(JTextPane textpane, ArrayList<ArrayList<Integer>> input)
	{
		Highlighter highlighter = textpane.getHighlighter();
		Color c = new Color(0,0,0);

		if(input.size() > 0)
		{
			try 
			{
				for(int x = 0; x < input.size(); x++)
				{
					if( x == 0)
					{
						//designate original color to paint
						c = Color.decode(input.get(x).get(2).toString());
						painter = (c == null ? sharedPainter : new Underliner(c));
					}
					else if(input.get(x).get(2) != input.get(x-1).get(2))
					{
						//if there is a new color designate the new color
						c = Color.decode(input.get(x).get(2).toString());
						painter = (c == null ? sharedPainter : new Underliner(c));
					}
					
					highlighter.addHighlight(input.get(x).get(0), input.get(x).get(1), painter);
				}
			}
			catch(BadLocationException e)
			{
				
			}
		}
	}
	
	public void ColorIt(JTextPane textpane, ArrayList<ArrayList<Integer>> input, Color c)
	{
		painter = (c == null ? sharedPainter : new Underliner(c));
		Highlighter highlighter = textpane.getHighlighter();

		try 
		{
			for(int x = 0; x < input.size(); x++)
			{
				highlighter.addHighlight(input.get(x).get(0), input.get(x).get(1), painter);
			}
		}
		catch(BadLocationException e)
		{
			
		}
		
	}
	
	
	

	// Convenience method to add a highlight with
	// the default painter.
	public Object addHighlight(int p0, int p1) throws BadLocationException 
	{
		return addHighlight(p0, p1, painter);
	}

	public void setDrawsLayeredHighlights(boolean newValue) 
	{
		// Illegal if false - we only support layered highlights
		if (newValue == false) 
		{
			throw new IllegalArgumentException("UnderlineHighlighter only draws layered highlights");
		}
		super.setDrawsLayeredHighlights(true);
	}

	
	
	
	// Painter for underlined highlights
	public static class Underliner extends LayeredHighlighter.LayerPainter 
	{
		// Shared painter used for default highlighting
		protected static final Highlighter.HighlightPainter sharedPainter = new Underliner(null);
		// Painter used for this highlighter
		protected Highlighter.HighlightPainter painter;
		protected Color color; // The color for the underline
	
		public Underliner(Color c) 
		{
			color = c;
		}

		public void paint(Graphics g, int offs0, int offs1, Shape bounds,
				JTextComponent c) {
			// Do nothing: this method will never be called
		}

		public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds,
				JTextComponent c, View view) {
			g.setColor(color == null ? c.getSelectionColor() : color);

			Rectangle alloc = null;
			if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset()) {
				if (bounds instanceof Rectangle) {
					alloc = (Rectangle) bounds;
				} else {
					alloc = bounds.getBounds();
				}
			} else {
				try {
					Shape shape = view.modelToView(offs0,
							Position.Bias.Forward, offs1,
							Position.Bias.Backward, bounds);
					alloc = (shape instanceof Rectangle) ? (Rectangle) shape
							: shape.getBounds();
				} catch (BadLocationException e) {
					return null;
				}
			}

			FontMetrics fm = c.getFontMetrics(c.getFont());
			int baseline = alloc.y + alloc.height - fm.getDescent() + 1;
			g.drawLine(alloc.x, baseline, alloc.x + alloc.width, baseline);
			g.drawLine(alloc.x, baseline + 1, alloc.x + alloc.width,
					baseline + 1);

			return alloc;
		}

	}
}
