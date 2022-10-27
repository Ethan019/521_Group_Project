package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWindow
{
	private static JButton login, dba_login;
	private static JLabel username, password;
	private static JTextField user, pass;
	private static DBALogin DBA = new DBALogin();

	public LoginWindow()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		username = new JLabel("UNIVERSITY ID");
		username.setBounds(150, 125, 90, 20);
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

		dba_login = new JButton("DBA LOGIN");
		dba_login.setBounds(380, 330, 96, 25);
		dba_login.setForeground(Color.WHITE);
		dba_login.setBackground(Color.DARK_GRAY);
		dba_login.addActionListener(listener);
		panel.add(dba_login);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY LOGIN PAGE");
		frame.setLocation(new Point(500, 300));
		frame.add(panel);
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);

		login.addActionListener(e ->
		{
			;
		});

	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == login)
			{

			}

			if (source == dba_login)
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
