package UniversitySystemGUI;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ComboBox extends JFrame implements ActionListener
{

	private static JScrollPane scroll;
	private static JLabel DropDownLabel;

	public ComboBox(String Title, List<String> StringList)
	{
		// setLayout(new FlowLayout());
		setSize(450, 350);
		setTitle(Title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JComboBox msglist = new JComboBox(StringList.toArray());
		msglist.setSelectedIndex(0);
		msglist.addActionListener(this);
		msglist.setSize(120, 25);
		msglist.setLocation(10, 20);

		add(msglist);
	}

	public static void main(String Title, List<String> StringList)
	{
		ComboBox fr = new ComboBox(Title, StringList);

		scroll = new JScrollPane();
		scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_ALWAYS);

		fr.getContentPane().add(scroll);
		fr.setLocation(new Point(500, 300));
		fr.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
