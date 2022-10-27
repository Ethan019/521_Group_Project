package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StudentMainWindow
{

	private static JButton see_current_courses, modify_course_registration;

	public StudentMainWindow()
	{

		JPanel panel = new JPanel();
		panel.setLayout(null);

		ButtonListener listener = new ButtonListener();

		see_current_courses = new JButton("See Current Courses");
		see_current_courses.setBounds(150, 150, 193, 25);
		see_current_courses.setForeground(Color.WHITE);
		see_current_courses.setBackground(Color.DARK_GRAY);
		see_current_courses.addActionListener(listener);
		panel.add(see_current_courses);

		modify_course_registration = new JButton("Modify Course Registration");
		modify_course_registration.setBounds(150, 180, 193, 25);
		modify_course_registration.setForeground(Color.WHITE);
		modify_course_registration.setBackground(Color.DARK_GRAY);
		modify_course_registration.addActionListener(listener);
		panel.add(modify_course_registration);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY: STUDENT");
		frame.setLocation(new Point(500, 300));
		frame.add(panel);
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == see_current_courses)
			{

			}

			if (source == modify_course_registration)
			{

			}
		}
	}

	public static void main(String args[])
	{
		new StudentMainWindow();
	}
}
