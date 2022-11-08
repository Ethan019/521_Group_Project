package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SchoolAdministratorMainWindow
{

	// modify student registration
	// modify courses
	// add or remove a professor
	// add or remove a student
	// see student record

	private static JButton modify_student_registration, modify_courses, add_or_remove_a_professor,
			add_or_remove_a_student, see_student_record;

	public SchoolAdministratorMainWindow()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		ButtonListener listener = new ButtonListener();

		modify_courses = new JButton("Modify offered courses");
		modify_courses.setBounds(150, 130, 193, 25);
		modify_courses.setForeground(Color.WHITE);
		modify_courses.setBackground(Color.DARK_GRAY);
		modify_courses.addActionListener(listener);
		panel.add(modify_courses);

		add_or_remove_a_professor = new JButton("Add or Remove a professor");
		add_or_remove_a_professor.setBounds(150, 160, 193, 25);
		add_or_remove_a_professor.setForeground(Color.WHITE);
		add_or_remove_a_professor.setBackground(Color.DARK_GRAY);
		add_or_remove_a_professor.addActionListener(listener);
		panel.add(add_or_remove_a_professor);

		modify_student_registration = new JButton("Modify Student Registration");
		modify_student_registration.setBounds(150, 190, 193, 25);
		modify_student_registration.setForeground(Color.WHITE);
		modify_student_registration.setBackground(Color.DARK_GRAY);
		modify_student_registration.addActionListener(listener);
		panel.add(modify_student_registration);

		add_or_remove_a_student = new JButton("Add or Remove a student");
		add_or_remove_a_student.setBounds(150, 220, 193, 25);
		add_or_remove_a_student.setForeground(Color.WHITE);
		add_or_remove_a_student.setBackground(Color.DARK_GRAY);
		add_or_remove_a_student.addActionListener(listener);
		panel.add(add_or_remove_a_student);

		see_student_record = new JButton("See a Student Record");
		see_student_record.setBounds(150, 250, 193, 25);
		see_student_record.setForeground(Color.WHITE);
		see_student_record.setBackground(Color.DARK_GRAY);
		see_student_record.addActionListener(listener);
		panel.add(see_student_record);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY: ADMINISTRATOR");
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
			Object source = event.getSource(); // 3--> question icon for popups
			if (source == modify_courses)
			{
				Object[] options1 =
				{ "Add Course", "Remove Course" };

				int selection = JOptionPane.showOptionDialog(null, "message", "Modify Offered Courses",
						JOptionPane.DEFAULT_OPTION, 3, null, options1, null);

				switch (selection)
				{
				case 0:

					Object[] options_add_course =
					{ "Cancel", "Add" };

					JTextField course_department = new JTextField();
					JTextField course_ID = new JTextField();
					JTextField course_name = new JTextField();
					JTextField course_description = new JTextField();

					course_department.setDocument(new JTextFieldLimit(20));
					course_ID.setDocument(new JTextFieldLimit(20));
					course_name.setDocument(new JTextFieldLimit(20));
					course_description.setDocument(new JTextFieldLimit(50));

					Object[] course_fields_add =
					{ "Course Department", course_department, "Course ID", course_ID, "Course Name", course_name,
							"Course Desciption", course_description };

					int selection_add_course = JOptionPane.showOptionDialog(null, course_fields_add,
							"Enter Course Information", JOptionPane.CANCEL_OPTION, 3, null, options_add_course, null);
					break;

				case 1:
					Object[] options_delete_course =
					{ "Cancel", "Delete" };

					JTextField course_ID_delete = new JTextField();
					JTextField course_department_delete = new JTextField();

					course_ID_delete.setDocument(new JTextFieldLimit(20));
					course_department_delete.setDocument(new JTextFieldLimit(20));

					Object[] course_fields_delete =
					{ "Course ID", course_ID_delete, "Course Department", course_department_delete };

					int selection_delete_professor = JOptionPane.showOptionDialog(null, course_fields_delete,
							"Enter Professor ID", JOptionPane.CANCEL_OPTION, 3, null, options_delete_course, null);

					break;

				}
			}
			if (source == add_or_remove_a_professor)
			{
				Object[] options1 =
				{ "Add Professor", "Remove Professor" };

				int selection = JOptionPane.showOptionDialog(null, "message", "Modify Offered Courses",
						JOptionPane.DEFAULT_OPTION, 3, null, options1, null);

				switch (selection)
				{
				case 0:

					Object[] options_add_professor =
					{ "Cancel", "Add" };

					JTextField professor_first_name = new JTextField();
					JTextField professor_last_name = new JTextField();
					JTextField professor_faculty_ID = new JTextField();
					JTextField professor_department_ID = new JTextField();

					professor_first_name.setDocument(new JTextFieldLimit(20));
					professor_last_name.setDocument(new JTextFieldLimit(20));
					professor_faculty_ID.setDocument(new JTextFieldLimit(20));
					professor_department_ID.setDocument(new JTextFieldLimit(20));

					Object[] professor_fields_add =
					{ "First Name", professor_first_name, "Last Name", professor_last_name, "Faculty ID",
							professor_faculty_ID, "Department ID", professor_department_ID };

					int selection_add_professor = JOptionPane.showOptionDialog(null, professor_fields_add,
							"Enter Professor Information", JOptionPane.CANCEL_OPTION, 3, null, options_add_professor,
							null);

					break;

				case 1:

					Object[] options_delete_professor =
					{ "Cancel", "Delete" };

					JTextField professor_faculty_ID_delete = new JTextField();

					professor_faculty_ID_delete.setDocument(new JTextFieldLimit(20));

					Object[] professor_fields_delete =
					{ "Faculty ID", professor_faculty_ID_delete };

					int selection_delete_professor = JOptionPane.showOptionDialog(null, professor_fields_delete,
							"Enter Professor ID", JOptionPane.CANCEL_OPTION, 3, null, options_delete_professor, null);

					break;

				}
			}
			if (source == modify_student_registration)
			{

			}
			if (source == add_or_remove_a_student)
			{
				Object[] options1 =
				{ "Add Student", "Remove Student" };

				int selection = JOptionPane.showOptionDialog(null, "message", "Add or Remove student",
						JOptionPane.CLOSED_OPTION, 3, null, options1, null);

				switch (selection)
				{
				case 0:

					Object[] options_add_student =
					{ "Cancel", "Add" };

					JTextField student_first_name = new JTextField();
					JTextField student_last_name = new JTextField();
					JTextField student_ID = new JTextField();
					JTextField student_classification = new JTextField();

					student_first_name.setDocument(new JTextFieldLimit(20));
					student_last_name.setDocument(new JTextFieldLimit(20));
					student_ID.setDocument(new JTextFieldLimit(20));
					student_classification.setDocument(new JTextFieldLimit(20));

					Object[] student_fields_add =
					{ "First Name", student_first_name, "Last Name", student_last_name, "Student ID", student_ID,
							"Student Classification", student_classification };

					int selection_add_student = JOptionPane.showOptionDialog(null, student_fields_add,
							"Enter student Information", JOptionPane.CANCEL_OPTION, 3, null, options_add_student, null);

					break;

				case 1:

					Object[] options_delete_student =
					{ "Cancel", "Delete" };

					JTextField student_ID_delete = new JTextField();

					student_ID_delete.setDocument(new JTextFieldLimit(20));

					Object[] student_fields_delete =
					{ "Student ID", student_ID_delete };

					int selection_delete_professor = JOptionPane.showOptionDialog(null, student_fields_delete,
							"Enter Student ID", JOptionPane.CANCEL_OPTION, 3, null, options_delete_student, null);

					break;

				}
			}
			if (source == see_student_record)
			{

			}
		}
	}

	public class JTextFieldLimit extends PlainDocument
	{
		private int limit;

		JTextFieldLimit(int limit)
		{
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper)
		{
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
		{
			if (str == null)
				return;
			if ((getLength() + str.length()) <= limit)
			{
				super.insertString(offset, str, attr);
			}

		}
	}

	public static void main(String args[])
	{
		new SchoolAdministratorMainWindow();
	}
}
