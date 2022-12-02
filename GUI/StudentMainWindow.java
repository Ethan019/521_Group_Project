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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//AUTHOR: JARED KEKLAK (UNLESS ANNOTATED)
public class StudentMainWindow
{

	private static JButton SEE_CURRENT_COURSES, MODIFY_COURSE_REGISTRATION;
	private String MESSAGE = "Please select an option";
	private String id;

	public StudentMainWindow(String id)
	{

		this.id = id;

		JPanel panel = new JPanel();
		panel.setLayout(null);

		ButtonListener listener = new ButtonListener();

		SEE_CURRENT_COURSES = new JButton("See current courses");
		SEE_CURRENT_COURSES.setBounds(150, 150, 193, 25);
		SEE_CURRENT_COURSES.setForeground(Color.WHITE);
		SEE_CURRENT_COURSES.setBackground(Color.DARK_GRAY);
		SEE_CURRENT_COURSES.addActionListener(listener);
		panel.add(SEE_CURRENT_COURSES);

		MODIFY_COURSE_REGISTRATION = new JButton("Modify course registration");
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
		frame.setResizable(false);

	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == SEE_CURRENT_COURSES)
			{

				CustomOutputStream.main("STUDENT: SEE CURRENT COURSES", false);

				System.out.println("\n" + "========== displaying courses for student " + id + " ==========");
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

				Object[] options =
				{ "Add a course", "Drop a course" };
				int selection = JOptionPane.showOptionDialog(null, MESSAGE, "Add or Drop a course",
						JOptionPane.CLOSED_OPTION, 3, null, options, null);

				switch (selection)
				{
				case 0:

					Object[] department_options =
					{ "Cancel", "Go" };

					JTextField department = new JTextField();
					department.setDocument(new JTextFieldLimit(20));

					Object[] dept_fields =
					{ "Department ID", department };

					int department_input = JOptionPane.showOptionDialog(null, dept_fields,
							"Enter department information", JOptionPane.CANCEL_OPTION, 3, null, department_options,
							null);

					switch (department_input)
					{
					case 1:
						String dept_code = department.getText();

						boolean is_dept = true; // ATTENTION TODO <-- sql boolean to check if code is valid department

						if (is_dept)
						{
							List<String> class_list = new ArrayList<String>();
							class_list.add(dept_code);

							for (int i = 1; i < 50; i++) // ATTENTION TODO <-- fill class_list with a departments actual
															// classes
							{
								class_list.add("dummy course " + Integer.toString(i)); // <--test code delete in final
																						// version
							}

							ComboBox.main("STUDENT: MODIFY COURSE REGISTRATION", class_list,
									ComboBox.STUDENT_ADD_COURSE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Department not found.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

						break;
					}

					break;
				case 1:
					List<String> class_list = new ArrayList<String>();
					class_list.add(id);

					for (int i = 1; i < 5; i++) // ATTENTION TODO <-- fill class_list with a students actual classes
					{
						class_list.add("dummy course " + Integer.toString(i)); // <--test code delete in final version
					}

					ComboBox.main("STUDENT: MODIFY COURSE REGISTRATION", class_list, ComboBox.STUDENT_DROP_COURSE);
					break;

				}

			}
		}
	}

	public static void main(String args[])
	{
		new StudentMainWindow(args[0]);
	}

}
