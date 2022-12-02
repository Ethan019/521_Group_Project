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
public class DBAMainWindow
{
	private static JButton MODIFY_STUDENT_TABLES, MODIFY_PROFESSOR_TABLES, MODIFY_SCHOOL_ADMIN_TABLES,
			MODIFY_COURSE_TABLES, MODIFY_DEPARTMENT_TABLES, ENTER_TERMINAL;
	private String MESSAGE = "Please Select an Option";
	private String id;

	public static String CURRENT_STUDENT;

	public DBAMainWindow(String id)
	{

		this.id = id;
		JPanel panel = new JPanel();
		panel.setLayout(null);

		ButtonListener listener = new ButtonListener();

		MODIFY_STUDENT_TABLES = new JButton("Modify Student Tables");
		MODIFY_STUDENT_TABLES.setBounds(150, 130, 193, 25);
		MODIFY_STUDENT_TABLES.setForeground(Color.WHITE);
		MODIFY_STUDENT_TABLES.setBackground(Color.DARK_GRAY);
		MODIFY_STUDENT_TABLES.addActionListener(listener);
		panel.add(MODIFY_STUDENT_TABLES);

		MODIFY_PROFESSOR_TABLES = new JButton("Modify Professor Tables");
		MODIFY_PROFESSOR_TABLES.setBounds(150, 160, 193, 25);
		MODIFY_PROFESSOR_TABLES.setForeground(Color.WHITE);
		MODIFY_PROFESSOR_TABLES.setBackground(Color.DARK_GRAY);
		MODIFY_PROFESSOR_TABLES.addActionListener(listener);
		panel.add(MODIFY_PROFESSOR_TABLES);

		MODIFY_SCHOOL_ADMIN_TABLES = new JButton("Modify Administrator Tables");
		MODIFY_SCHOOL_ADMIN_TABLES.setBounds(150, 190, 193, 25);
		MODIFY_SCHOOL_ADMIN_TABLES.setForeground(Color.WHITE);
		MODIFY_SCHOOL_ADMIN_TABLES.setBackground(Color.DARK_GRAY);
		MODIFY_SCHOOL_ADMIN_TABLES.addActionListener(listener);
		panel.add(MODIFY_SCHOOL_ADMIN_TABLES);

		MODIFY_COURSE_TABLES = new JButton("Modify Course Tables");
		MODIFY_COURSE_TABLES.setBounds(150, 220, 193, 25);
		MODIFY_COURSE_TABLES.setForeground(Color.WHITE);
		MODIFY_COURSE_TABLES.setBackground(Color.DARK_GRAY);
		MODIFY_COURSE_TABLES.addActionListener(listener);
		panel.add(MODIFY_COURSE_TABLES);

		MODIFY_DEPARTMENT_TABLES = new JButton("Modify Department Tables");
		MODIFY_DEPARTMENT_TABLES.setBounds(150, 250, 193, 25);
		MODIFY_DEPARTMENT_TABLES.setForeground(Color.WHITE);
		MODIFY_DEPARTMENT_TABLES.setBackground(Color.DARK_GRAY);
		MODIFY_DEPARTMENT_TABLES.addActionListener(listener);
		panel.add(MODIFY_DEPARTMENT_TABLES);

		ENTER_TERMINAL = new JButton("Enter Terminal");
		ENTER_TERMINAL.setBounds(150, 280, 193, 25);
		ENTER_TERMINAL.setForeground(Color.WHITE);
		ENTER_TERMINAL.setBackground(Color.DARK_GRAY);
		ENTER_TERMINAL.addActionListener(listener);
		panel.add(ENTER_TERMINAL);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY: DATABASE ADMINISTRATOR");
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
			if (source == MODIFY_STUDENT_TABLES)
			{
				///
				///
				///

				Object[] options1 =
				{ "Add Student", "Delete Student", "Modify Student Registration", "Modify Student Grades" };

				int selection = JOptionPane.showOptionDialog(null, MESSAGE, "Modify Student Tables",
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

					switch (selection_add_student)
					{
					case 1:
						String sfname = student_first_name.getText();
						String slname = student_last_name.getText();
						String sID = student_ID.getText();
						String sclass = student_classification.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO add student here
						//
						// ========================================================

						boolean success = false; // SQL BOOLEAN TO VERIFY student IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Student added.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Student not added.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
					}

					break;

				case 1:

					Object[] options_delete_student =
					{ "Cancel", "Delete" };

					JTextField student_ID_delete = new JTextField();

					student_ID_delete.setDocument(new JTextFieldLimit(20));

					Object[] student_fields_delete =
					{ "Student ID", student_ID_delete };

					int selection_delete_student = JOptionPane.showOptionDialog(null, student_fields_delete,
							"Enter Student ID", JOptionPane.CANCEL_OPTION, 3, null, options_delete_student, null);

					switch (selection_delete_student)
					{
					case 1:
						String sID = student_ID_delete.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO delete student here
						//
						// ========================================================

						boolean success = false; // SQL BOOLEAN TO VERIFY student IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Student deleted.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Student not deleted.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
					}

					break;

				case 2:

					Object[] option_modify_student_registration =
					{ "Cancel", "Go" };

					JTextField student_ID_registration = new JTextField();

					student_ID_registration.setDocument(new JTextFieldLimit(20));

					Object[] student_modify_registration =
					{ "Student ID", student_ID_registration };

					int selection_modify_student_registration = JOptionPane.showOptionDialog(null,
							student_modify_registration, "Enter Student ID", JOptionPane.CANCEL_OPTION, 3, null,
							option_modify_student_registration, null);

					switch (selection_modify_student_registration)
					{
					case 0:
						break;
					case 1:

						String stud_id = student_ID_registration.getText();
						CURRENT_STUDENT = stud_id;

						boolean is_student = true; // sql boolean to determin if student is found or not

						if (is_student)
						{
							Object[] options =
							{ "Add a Course", "Drop a Course" };
							int stud_selection = JOptionPane.showOptionDialog(null, MESSAGE,
									"STUDENT " + stud_id + " Add or Drop a course", JOptionPane.CLOSED_OPTION, 3, null,
									options, null);

							switch (stud_selection)
							{
							case 0:
								Object[] department_options =
								{ "Cancel", "Go" };

								JTextField department = new JTextField();
								department.setDocument(new JTextFieldLimit(20));

								Object[] dept_fields =
								{ "Department ID", department };

								int department_input = JOptionPane.showOptionDialog(null, dept_fields,
										"Enter Department Information", JOptionPane.CANCEL_OPTION, 3, null,
										department_options, null);

								switch (department_input)
								{
								case 0:
									break;
								case 1:
									String dept_code = department.getText();

									boolean is_dept = true; // ATTENTION TODO <-- sql boolean to check if code is valid
															// department

									if (is_dept)
									{
										List<String> class_list = new ArrayList<String>();
										class_list.add(dept_code);

										for (int i = 1; i < 50; i++) // ATTENTION TODO <-- fill class_list with a
																		// departments actual
																		// classes
										{
											class_list.add("dummy course " + Integer.toString(i)); // <--test code
																									// delete in
																									// final
																									// version
										}

										ComboBox.main("DBA: MODIFY STUDENT REGISTRATION", class_list,
												ComboBox.DBA_STUDENT_ADD_COURSE);
									}
									break;
								}

								break;
							case 1:
								List<String> class_list = new ArrayList<String>();
								class_list.add(stud_id);

								for (int i = 1; i < 5; i++) // ATTENTION TODO <-- fill class_list with a students actual
															// classes
								{
									class_list.add("dummy course " + Integer.toString(i)); // <--test code delete in
																							// final
																							// version
								}

								ComboBox.main("DBA: MODIFY STUDENT REGISTRATION", class_list,
										ComboBox.DBA_STUDENT_DROP_COURSE);
								break;
							}
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Student not found.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					break;
				case 3:

					Object[] option_modify_student_grades =
					{ "Cancel", "Go" };

					JTextField student_ID_grades = new JTextField();

					student_ID_grades.setDocument(new JTextFieldLimit(20));

					Object[] student_modify_grades =
					{ "Student ID", student_ID_grades };

					int selection_modify_student_grades = JOptionPane.showOptionDialog(null, student_modify_grades,
							"Enter Student ID", JOptionPane.CANCEL_OPTION, 3, null, option_modify_student_grades, null);

					boolean student_found = true; // sql boolean to determin if student is found
					if (student_found)
					{
						List<String> class_list = new ArrayList<String>();
						class_list.add(student_ID_grades.getText());

						// test code, fill up class_list with students current classes
						for (int i = 1; i < 5; i++)
						{
							class_list.add("dummy class " + Integer.toString(i));
						}

						ComboBox.main("DBA: MODIFY STUDENT GRADES", class_list, ComboBox.DBA_MODIFY_STUDENT_GRADES);
					} else
					{
						JOptionPane.showMessageDialog(null, "An error occured. Student not found.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

					break;

				}

				///
				///
				///
			}

			if (source == MODIFY_PROFESSOR_TABLES)
			{
				Object[] options =
				{ "Add Professor", "Delete Professor" };

				int selection = JOptionPane.showOptionDialog(null, MESSAGE, "Modify Professor Tables",
						JOptionPane.CLOSED_OPTION, 3, null, options, null);

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

					switch (selection_add_professor)
					{
					case 1:
						String pfname = professor_first_name.getText();
						String plname = professor_last_name.getText();
						String pfID = professor_faculty_ID.getText();
						String pdeptID = professor_department_ID.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO add professor here
						//
						// ========================================================

						boolean success = false; // BOOLEAN TO VERIFY professor IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Professor added.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Professor not added.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					}
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

					switch (selection_delete_professor)
					{
					case 1:
						String pfID = professor_faculty_ID_delete.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO delete professor here
						//
						// ========================================================

						boolean success = false; // BOOLEAN TO VERIFY professor IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Professor deleted.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Professor not deleted.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
					}

					break;

				}

			}
			if (source == MODIFY_SCHOOL_ADMIN_TABLES)
			{
				Object[] options1 =
				{ "Add Administrator", "Delete Admnistrator" };

				int selection = JOptionPane.showOptionDialog(null, MESSAGE, "Modify School Administrator Tables",
						JOptionPane.CLOSED_OPTION, 3, null, options1, null);

				switch (selection)
				{
				case 0:

					Object[] options_add_admin =
					{ "Cancel", "Add" };

					JTextField admin_first_name = new JTextField();
					JTextField admin_last_name = new JTextField();
					JTextField admin_faculty_ID = new JTextField();
					JTextField admin_department_ID = new JTextField();

					admin_first_name.setDocument(new JTextFieldLimit(20));
					admin_last_name.setDocument(new JTextFieldLimit(20));
					admin_faculty_ID.setDocument(new JTextFieldLimit(20));
					admin_department_ID.setDocument(new JTextFieldLimit(20));

					Object[] admin_fields_add =
					{ "First Name", admin_first_name, "Last Name", admin_last_name, "Faculty ID", admin_faculty_ID,
							"Department ID", admin_department_ID };

					int selection_add_admin = JOptionPane.showOptionDialog(null, admin_fields_add,
							"Enter Administrator Information", JOptionPane.CANCEL_OPTION, 3, null, options_add_admin,
							null);

					switch (selection_add_admin)
					{
					case 1:
						String afname = admin_first_name.getText();
						String alname = admin_last_name.getText();
						String afID = admin_faculty_ID.getText();
						String adeptID = admin_department_ID.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO add professor here
						//
						// ========================================================

						boolean success = false; // BOOLEAN TO VERIFY professor IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Administrator added.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Administrator not added.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					}
					break;

				case 1:

					Object[] options_delete_admin =
					{ "Cancel", "Delete" };

					JTextField admin_faculty_ID_delete = new JTextField();

					admin_faculty_ID_delete.setDocument(new JTextFieldLimit(20));

					Object[] admin_fields_delete =
					{ "Faculty ID", admin_faculty_ID_delete };

					int selection_delete_admin = JOptionPane.showOptionDialog(null, admin_fields_delete,
							"Enter Administrator ID", JOptionPane.CANCEL_OPTION, 3, null, options_delete_admin, null);

					switch (selection_delete_admin)
					{
					case 1:
						String afID = admin_faculty_ID_delete.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO delete professor here
						//
						// ========================================================

						boolean success = false; // BOOLEAN TO VERIFY professor IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Administrator deleted.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Administrator not deleted.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
					}

					break;

				}

			}
			if (source == MODIFY_COURSE_TABLES)
			{
				Object[] options =
				{ "Add Course", "Delete Course" };

				int selection = JOptionPane.showOptionDialog(null, MESSAGE, "Modify Course Tables",
						JOptionPane.CLOSED_OPTION, 3, null, options, null);

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

					switch (selection_add_course)
					{
					case 1:
						String cid = course_department.getText();
						String cdept = course_ID.getText();
						String cname = course_name.getText();
						String cdesc = course_description.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO add course here
						//
						// ========================================================

						boolean success = false; // SQL BOOLEAN TO VERIFY if IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Course added.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Course not added.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}

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

					int selection_delete_course = JOptionPane.showOptionDialog(null, course_fields_delete,
							"Enter Course Information", JOptionPane.CANCEL_OPTION, 3, null, options_delete_course,
							null);

					switch (selection_delete_course)
					{
					case 1:
						String cid = course_ID_delete.getText();
						String cdept = course_department_delete.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO delete course here
						//
						// ========================================================

						boolean success = false; // SQL BOOLEAN TO VERIFY if IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Course deleted.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Course not deleted.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					break;

				}

			}
			if (source == MODIFY_DEPARTMENT_TABLES)
			{
				Object[] options1 =
				{ "Add Department", "Delete Department" };

				int selection = JOptionPane.showOptionDialog(null, MESSAGE, "Modify Department Tables",
						JOptionPane.CLOSED_OPTION, 3, null, options1, null);

				switch (selection)
				{
				case 0:
					Object[] options_add_department =
					{ "Cancel", "Add" };

					JTextField department_ID_add = new JTextField();

					department_ID_add.setDocument(new JTextFieldLimit(20));

					Object[] department_fields_add =
					{ "Department ID", department_ID_add }; // "Course Department", course_department_delete };

					int selection_add_department = JOptionPane.showOptionDialog(null, department_fields_add,
							"Enter Department Information", JOptionPane.CANCEL_OPTION, 3, null, options_add_department,
							null);

					switch (selection_add_department)
					{
					case 1:
						String deptid = department_ID_add.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO add department here
						//
						// ========================================================

						boolean success = false; // SQL BOOLEAN TO VERIFY if IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Department added.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Department not added.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					break;

				case 1:
					Object[] options_delete_department =
					{ "Cancel", "Delete" };

					JTextField department_ID_delete = new JTextField();

					department_ID_delete.setDocument(new JTextFieldLimit(20));

					Object[] department_fields_delete =
					{ "Department ID", department_ID_delete };

					int selection_delete_department = JOptionPane.showOptionDialog(null, department_fields_delete,
							"Enter Department Information", JOptionPane.CANCEL_OPTION, 3, null,
							options_delete_department, null);

					switch (selection_delete_department)
					{
					case 1:
						String deptid = department_ID_delete.getText();

						// ========================================================
						//
						// what needs to be done: SQL FUNCTION TO delete department here
						//
						// ========================================================

						boolean success = false; // SQL BOOLEAN TO VERIFY if IS ADDED/DELETED

						if (success)
						{
							JOptionPane.showMessageDialog(null, "Department deleted.", "Success",
									JOptionPane.WARNING_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(null, "An error occured. Department not deleted.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					break;
				}

			}
			if (source == ENTER_TERMINAL)
			{
				DBATerminal.main();
			}
		}
	}

	public static void main(String args[])
	{
		new DBAMainWindow(args[0]);
	}
}
