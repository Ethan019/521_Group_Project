package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DBAMainWindow
{
	private static JButton MODIFY_STUDENT_TABLES, MODIFY_PROFESSOR_TABLES, MODIFY_SCHOOL_ADMIN_TABLES,
			MODIFY_COURSE_TABLES, MODIFY_DEPARTMENT_TABLES, ENTER_TERMINAL;
	String MESSAGE = "Please Select an Option";

	public DBAMainWindow()
	{

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
		frame.setVisible(true);
	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == MODIFY_STUDENT_TABLES)
			{
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}

			if (source == MODIFY_PROFESSOR_TABLES)
			{
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}
			if (source == MODIFY_SCHOOL_ADMIN_TABLES)
			{
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}
			if (source == MODIFY_COURSE_TABLES)
			{
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}
			if (source == MODIFY_DEPARTMENT_TABLES)
			{
				/*
				 * 
				 * 
				 * additonal code to grab text information and SQL function HERE
				 * 
				 * 
				 */
			}
			if (source == ENTER_TERMINAL)
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
		new DBAMainWindow();
	}
}
