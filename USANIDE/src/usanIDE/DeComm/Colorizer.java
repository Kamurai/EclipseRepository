package usanIDE.DeComm;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;
import java.util.ArrayList;


public class Colorizer extends DefaultHighlighter 
{

	// Shared painter used for default highlighting
	protected static final Highlighter.HighlightPainter sharedPainter = new Underliner(null);
	// Painter used for this highlighter
	protected Highlighter.HighlightPainter painter;
	
	
	
	public Colorizer()
	{
		
	}
	
	public void ColorItAll2(JTextPane textpane, ArrayList<ArrayList<Integer>> input)
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
						c = Color.decode(input.get(x).get(2).toString());
						//painter = (c == null ? sharedPainter : new Underliner(c));
					}
					else if(input.get(x).get(2) != input.get(x-1).get(2))
					{
						//if there is a new color designate the new color
						c = Color.decode(input.get(x).get(2).toString());
						//painter = (c == null ? sharedPainter : new Underliner(c));
					}
					
					highlighter.addHighlight(input.get(x).get(0), input.get(x).get(1), painter);
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
