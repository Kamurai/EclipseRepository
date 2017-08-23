package quickSelection;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Main extends JTextPane {

  

  public static void main(String argv[]) {
    Main pane = new Main();
    for (int n = 1; n <= 4; n += 1) 
    {
        pane.appendNaive(Color.black, String.valueOf(n) + ' ');
    }
    JFrame f = new JFrame("ColorPane example");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(new JScrollPane(pane));
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void appendNaive(Color c, String s) 
  {
    SimpleAttributeSet aset = new SimpleAttributeSet();
    StyleConstants.setForeground(aset, c);

    int len = getText().length();
    setCaretPosition(len);
    setCharacterAttributes(aset, false);
    replaceSelection(s);
  }
}
