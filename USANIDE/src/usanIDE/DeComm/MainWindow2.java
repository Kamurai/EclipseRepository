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

public class MainWindow2 extends JFrame {
	private JButton goButton;
	JTextArea mainBox;
	JTextArea outLabel;

	private MainController controller;

	/**
	 * 
	 */
	public MainWindow2() 
	{
		controller = new MainController();// (manager);
		JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(3,1));

		mainBox = new JTextArea("This is where the input goes.", 50, 100);
		mainBox.setEditable(true);
		mainBox.setWrapStyleWord(true);
		
		GridBagConstraints con = new GridBagConstraints();
		con.fill = 0;
		con.gridx = 0;
		con.gridy = 0;
		
		mainBox.setSize(800,800);
		
		JScrollPane northScroll = new JScrollPane(mainBox);
				
		//northScroll.revalidate();
		
		panel.add(northScroll, con);
		
		goButton = new JButton("Check text.");
		goButton.addActionListener(new ButtonListener());
		
		JPanel midPanel = new JPanel();
		midPanel.add(goButton);

		outLabel = new JTextArea("This is where the output goes.", 5, 100);
		outLabel.setEditable(false);
		mainBox.setWrapStyleWord(true);
		
		JScrollPane southScroll = new JScrollPane(outLabel);
		
		
		midPanel.setSize(1000, 100);
		panel.add(midPanel, con);
		
		southScroll.setSize(1000, 100);
		panel.add(southScroll, con);
		
		add(panel);
		setSize(1200, 1000);
		setVisible(true);		
	}

	

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
		}

	}

}