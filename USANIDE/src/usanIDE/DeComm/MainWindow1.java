package usanIDE.DeComm;

/**
 *
 * @author Chris Kemerait
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import usanIDE.MainController;

public class MainWindow1 extends JFrame {
	private JButton goButton;
	JTextArea mainBox;
	JTextArea outLabel;

	private MainController controller;

	/**
	 * 
	 */
	public MainWindow1() 
	{
		controller = new MainController();// (manager);
		JPanel panel = new JPanel();
		//panel.setLayout(new GridBagLayout());

		//JPanel northPanel = new JPanel();
		//northPanel.setLayout(new GridBagLayout());
		
		mainBox = new JTextArea("This is where the input goes.", 10, 100);
		mainBox.setEditable(true);
		
		mainBox.setSize(800,800);
		
		panel.add(mainBox);
		
		goButton = new JButton("Check text.");
		goButton.addActionListener(new ButtonListener());
		
		//panel.add(goButton);

		outLabel = new JTextArea("This is where the output goes.");
		outLabel.setEditable(false);
		
		//panel.add(outLabel);

		
		
		add(panel);
		setSize(600, 600);
		setVisible(true);		
	}

	

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
		}

	}

}