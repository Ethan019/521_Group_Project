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
	private static JButton LOGIN, RETURN;
	private static JLabel USERNAME, PASSWORD;
	private static JTextField USER, PASS;

	public DBALogin()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		USERNAME = new JLabel("UNIVERSITY ID");
		USERNAME.setBounds(150, 85, 90, 20);
		panel.add(USERNAME);

		USER = new JTextField();
		USER.setBounds(150, 105, 193, 28);
		panel.add(USER);

		PASSWORD = new JLabel("PASSWORD");
		PASSWORD.setBounds(150, 130, 70, 20);
		panel.add(PASSWORD);

		PASS = new JTextField();
		PASS.setBounds(150, 150, 193, 28);
		panel.add(PASS);

		PASSWORD = new JLabel("DBA ID");
		PASSWORD.setBounds(150, 175, 70, 20);
		panel.add(PASSWORD);

		PASS = new JTextField();
		PASS.setBounds(150, 193, 193, 28);
		panel.add(PASS);

		ButtonListener listener = new ButtonListener();

		LOGIN = new JButton("LOGIN");
		LOGIN.setBounds(150, 225, 193, 25);
		LOGIN.setForeground(Color.WHITE);
		LOGIN.setBackground(Color.DARK_GRAY);
		LOGIN.addActionListener(listener);
		panel.add(LOGIN);

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

		LOGIN.addActionListener(e ->
		{

		});

		frame.setAlwaysOnTop(true);

	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) throws IllegalArgumentException
		{
			Object source = event.getSource();
			if (source == LOGIN)
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
		new DBALogin();
	}

}
