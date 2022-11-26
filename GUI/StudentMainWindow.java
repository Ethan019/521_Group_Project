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

public class StudentMainWindow
{

	private static JButton SEE_CURRENT_COURSES, MODIFY_COURSE_REGISTRATION;
	private String MESSAGE = "Please Select an Option";
	private String id;

	public StudentMainWindow(String id)
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

				CustomOutputStream.main("STUDENT: SEE CURRENT COURSES", false);

				System.out.println("\n" + "========== Displaying courses for Professor " + id + " ==========");
				// ==========================================================================
				/*
				 * what needs to be done: IMPORTANT: Designed to be displayed using
				 * System.print... Console Output is directed to new frame created. PRINT
				 * student COURSES HERE
				 */
				// ===========================================================================

			}

			if (source == MODIFY_COURSE_REGISTRATION)
			{

				List<String> class_list = new ArrayList<String>();
				class_list.add("Select A Course");

				for (int i = 1; i < 5; i++) // <-- fill class_list with a students actual classes
				{
					class_list.add("dummy course " + Integer.toString(i)); // <--test code delete in final version
				}

				ComboBox.main("STUDENT: MODIFY COURSE REGISTRATION", class_list);

				// what needs to be done:
				// MODify the combobox class to display register/unregister buttons when class
				// is selected from drop down list
			}
		}
	}

	public static void main(String args[])
	{
		new StudentMainWindow(args[0]);
	}

}
