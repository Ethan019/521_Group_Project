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
import javax.swing.JTextField;

public class LoginWindow
{
	private static JButton login, DBAlogin;
	private static JLabel username, password;
	private static JTextField user, pass;

	public LoginWindow()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		username = new JLabel("USERNAME");
		username.setBounds(150, 125, 70, 20);
		panel.add(username);

		user = new JTextField();
		user.setBounds(150, 145, 193, 28);
		panel.add(user);

		password = new JLabel("PASSWORD");
		password.setBounds(150, 170, 70, 20);
		panel.add(password);

		pass = new JTextField();
		pass.setBounds(150, 190, 193, 28);
		panel.add(pass);

		ButtonListener listener = new ButtonListener();

		login = new JButton("LOGIN");
		login.setBounds(150, 225, 193, 25);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.DARK_GRAY);
		login.addActionListener(listener);
		panel.add(login);

		DBAlogin = new JButton("DBA LOGIN");
		DBAlogin.setBounds(380, 330, 96, 25);
		DBAlogin.setForeground(Color.WHITE);
		DBAlogin.setBackground(Color.DARK_GRAY);
		DBAlogin.addActionListener(listener);
		panel.add(DBAlogin);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY LOGIN PAGE");
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
			if (source == login)
			{
				System.out.println("Login was pressed");

				String Username1 = username.getText();
				String Password1 = pass.getText();

				if (Username1.equals("section.io") && Password1.equals("123"))
					JOptionPane.showMessageDialog(null, "Login Successful");
				else
					JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
			}

			if (source == DBAlogin)
			{
				// to DBA login
			}
		}
	}

	public static void main(String args[])
	{
		new LoginWindow();
	}

}
