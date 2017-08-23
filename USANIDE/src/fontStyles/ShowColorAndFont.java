package fontStyles;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import java.awt.font.*;

public class ShowColorAndFont extends JPanel 
{
	public void paint(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;
		String text = "Java is an Object Oriented Programming Language.";
		Dimension dimension = getSize();

		Font font1 = new Font("Book Antiqua", Font.PLAIN, 30);
		Font font2 = new Font("Monotype Corsiva", Font.PLAIN, 30);

		AttributedString attributedString = new AttributedString(text);
		attributedString.addAttribute(TextAttribute.FONT, font1);
		attributedString.addAttribute(TextAttribute.FONT, font2, 1, 4);
		attributedString.addAttribute(TextAttribute.FONT, font2, 6, 7);
		attributedString.addAttribute(TextAttribute.FONT, font2, 9, 10);
		attributedString.addAttribute(TextAttribute.FONT, font2, 12, 17);
		attributedString.addAttribute(TextAttribute.FONT, font2, 19, 26);
		attributedString.addAttribute(TextAttribute.FONT, font2, 28, 38);
		attributedString.addAttribute(TextAttribute.FONT, font2, 40, 47);

		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.red, 0, 1);
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.red, 5, 6);
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.red, 8, 9);
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.red, 11, 12);
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.red, 18, 19);
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.red, 27, 28);
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.red, 39, 40);

		g2d.drawString(attributedString.getIterator(), 40, 80);
	}

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Show Color and Font");
		frame.getContentPane().add(new ShowColorAndFont());
		frame.setSize(700, 200);
		frame.show();
	}
}