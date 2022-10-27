package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
			Object source = event.getSource();
			if (source == add_or_remove_a_professor)
			{

			}

			if (source == add_or_remove_a_student)
			{

			}
		}
	}

	public static void main(String args[])
	{
		new SchoolAdministratorMainWindow();
	}
}
