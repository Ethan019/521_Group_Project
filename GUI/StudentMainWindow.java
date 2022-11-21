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

	private static JButton SEE_CURRENT_COURSES, MODIFY_COURSE_REGISTRATION;
	String MESSAGE = "Please Select an Option";

	public StudentMainWindow()
	{

		String MESSAGE = "Please Select an Option";

		JPanel panel = new JPanel();
		panel.setLayout(null);

		ButtonListener listener = new ButtonListener();

		SEE_CURRENT_COURSES = new JButton("See Current Courses");
		SEE_CURRENT_COURSES.setBounds(150, 150, 193, 25);
		SEE_CURRENT_COURSES.setForeground(Color.WHITE);
		SEE_CURRENT_COURSES.setBackground(Color.DARK_GRAY);
		SEE_CURRENT_COURSES.addActionListener(listener);
		panel.add(SEE_CURRENT_COURSES);

		MODIFY_COURSE_REGISTRATION = new JButton("Modify Course Registration");
		MODIFY_COURSE_REGISTRATION.setBounds(150, 180, 193, 25);
		MODIFY_COURSE_REGISTRATION.setForeground(Color.WHITE);
		MODIFY_COURSE_REGISTRATION.setBackground(Color.DARK_GRAY);
		MODIFY_COURSE_REGISTRATION.addActionListener(listener);
		panel.add(MODIFY_COURSE_REGISTRATION);

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
			if (source == SEE_CURRENT_COURSES)
			{

				CustomOutputStream.main("STUDENT: SEE CURRENT COURSES");

				/*
				 * IMPORTANT: Designed to be displayed using System.print... Console Output it
				 * directed to new frame created.
				 * 
				 * 
				 */

				System.out.println("\n" + "!!EXAMPLE OUTPUT!!");

			}

			if (source == MODIFY_COURSE_REGISTRATION)
			{
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}
		}
	}

	public static void main(String args[])
	{
		new StudentMainWindow();
	}

}
