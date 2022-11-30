package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//AUTHOR: JARED KEKLAK (UNLESS ANNOTATED)
public class ComboBox extends JFrame implements ActionListener
{

	private static JLabel DropDownLabel;
	private JComboBox msglist;
	private String CURRENT_ITEM;

	JTextArea textArea;

	private JLabel testlabel = new JLabel("test");

	public static int STUDENT_ADD_COURSE = 1;
	private JButton register;

	public static int STUDENT_DROP_COURSE = 2;
	private JButton unregister;

	public static int PROFESSOR_MODIFY_COURSE_GRADES = 3;
	private JButton save;

	public static int PROFESSOR_MODIFY_COURSE_DESCRIPTION = 4;
	private JButton update;
	private JLabel title;

	public static int ADMINISTRATOR = 5;
	public static int DBA = 6;

	private int role = 0;

	public ComboBox(String Title, List<String> StringList, int role)
	{
		this.role = role;

		setLayout(null);
		setSize(450, 350);
		setTitle(Title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
			register = new JButton("Add Course");
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

			add(textArea);

			JLabel add = new JLabel("Course to add:");
			add.setBounds(170, 20, 110, 40);

			add(add);

		}

		if (role == STUDENT_DROP_COURSE)
		{

			unregister = new JButton("Drop Course");
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

			add(textArea);

			JLabel drop = new JLabel("Course to drop:");
			drop.setBounds(170, 20, 110, 40);

			add(drop);

		}
		if (role == PROFESSOR_MODIFY_COURSE_GRADES)
		{
			save = new JButton("Save");
			save.setBounds(170, 280, 110, 25);
			save.setForeground(Color.WHITE);
			save.setBackground(Color.DARK_GRAY);
			save.addActionListener(this);

			add(save);

			// TODO

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

			add(textArea);

			title = new JLabel("Description:");
			title.setBounds(170, 20, 110, 40);

			add(title);

		}
		if (role == ComboBox.ADMINISTRATOR)
			return;
		if (role == ComboBox.DBA)
			return;

	}

	public static void main(String Title, List<String> StringList, int role)
	{
		ComboBox fr = new ComboBox(Title, StringList, role);

		fr.setLocation(new Point(500, 300));
		fr.setAlwaysOnTop(false);
		fr.setVisible(true);

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
					JOptionPane.showMessageDialog(null, "Class added.", "Success", JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "Class dropped.", "SUCCESS", JOptionPane.WARNING_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Course not dropped.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (role == PROFESSOR_MODIFY_COURSE_GRADES)
		{

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
					textArea.append(" " + "\n");

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
					JOptionPane.showMessageDialog(null, "Description updated.", "SUCCESS", JOptionPane.WARNING_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(null, "An error occured. Description not updated.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (role == ADMINISTRATOR)
		{

		}
		if (role == DBA)
		{

		}
		// TODO Auto-generated method stub

	}
}
