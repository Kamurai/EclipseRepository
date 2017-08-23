package usanIDE.DeComm;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;

import usanIDE.Underliner;


public class HighLighter extends DefaultHighlighter
{
	Color color;
		
	// Shared painter used for default highlighting
	protected static final Highlighter.HighlightPainter sharedPainter = new Underliner(null);

	// Painter used for this highlighter
	protected Highlighter.HighlightPainter painter;
	
	
	HighLighter()
	{
		color = Color.red;
	}
	
	HighLighter(String input)
	{
	/*
		if( input.equals("black") || input.equals("BLACK"))
		{
			color = Color.black;
		}
		else if( input.equals("blue") || input.equals("BLUE"))
		{
			color = Color.blue;
		}
		else if( input.equals("cyan") || input.equals("CYAN"))
		{
			color = Color.cyan;
		}
		else if( input.equals("darkGray") || input.equals("DARK_GRAY"))
		{
			color = Color.darkGray;
		}
		else if( input.equals("green") || input.equals("GREEN"))
		{
			color = Color.green;
		}
		else if( input.equals("lightGray") || input.equals("LIGHT_GRAY"))
		{
			color = Color.lightGray;
		}
		else if( input.equals("magenta") || input.equals("MAGENTA"))
		{
			color = Color.magenta;
		}
		else if( input.equals("orange") || input.equals("ORANGE"))
		{
			color = Color.orange;
		}
		else if( input.equals("pink") || input.equals("PINK"))
		{
			color = Color.pink;
		}
		else if( input.equals("red") || input.equals("RED"))
		{
			color = Color.red;
		}
		else if( input.equals("white") || input.equals("WHITE"))
		{
			color = Color.white;
		}
		else if( input.equals("yellow") || input.equals("YELLOW"))
		{
			color = Color.yellow;
		}
		else
		{
		*/
		color = Color.red;
		//}
		
	}
	
	// Convenience method to add a highlight with
	// the default painter.
	public Object addHighlight(int p0, int p1) throws BadLocationException 
	{
		Object result = false;
		
		try
		{
			result = addHighlight(p0, p1, sharedPainter);
		}
		catch(BadLocationException bad)
		{
			//Stub
		}
		
		return result;
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
	
	
	
	
}

/*
class Hmarker extends DefaultHighlighter 
{
	// Shared painter used for default highlighting
	protected static final Highlighter.HighlightPainter sharedPainter = new Underliner(null);
	// Painter used for this highlighter
	protected Highlighter.HighlightPainter painter;
	
	public Hmarker(Color c) 
	{
		painter = (c == null ? sharedPainter : new Underliner(c));
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
*/
/*
// A simple class that searches for a word in
	// a document and highlights occurrences of that word

	class WordSearcher 
	{
		public WordSearcher(JTextComponent comp) 
		{
			this.comp = comp;
			this.painter = new UnderlineHighlighter.UnderlineHighlightPainter(Color.red);
		}

		// Search for a word and return the offset of the
		// first occurrence. Highlights are added for all
		// occurrences found.
		public int search(String word) 
		{
			int firstOffset = -1;
			Highlighter highlighter = comp.getHighlighter();

			// Remove any existing highlights for last word
			Highlighter.Highlight[] highlights = highlighter.getHighlights();
			for (int i = 0; i < highlights.length; i++) 
			{
				Highlighter.Highlight h = highlights[i];
				if (h.getPainter() instanceof UnderlineHighlighter.UnderlineHighlightPainter) 
				{
					highlighter.removeHighlight(h);
				}
			}

			if (word == null || word.equals("")) {
				return -1;
			}

			// Look for the word we are given - insensitive search
			String content = null;
			try {
				Document d = comp.getDocument();
				content = d.getText(0, d.getLength()).toLowerCase();
			} catch (BadLocationException e) {
				// Cannot happen
				return -1;
			}

			word = word.toLowerCase();
			int lastIndex = 0;
			int wordSize = word.length();

			while ((lastIndex = content.indexOf(word, lastIndex)) != -1) {
				int endIndex = lastIndex + wordSize;
				try {
					highlighter.addHighlight(lastIndex, endIndex, painter);
				} catch (BadLocationException e) {
					// Nothing to do
				}
				if (firstOffset == -1) {
					firstOffset = lastIndex;
				}
				lastIndex = endIndex;
			}

			return firstOffset;
		}

		protected JTextComponent comp;

		protected Highlighter.HighlightPainter painter;
	}

	public static class UnderlineHighlighter extends DefaultHighlighter 
	{
		public UnderlineHighlighter(Color c) 
		{
			painter = (c == null ? sharedPainter : new UnderlineHighlightPainter(c));
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
		public static class UnderlineHighlightPainter extends LayeredHighlighter.LayerPainter 
		{
			public UnderlineHighlightPainter(Color c) 
			{
				color = c;
			}

			public void paint(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c) 
			{
				// Do nothing: this method will never be called
			}

			public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds,JTextComponent c, View view) 
			{
				g.setColor(color == null ? c.getSelectionColor() : color);

				Rectangle alloc = null;
				if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset()) 
				{
					if (bounds instanceof Rectangle) 
					{
						alloc = (Rectangle) bounds;
					} else 
					{
						alloc = bounds.getBounds();
					}
				} 
				else
				{
					try 
					{
						Shape shape = view.modelToView(offs0,
								Position.Bias.Forward, offs1,
								Position.Bias.Backward, bounds);
						alloc = (shape instanceof Rectangle) ? (Rectangle) shape
								: shape.getBounds();
					}
					catch (BadLocationException e) 
					{
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

			protected Color color; // The color for the underline
		}

		// Shared painter used for default highlighting
		protected static final Highlighter.HighlightPainter sharedPainter = new UnderlineHighlightPainter(null);

		// Painter used for this highlighter
		protected Highlighter.HighlightPainter painter;
	
	
	}


*/