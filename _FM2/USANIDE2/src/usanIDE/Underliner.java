package usanIDE;

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


public class Underliner extends LayeredHighlighter.LayerPainter
{
	Color color;
		
	Underliner()
	{
		color = Color.red;
	}
	
	public Underliner(Color input)
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

		
}
	
	
	
	
	
	




/*
		// Painter for underlined highlights
		public static class UnderlineHighlightPainter extends LayeredHighlighter.LayerPainter 
		{
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

*/