package regexTry;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
	private JTextField srcField;
	private JTextField regField;
	private JButton goButton;
	JTextArea southLabel;
	JTextArea northWestLabel;
	JTextArea eastLabel;
	JTextArea southWestLabel;
	
	private MainController controller;

	/**
	 * 
	 */
	public MainWindow() {
		controller = new MainController();// (manager);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));

		JPanel midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(2, 1));
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(5, 1));
		
		JPanel onePanel = new JPanel();
		JPanel twoPanel = new JPanel();
		JPanel thrPanel = new JPanel();
		JPanel fouPanel = new JPanel();
		JPanel fivPanel = new JPanel();

		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(2, 1));
		
		JPanel northWestPanel = new JPanel();
		JPanel southWestPanel = new JPanel();
		
		northWestLabel = new JTextArea("Source Data");
		northWestLabel.setEditable(false);
		northWestPanel.add(northWestLabel);
		
		southWestLabel = new JTextArea("Regex Data");
		southWestLabel.setEditable(false);
		southWestPanel.add(southWestLabel);
		
		JPanel eastPanel = new JPanel();
		eastLabel = new JTextArea("Result Data");
		eastLabel.setEditable(false);
		eastPanel.add(eastLabel);
				
		JPanel southPanel = new JPanel();
		JLabel srcLabel = new JLabel("Enter source:");
		JLabel regLabel = new JLabel("Enter regex:");
		southLabel = new JTextArea("This is where the output goes.");
		southLabel.setEditable(false);

		srcField = new JTextField(50);
		srcField.setText(controller.GetLineFromFile(0));
		srcField.addActionListener(new etmFieldListener());
		onePanel.add(srcLabel);
		twoPanel.add(srcField);

		regField = new JTextField(50);
		regField.setText(controller.GetLineFromFile(1));
		regField.addActionListener(new csvFieldListener());
		thrPanel.add(regLabel);
		fouPanel.add(regField);

		goButton = new JButton("Check table");
		goButton.addActionListener(new ButtonListener());
		fivPanel.add(goButton);

		northPanel.add(onePanel);
		northPanel.add(twoPanel);
		northPanel.add(thrPanel);
		northPanel.add(fouPanel);
		northPanel.add(fivPanel);

		southPanel.add(southLabel);

		midPanel.add(northPanel);
		midPanel.add(southPanel);
		
		westPanel.add(northWestPanel);
		westPanel.add(southWestPanel);
		
		panel.add(westPanel);
		panel.add(midPanel);
		panel.add(eastPanel);
		
		add(panel);
		setSize(1800, 600);
		setVisible(true);		
	}

	private class etmFieldListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String name = srcField.getText();
			File alpha = new File(name);
			if (name.equals(null))
				JOptionPane.showMessageDialog(null, "empty source - try again");
			else {
				// check if file exists
				if (!alpha.exists()) {
					// then output "cannot find etm - try again"
					JOptionPane.showMessageDialog(null,
							"cannot find source - try again");
				}
			}
		}

	}

	private class csvFieldListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String name = regField.getText();
			File alpha = new File(name);
			if (name.equals(""))
				JOptionPane.showMessageDialog(null, "empty regex - try again");
			else {
				// check if file exists
				if (!alpha.exists()) {
					// then output "cannot find csv - try again"
					JOptionPane.showMessageDialog(null,
							"cannot find regex - try again");
				}
			}
		}

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
			String alpha = srcField.getText();
			String beta = regField.getText();
			
			controller.ClearFile();
			controller.SaveLineToFile(alpha+"\n"+beta);
			
			controller.setSource(alpha);
			controller.setRegex(beta);
			
			controller.attemptRegex();
			northWestLabel.setText(controller.printSource());
			southWestLabel.setText(controller.printRegex());
			eastLabel.setText(controller.printResult());
			southLabel.setText("It went.");
		}

	}

}