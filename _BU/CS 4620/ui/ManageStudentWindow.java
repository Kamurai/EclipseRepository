package ui;

/**
 *
 * @author Chris Kemerait
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.CareerInterests;
import logic.ManageStudentController;
import logic.Student;
import logic.StudentInfoManager;


public class ManageStudentWindow extends JFrame
{

	private JTextField nameField;
	private JTextField[] interests;
	private ManageStudentController controller;
	private JButton saveButton;
	private Student s;

	public ManageStudentWindow(StudentInfoManager manager)
	{
		controller = new ManageStudentController ();//(manager);
		JPanel panel = new JPanel();
		JLabel nameLabel = new JLabel ("enter name");
		nameField = new JTextField (20);
		nameField.addActionListener(new NameFieldListener());
		panel.add(nameLabel);
		panel.add(nameField);
		JLabel interestLabel = new JLabel ("career interests");
		panel.add(interestLabel);
		interests = new JTextField[10];
		for (int i = 0; i < interests.length; i++)
		{
			interests[i] = new JTextField(20);
			interests[i].setText("");
			panel.add(interests[i]);
		}
		saveButton = new JButton ("save changes");
		saveButton.addActionListener(new ButtonListener());
		panel.add(saveButton);
		add (panel);
		setSize (600,600);
		setVisible(true);
	}

	private class NameFieldListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			String name = nameField.getText();
			if (name.equals(""))
				JOptionPane.showMessageDialog(null, "empty name - try again");
			else
			{
				s = controller.getStudent(name);
				if (s == null)
					JOptionPane.showMessageDialog(null, "student not in system");
				else
				{
					List<String> studentInterests = s.getProfile().getInterests().getCareerInterests();
					for (int i = 0; i < studentInterests.size(); i++)
						interests[i].setText(studentInterests.get(i));
				}
			}
		}

	}

	private class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			CareerInterests c = new CareerInterests();
			for (int i = 0; i < interests.length; i++)
				if (!interests[i].getText().equals(""))
					c.addInterest(interests[i].getText());
			s.getProfile().setInterests(c);
			controller.saveStudent(s);
		}

	}



}