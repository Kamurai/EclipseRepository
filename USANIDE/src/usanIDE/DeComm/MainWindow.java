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

public class MainWindow extends JFrame {
	private JButton goButton;
	JTextArea mainBox;
	JTextArea outLabel;

	private MainController controller;

	/**
	 * 
	 */
	public MainWindow() 
	{
		controller = new MainController();// (manager);
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridBagLayout());
		
		mainBox = new JTextArea("This is where the input goes.\n\n\n");
		mainBox.setEditable(true);
		
		GridBagConstraints con = new GridBagConstraints();
		con.fill = 2;
		con.gridx = 0;
		con.gridy = 0;
		
		
		JScrollPane northScroll = new JScrollPane(mainBox);
		mainBox.setSize(800,800);
		northPanel.add(northScroll, con);
		
		goButton = new JButton("Check text.");
		goButton.addActionListener(new ButtonListener());
		
		JPanel midPanel = new JPanel();
		midPanel.add(goButton);

		JPanel southPanel = new JPanel();
		outLabel = new JTextArea("This is where the output goes.");
		outLabel.setEditable(false);
		
		southPanel.add(outLabel);

		//add panels
		con.fill = 2;
		con.gridx = 0;
		con.gridy = 0;
		
		panel.add(northPanel, con);
		
		con.gridx = 0;
		con.gridy = 1;
		panel.add(midPanel, con);
		
		con.gridx = 0;
		con.gridy = 2;
		panel.add(southPanel, con);
		
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