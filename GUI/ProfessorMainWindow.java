package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//AUTHOR: JARED KEKLAK (UNLESS ANNOTATED)
public class ProfessorMainWindow
{

	private static JButton SEE_CURRENT_COURSES, MODIFY_COURSE_GRADES, MODIFY_A_COURSE_DESCRIPTION;
	private String MESSAGE = "Please Select an Option";
	private String id;

	public ProfessorMainWindow(String id)
	{

		this.id = id;

		JPanel panel = new JPanel();
		panel.setLayout(null);

		ButtonListener listener = new ButtonListener();

		SEE_CURRENT_COURSES = new JButton("See Current Courses");
		SEE_CURRENT_COURSES.setBounds(150, 150, 193, 25);
		SEE_CURRENT_COURSES.setForeground(Color.WHITE);
		SEE_CURRENT_COURSES.setBackground(Color.DARK_GRAY);
		SEE_CURRENT_COURSES.addActionListener(listener);
		panel.add(SEE_CURRENT_COURSES);

		MODIFY_COURSE_GRADES = new JButton("Modify Course Grades");
		MODIFY_COURSE_GRADES.setBounds(150, 180, 193, 25);
		MODIFY_COURSE_GRADES.setForeground(Color.WHITE);
		MODIFY_COURSE_GRADES.setBackground(Color.DARK_GRAY);
		MODIFY_COURSE_GRADES.addActionListener(listener);
		panel.add(MODIFY_COURSE_GRADES);

		MODIFY_A_COURSE_DESCRIPTION = new JButton("Modify Course Description");
		MODIFY_A_COURSE_DESCRIPTION.setBounds(150, 210, 193, 25);
		MODIFY_A_COURSE_DESCRIPTION.setForeground(Color.WHITE);
		MODIFY_A_COURSE_DESCRIPTION.setBackground(Color.DARK_GRAY);
		MODIFY_A_COURSE_DESCRIPTION.addActionListener(listener);
		panel.add(MODIFY_A_COURSE_DESCRIPTION);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY: PROFESSOR");
		frame.setLocation(new Point(500, 300));
		frame.add(panel);
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == SEE_CURRENT_COURSES)
			{
				CustomOutputStream.main("PROFESSOR: SEE CURRENT COURSES", false);

				System.out.println("\n" + "========== Displaying courses for professor " + id + " ==========");
				// ==========================================================================
				/*
				 * IMPORTANT: Designed to be displayed using System.print... Console Output is
				 * directed to new frame created. PRINT PROFESSOR COURSES HERE
				 */
				// ===========================================================================
			}
			if (source == MODIFY_COURSE_GRADES)
			{

				List<String> class_list = new ArrayList<String>();
				class_list.add("Select a class");

				// test code, fill up class_list with professors current classes
				for (int i = 1; i < 5; i++)
				{
					class_list.add("dummy class " + Integer.toString(i));
				}

				ComboBox.main("PROFESSOR: MODIFY COURSE GRADES", class_list, ComboBox.PROFESSOR_MODIFY_COURSE_GRADES);
				// what needs to be done: modify combox box class or make a combobox class to
				// diplay students and allow their grades to be modify when class is selected
				// from the drop down
			}

			if (source == MODIFY_A_COURSE_DESCRIPTION)
			{
				List<String> class_list = new ArrayList<String>();
				class_list.add("Select a class");

				// test code, fill up class_list with professors current classes
				for (int i = 1; i < 5; i++)
				{
					class_list.add("dummy class " + Integer.toString(i));
				}

				ComboBox.main("PROFESSOR: MODIFY COURSE DESCRIPTION", class_list,
						ComboBox.PROFESSOR_MODIFY_COURSE_DESCRIPTION);

			}

		}
	}

	public static void main(String args[])
	{
		new ProfessorMainWindow(args[0]);
	}
}
