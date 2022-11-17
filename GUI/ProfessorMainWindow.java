package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProfessorMainWindow
{

	private static JButton SEE_CURRENT_COURSES, MODIFY_COURSE_GRADES, MODIFY_A_COURSE_DESCRIPTION;
	String MESSAGE = "Please Select an Option";

	public ProfessorMainWindow()
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

		MODIFY_A_COURSE_DESCRIPTION = new JButton("Modify Course Grades");
		MODIFY_A_COURSE_DESCRIPTION.setBounds(150, 180, 193, 25);
		MODIFY_A_COURSE_DESCRIPTION.setForeground(Color.WHITE);
		MODIFY_A_COURSE_DESCRIPTION.setBackground(Color.DARK_GRAY);
		MODIFY_A_COURSE_DESCRIPTION.addActionListener(listener);
		panel.add(MODIFY_A_COURSE_DESCRIPTION);

		MODIFY_COURSE_GRADES = new JButton("Modify A Course Decription");
		MODIFY_COURSE_GRADES.setBounds(150, 210, 193, 25);
		MODIFY_COURSE_GRADES.setForeground(Color.WHITE);
		MODIFY_COURSE_GRADES.setBackground(Color.DARK_GRAY);
		MODIFY_COURSE_GRADES.addActionListener(listener);
		panel.add(MODIFY_COURSE_GRADES);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY: PROFESSOR");
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
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}

			if (source == MODIFY_A_COURSE_DESCRIPTION)
			{
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}

			if (source == MODIFY_COURSE_GRADES)
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
		new ProfessorMainWindow();
	}
}
