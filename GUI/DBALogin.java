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

public class DBALogin
{
	private static JButton login, RETURN;
	private static JLabel username, password;
	private static JTextField user, pass;

	public DBALogin()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		username = new JLabel("USERNAME");
		username.setBounds(150, 85, 70, 20);
		panel.add(username);

		user = new JTextField();
		user.setBounds(150, 105, 193, 28);
		panel.add(user);

		password = new JLabel("PASSWORD");
		password.setBounds(150, 130, 70, 20);
		panel.add(password);

		pass = new JTextField();
		pass.setBounds(150, 150, 193, 28);
		panel.add(pass);

		password = new JLabel("DBA ID");
		password.setBounds(150, 175, 70, 20);
		panel.add(password);

		pass = new JTextField();
		pass.setBounds(150, 193, 193, 28);
		panel.add(pass);

		ButtonListener listener = new ButtonListener();

		login = new JButton("LOGIN");
		login.setBounds(150, 225, 193, 25);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.DARK_GRAY);
		login.addActionListener(listener);
		panel.add(login);

		RETURN = new JButton("RETURN");
		RETURN.setBounds(380, 330, 96, 25);
		RETURN.setForeground(Color.WHITE);
		RETURN.setBackground(Color.DARK_GRAY);
		panel.add(RETURN);

		JFrame frame = new JFrame();
		frame.setTitle("UNIVERSITY LOGIN PAGE");
		frame.setLocation(new Point(500, 300));
		frame.add(panel);
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		RETURN.addActionListener(e ->
		{
			frame.dispose();
		});

		frame.setAlwaysOnTop(true);

	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == login)
			{

			}

		}
	}

	public static void main(String args[])
	{
		new DBALogin();
	}

}
