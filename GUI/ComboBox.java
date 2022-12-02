package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//AUTHOR: JARED KEKLAK (UNLESS ANNOTATED)
public class ComboBox extends JFrame implements ActionListener
{

	private static JLabel DropDownLabel;
	private JComboBox msglist;
	private String CURRENT_ITEM;

	JTextArea textArea;

	public static int STUDENT_ADD_COURSE = 1;
	private JButton register;

	public static int STUDENT_DROP_COURSE = 2;
	private JButton unregister;

	public static int PROFESSOR_MODIFY_COURSE_GRADES = 3;
	private JButton save;
	private JButton assign_grade;

	public static int PROFESSOR_MODIFY_COURSE_DESCRIPTION = 4;
	private JButton update;
	private JLabel title;

	public static int ADMINISTRATOR = 5;

	public static int ADMIN_STUDENT_ADD_COURSE = 9;
	public static int ADMIN_STUDENT_DROP_COURSE = 10;

	public static int DBA_MODIFY_STUDENT_GRADES = 6;
	public static int DBA_STUDENT_DROP_COURSE = 7;
	public static int DBA_STUDENT_ADD_COURSE = 8;

	private int role = 0;

	public String first_item;

	public ComboBox(String Title, List<String> StringList, int role)
	{
		this.role = role;

		setLayout(null);
		setSize(450, 350);
		setTitle(Title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		first_item = StringList.get(0);

		msglist = new JComboBox(StringList.toArray());
		msglist.setSelectedIndex(0);
		msglist.addActionListener(this);
		msglist.setSize(120, 25);
		msglist.setLocation(10, 20);

		add(msglist);

		// testlabel.setSize(120, 25);
		// testlabel.setLocation(10, 200);
		// add(testlabel);

		if (role == STUDENT_ADD_COURSE)
		{
			this.role = role;
			register = new JButton("Add course");
			register.setBounds(170, 280, 110, 25);
			register.setForeground(Color.WHITE);
			register.setBackground(Color.DARK_GRAY);
			register.addActionListener(this);

			add(register);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course to add");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);

		}

		if (role == STUDENT_DROP_COURSE)
		{

			unregister = new JButton("Drop course");
			unregister.setBounds(170, 280, 110, 25);
			unregister.setForeground(Color.WHITE);
			unregister.setBackground(Color.DARK_GRAY);
			unregister.addActionListener(this);

			add(unregister);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course to drop");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);

		}
		if (role == PROFESSOR_MODIFY_COURSE_GRADES)
		{

			assign_grade = new JButton("Assign grade");
			assign_grade.setBounds(170, 280, 110, 25);
			assign_grade.setForeground(Color.WHITE);
			assign_grade.setBackground(Color.DARK_GRAY);
			assign_grade.addActionListener(this);

			add(assign_grade);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course roster");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);

		}

		if (role == ComboBox.PROFESSOR_MODIFY_COURSE_DESCRIPTION)
		{
			update = new JButton("Update");
			update.setBounds(170, 275, 110, 25);
			update.setForeground(Color.WHITE);
			update.setBackground(Color.DARK_GRAY);
			update.addActionListener(this);

			add(update);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(true);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course description");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);

		}
		if (role == ComboBox.ADMIN_STUDENT_ADD_COURSE)
		{
			this.role = role;
			register = new JButton("Add course");
			register.setBounds(170, 280, 110, 25);
			register.setForeground(Color.WHITE);
			register.setBackground(Color.DARK_GRAY);
			register.addActionListener(this);

			add(register);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course to add");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);
		}
		if (role == ComboBox.ADMIN_STUDENT_DROP_COURSE)
		{
			unregister = new JButton("Drop course");
			unregister.setBounds(170, 280, 110, 25);
			unregister.setForeground(Color.WHITE);
			unregister.setBackground(Color.DARK_GRAY);
			unregister.addActionListener(this);

			add(unregister);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course to drop");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);
		}

		if (role == ComboBox.DBA_MODIFY_STUDENT_GRADES)
		{
			assign_grade = new JButton("Assign grade");
			assign_grade.setBounds(170, 280, 110, 25);
			assign_grade.setForeground(Color.WHITE);
			assign_grade.setBackground(Color.DARK_GRAY);
			assign_grade.addActionListener(this);

			add(assign_grade);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course Information");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);
		}
		if (role == DBA_STUDENT_ADD_COURSE)
		{
			this.role = role;
			register = new JButton("Add course");
			register.setBounds(170, 280, 110, 25);
			register.setForeground(Color.WHITE);
			register.setBackground(Color.DARK_GRAY);
			register.addActionListener(this);

			add(register);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course to add");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);
		}
		if (role == DBA_STUDENT_DROP_COURSE)
		{
			unregister = new JButton("Drop course");
			unregister.setBounds(170, 280, 110, 25);
			unregister.setForeground(Color.WHITE);
			unregister.setBackground(Color.DARK_GRAY);
			unregister.addActionListener(this);

			add(unregister);

			textArea = new JTextArea(50, 40);
			textArea.setBackground(Color.gray);
			textArea.setForeground(Color.BLACK);
			Font f = new Font("Consolas", Font.PLAIN, 12);
			textArea.setFont(f);
			textArea.setEditable(false);
			textArea.setSize(410, 220);
			textArea.setLocation(10, 50);

			JInternalFrame internal_frame = new JInternalFrame("Course to drop");
			internal_frame.setResizable(false);
			internal_frame.setVisible(true);
			internal_frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			internal_frame.setSize(410, 220);
			internal_frame.setResizable(false);
			internal_frame.setLocation(10, 50);

			JScrollPane scroll_panel = new JScrollPane(textArea);
			scroll_panel.setBackground(Color.darkGray);

			internal_frame.add(scroll_panel);
			// prevent user from moving internal frame, disable mouse listener for frame
			for (MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI())
					.getNorthPane().getMouseListeners())
			{
				((javax.swing.plaf.basic.BasicInternalFrameUI) internal_frame.getUI()).getNorthPane()
						.removeMouseListener(listener);
			}

			add(internal_frame);
		}

	}

	public static void main(String Title, List<String> StringList, int role)
	{
		ComboBox fr = new ComboBox(Title, StringList, role);

		fr.setLocation(new Point(500, 300));
		fr.setAlwaysOnTop(false);
		fr.setVisible(true);
		fr.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (role == STUDENT_ADD_COURSE)
		{
			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:

					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-- "course" contains the course name as string.
																	// Run an SQL query to get the rest of its
																	// information.
					textArea.setText(""); // <--keep this line, it resets the text area after each selection
					textArea.setText("\n" + " " + cb.getSelectedItem().toString() + " selected: " + "\n");
					// ^ use .append(String s) to add course info to text area. start each append
					// with .append(" " + {STRING}); for formating.
				}
			}
			if (e.getSource() == register)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No course selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				// RUN SQL FUNCTION TO ADD COURSE

				boolean success = false; // SQL boolean to check if course is sucessfully added

				if (success)
				{
					JOptionPane.showMessageDialog(null, "Class added.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Course not added.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (role == STUDENT_DROP_COURSE)
		{
			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:

					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-- "CURRENT_ITEM" contains the course name as
																	// string.
																	// Run an SQL query to get the rest of its
																	// information. put it in a variable.
					textArea.setText(""); // <--keep this line, it resets the text area after each selection
					textArea.setText("\n" + " " + cb.getSelectedItem().toString() + " selected: " + "\n");
					// ^ use .append(String s) to add course info to text area. start each append
					// with .append(" " + {STRING}); for formating.
					break;
				}
			}
			if (e.getSource() == unregister)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No course selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				// RUN SQL FUNCTION TO unregister COURSE for student

				boolean success = false; // SQL boolean to check if course is sucessfully dropped

				if (success)
				{
					JOptionPane.showMessageDialog(null, "Class dropped.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Course not dropped.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (role == PROFESSOR_MODIFY_COURSE_GRADES)
		{
			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:
					textArea.setText("");

					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-contains class name
					// run sql query to get class roster
					// use .append() to add roster of class [Student Name, Student ID, Current
					// grade] to text area

					break;

				}
			}
			if (e.getSource() == assign_grade)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No class selected.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				Object[] assign_student_grade =
				{ "Cancel", "Go" };

				JTextField student_ID = new JTextField();

				student_ID.setDocument(new JTextFieldLimit(20));

				Object[] student_modify_registration =
				{ "Student ID", student_ID };

				int selection_student_id = JOptionPane.showOptionDialog(null, student_modify_registration,
						"Enter student ID", JOptionPane.CANCEL_OPTION, 3, null, assign_student_grade, null);

				switch (selection_student_id)
				{
				case 0:
					break;
				case 1:
					String studid = student_ID.getText();

					boolean found = true; // sql boolean to determine is student is found, remeber CURRENT_ITEM contains
											// class name
					if (found)
					{
						Object[] grade =
						{ "Cancel", "Submit" };

						JTextField number_grade = new JTextField();

						number_grade.setDocument(new JTextFieldLimit(3));

						Object[] student_grade =
						{ "Grade", number_grade };

						int selection_student_grade = JOptionPane.showOptionDialog(null, student_grade,
								"Enter student grade", JOptionPane.CANCEL_OPTION, 3, null, grade, null);

						switch (selection_student_grade)
						{
						case 1:
							boolean updated = true; // sql boolean to verify grade is updated

							if (updated)
							{
								JOptionPane.showMessageDialog(null, "Grade has been updated.", "SUCCESS",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							} else
							{
								JOptionPane.showMessageDialog(null, "An error occurred. Grade not updated", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}

					} else
					{
						JOptionPane.showMessageDialog(null, "An error occured. Student not found.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}

		}
		if (role == PROFESSOR_MODIFY_COURSE_DESCRIPTION)
		{
			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:
					textArea.setText("");
					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-- contains course name.
					String description = CURRENT_ITEM + ": TEST DESCRIPTION"; // <-- run SQL query to put course
																				// description in this
					// variable
					// textArea.setText("");
					textArea.append(" " + "\n" + description);

					description = textArea.getText();// run SQL function to update description with this variable

					break;

				}
			}
			if (e.getSource() == update)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No course selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				// RUN SQL FUNCTION TO update course decription

				boolean success = false; // SQL boolean to check if description is updated

				if (success)
				{
					JOptionPane.showMessageDialog(null, "Description updated.", "SUCCESS",
							JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Description not updated.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (role == ADMIN_STUDENT_ADD_COURSE)
		{
			{
				String student_id = SchoolAdministratorMainWindow.CURRENT_STUDENT; // "student_id" variable contains
																					// current student id, use
				// for
				// updates
				if (e.getSource() == msglist)
				{
					JComboBox cb = (JComboBox) e.getSource();
					int selection = cb.getSelectedIndex();
					switch (selection)
					{
					case 0:
						textArea.setText("");
						CURRENT_ITEM = null;
						break;

					default:

						CURRENT_ITEM = cb.getSelectedItem().toString(); // <-- "CURRENT_ITEM" contains the course name
																		// as
																		// string.
																		// Run an SQL query to get the rest of its
																		// information.
						textArea.setText(""); // <--keep this line, it resets the text area after each selection
						textArea.setText("\n" + " " + cb.getSelectedItem().toString() + " selected: " + "\n");
						// ^ use .append(String s) to add course info to text area. start each append
						// with .append(" " + {STRING}); for formating.
					}
				}
				if (e.getSource() == register)
				{
					if (CURRENT_ITEM == null)
					{
						JOptionPane.showMessageDialog(null, "No course selected", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}

					// RUN SQL FUNCTION TO ADD COURSE

					boolean success = false; // SQL boolean to check if course is sucessfully added

					if (success)
					{
						JOptionPane.showMessageDialog(null, "Class added.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					} else
					{
						JOptionPane.showMessageDialog(null, "An error occured. Course not added.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		if (role == ADMIN_STUDENT_DROP_COURSE)
		{
			String current_student_id = first_item; // <--this variable contains the student ID
			// USE FOR UPDATES

			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:

					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-- "CURRENT_ITEM" contains the course name as
																	// string.
																	// Run an SQL query to get the rest of its
																	// information. put it in a variable.
					textArea.setText(""); // <--keep this line, it resets the text area after each selection
					textArea.setText("\n" + " " + cb.getSelectedItem().toString() + " selected: " + "\n");
					// ^ use .append(String s) to add course info to text area. start each append
					// with .append(" " + {STRING}); for formating.
					break;
				}
			}
			if (e.getSource() == unregister)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No course selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				// RUN SQL FUNCTION TO unregister COURSE for student

				boolean success = false; // SQL boolean to check if course is sucessfully dropped

				if (success)
				{
					JOptionPane.showMessageDialog(null, "Class dropped.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Course not dropped.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (role == DBA_MODIFY_STUDENT_GRADES)
		{
			String current_student_id = first_item; // <--this variable contains the student ID
			// USE FOR UPDATES

			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:
					textArea.setText("");

					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-contains class name
					// run SQL query to get class information and students current grades for the
					// class.
					// use textArea.append to add information to text area
					textArea.append(current_student_id + " " + CURRENT_ITEM);

					break;

				}
			}
			if (e.getSource() == assign_grade)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No class selected.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				Object[] grade =
				{ "Cancel", "Submit" };

				JTextField number_grade = new JTextField();

				number_grade.setDocument(new JTextFieldLimit(3));

				Object[] student_grade =
				{ "Grade", number_grade };

				int selection_student_grade = JOptionPane.showOptionDialog(null, student_grade, "Enter student grade",
						JOptionPane.CANCEL_OPTION, 3, null, grade, null);

				switch (selection_student_grade)
				{
				case 1:

					String ng = number_grade.getText(); // CONTAINS THE NUMBER GRADE

					boolean updated = true; // sql boolean to verify grade is updated

					if (updated)
					{
						JOptionPane.showMessageDialog(null, "Grade has been updated.", "SUCCESS",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					} else
					{
						JOptionPane.showMessageDialog(null, "An error occurred. Grade not updated", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

			}

		}
		if (role == DBA_STUDENT_ADD_COURSE)
		{
			String student_id = DBAMainWindow.CURRENT_STUDENT; // "student_id" variable contains current student id, use
																// for
																// updates
			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:

					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-- "CURRENT_ITEM" contains the course name as
																	// string.
																	// Run an SQL query to get the rest of its
																	// information.
					textArea.setText(""); // <--keep this line, it resets the text area after each selection
					textArea.setText("\n" + " " + cb.getSelectedItem().toString() + " selected: " + "\n");
					// ^ use .append(String s) to add course info to text area. start each append
					// with .append(" " + {STRING}); for formating.
				}
			}
			if (e.getSource() == register)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No course selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				// RUN SQL FUNCTION TO ADD COURSE

				boolean success = false; // SQL boolean to check if course is sucessfully added

				if (success)
				{
					JOptionPane.showMessageDialog(null, "Class added.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Course not added.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		if (role == DBA_STUDENT_DROP_COURSE)
		{
			String current_student_id = first_item; // <--this variable contains the student ID
			// USE FOR UPDATES

			if (e.getSource() == msglist)
			{
				JComboBox cb = (JComboBox) e.getSource();
				int selection = cb.getSelectedIndex();
				switch (selection)
				{
				case 0:
					textArea.setText("");
					CURRENT_ITEM = null;
					break;

				default:

					CURRENT_ITEM = cb.getSelectedItem().toString(); // <-- "CURRENT_ITEM" contains the course name as
																	// string.
																	// Run an SQL query to get the rest of its
																	// information. put it in a variable.
					textArea.setText(""); // <--keep this line, it resets the text area after each selection
					textArea.setText("\n" + " " + cb.getSelectedItem().toString() + " selected: " + "\n");
					// ^ use .append(String s) to add course info to text area. start each append
					// with .append(" " + {STRING}); for formating.
					break;
				}
			}
			if (e.getSource() == unregister)
			{
				if (CURRENT_ITEM == null)
				{
					JOptionPane.showMessageDialog(null, "No course selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				// RUN SQL FUNCTION TO unregister COURSE for student

				boolean success = false; // SQL boolean to check if course is sucessfully dropped

				if (success)
				{
					JOptionPane.showMessageDialog(null, "Class dropped.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Course not dropped.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
