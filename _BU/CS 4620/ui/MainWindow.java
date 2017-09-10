package ui;

/**
 *
 * @author Chris Kemerait
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.StudentInfoManager;


public class MainWindow extends JFrame
{

	private StudentInfoManager manager;
	private JButton studentButton, adminButton;

	public MainWindow(StudentInfoManager manager)
	{
		this.manager = manager;
		JPanel panel = new JPanel();
		add (panel);
		studentButton = new JButton ("Student");
		adminButton = new JButton ("Administrator");
		panel.add(studentButton);
		panel.add (adminButton);
		ActionListener listener = new ButtonListener();
		studentButton.addActionListener(listener);
		adminButton.addActionListener(listener);
		setSize (300,300);
		setVisible(true);
	}

	private class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == studentButton)
			{
				JFrame f = new ManageStudentWindow (manager);
				f.setVisible (true);
			}
			else
			{
				JFrame f = new ViewStudentWindow (manager);
				f.setVisible(true);
			}
		}

	}


}