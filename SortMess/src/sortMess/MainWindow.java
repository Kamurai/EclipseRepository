package sortMess;

/**
 *
 * @author Chris Kemerait
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
	private JButton goButton;
	JTextArea outLabel;

	private MainController controller;

	/**
	 * 
	 */
	public MainWindow() {
		controller = new MainController();// (manager);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(5, 1));
		

		JPanel onePanel = new JPanel();
		JPanel twoPanel = new JPanel();
		JPanel thrPanel = new JPanel();
		JPanel fouPanel = new JPanel();
		JPanel fivPanel = new JPanel();

		JPanel midPanel = new JPanel();
		outLabel = new JTextArea("This is where the output goes.");
		outLabel.setEditable(false);

		
		
		goButton = new JButton("Sort this mess.");
		goButton.addActionListener(new ButtonListener());
		fivPanel.add(goButton);

		northPanel.add(onePanel);
		northPanel.add(twoPanel);
		northPanel.add(thrPanel);
		northPanel.add(fouPanel);
		northPanel.add(fivPanel);

		midPanel.add(outLabel);

		panel.add(northPanel);
		panel.add(midPanel);
		
		add(panel);
		setSize(600, 600);
		setVisible(true);		
	}

	

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
			int[][] mess = new int[2][8];
			
			mess[0][0] = 5;
			mess[1][0] = 1;
			mess[0][1] = 7;
			mess[1][1] = 1;
			mess[0][2] = 3;
			mess[1][2] = 1;
			mess[0][3] = 1;
			mess[1][3] = 1;
			mess[0][4] = 2;
			mess[1][4] = 1;
			mess[0][5] = 9;
			mess[1][5] = 2;
			mess[0][6] = 2;
			mess[1][6] = 2;
			mess[0][7] = 2;
			mess[1][7] = 3;
			
			
			controller.SortIt(mess);
			outLabel.setText(controller.getOutput());
		}

	}

}