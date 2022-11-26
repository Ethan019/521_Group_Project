package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow
{
	private static JButton LOGIN, DBA_LOGIN;
	private static JLabel USERNAME, PASSWORD;
	private static JTextField USER;
	private static JPasswordField PASS;

	public LoginWindow()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		USERNAME = new JLabel("UNIVERSITY ID");
		USERNAME.setBounds(150, 125, 90, 20);
		panel.add(USERNAME);

		USER = new JTextField();
		USER.setBounds(150, 145, 193, 28);
		panel.add(USER);

		PASSWORD = new JLabel("PASSWORD");
		PASSWORD.setBounds(150, 170, 70, 20);
		panel.add(PASSWORD);

		PASS = new JPasswordField();
		PASS.setBounds(150, 190, 193, 28);
		panel.add(PASS);

		ButtonListener listener = new ButtonListener();

		LOGIN = new JButton("LOGIN");
		LOGIN.setBounds(150, 225, 193, 25);
		LOGIN.setForeground(Color.WHITE);
		LOGIN.setBackground(Color.DARK_GRAY);
		LOGIN.addActionListener(listener);
		panel.add(LOGIN);

		DBA_LOGIN = new JButton("DBA LOGIN");
		DBA_LOGIN.setBounds(380, 330, 96, 25);
		DBA_LOGIN.setForeground(Color.WHITE);
		DBA_LOGIN.setBackground(Color.DARK_GRAY);
		DBA_LOGIN.addActionListener(listener);
		panel.add(DBA_LOGIN);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY LOGIN PAGE");
		frame.setLocation(new Point(500, 300));
		frame.add(panel);
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// frame.setAlwaysOnTop(true);

		LOGIN.addActionListener(e ->
		{

		});

	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == LOGIN)
			{
				String id = USER.getText(); // here is user id
				String pw = PASS.getPassword().toString(); // here is password

				// String[] args = { id }; // <-- UNCOMMENT THIS IN FINAL VERSION
				String[] args =
				{ "10000000" }; // <-- TEST args, COMMENT THIS OUT IN FINAL VERSION

				boolean is_user = true; // MAKE THIS BOOLEAN TRUE OR FALSE DEPENDING ON IF THEY CAN LOGIN AS A USER OR
										// NOT
				/*
				 * 
				 * 
				 * sql to login to databse here!
				 * 
				 * 
				 */

				if (is_user && args != null)
				{
					if (false) // PLACE HOLDER: determine if they are a student
						StudentMainWindow.main(args);

					if (false) // PLACE HOLDER: determine if they are a professor
						ProfessorMainWindow.main(args);

					if (true) // PLACE HOLDER: determine if they are schooladmin
						SchoolAdministratorMainWindow.main(args);

				} else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}

			if (source == DBA_LOGIN)
			{

				DBALogin.main(null);

			}
		}
	}

	public static void main(String args[])
	{
		new LoginWindow();
	}

}
