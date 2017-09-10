package ui;

/**
 *
 * @author Chris Kemerait
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Student;
import logic.StudentInfoManager;
import logic.StudentNameCollection;
import logic.ViewStudentController;


public class ViewStudentWindow extends JFrame
{

	private ViewStudentController controller;
	private JList studentList;
	private String[] names;
	private JPanel interestsPanel;
	private JLabel interest1;
	private JLabel interest2;
	private JButton selectButton;

	public ViewStudentWindow (StudentInfoManager manager)
	{
		JPanel panel = new JPanel();
		add (panel);
		controller = new ViewStudentController ();
		StudentNameCollection studentNames = controller.getStudentNames();
		names = new String[studentNames.getNames().size()];
		studentNames.getNames().toArray(names);
		studentList = new JList (names);
		studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JLabel label = new JLabel ("select the student");
		panel.add(label);
		panel.add(studentList);
		selectButton = new JButton ("Select");
		selectButton.addActionListener(new ButtonListener());
		panel.add(selectButton);
		interestsPanel = new JPanel();
		interestsPanel.setBorder(new LineBorder (Color.RED));
		interest1 = new JLabel();
		interest2 = new JLabel();
		interestsPanel.add(interest1);
		interestsPanel.add(interest2);
		interestsPanel.setSize (300,300);
		panel.add(interestsPanel);
		setSize (600,600);
		setVisible(true);
	}

	private class ButtonListener implements ActionListener
	{

		public void actionPerformed (ActionEvent e)
		{
			int choice = studentList.getSelectedIndex();
			String name = names[choice];
			Student stu = controller.getStudent(name);
			List<String> interests = stu.getProfile().getInterests().getCareerInterests();
			interest1.setText(interests.get(0));
			interest2.setText(interests.get(1));
		}

	}


}