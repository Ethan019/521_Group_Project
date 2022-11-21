package UniversitySystemGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomOutputStream extends OutputStream
{
	private JTextArea textArea;

	public CustomOutputStream(JTextArea textArea)
	{
		this.textArea = textArea;
	}

	@Override
	public void write(int b) throws IOException
	{
		// textArea.setText(textArea.getText() + String.valueOf((char) b));
		textArea.append(String.valueOf((char) b));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	public static void main(String Title)
	{
		JFrame student_record_frame = new JFrame(Title);
		student_record_frame.setSize(450, 350);
		student_record_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea textArea = new JTextArea(50, 40);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.green);
		Font f = new Font("Consolas", Font.PLAIN, 12);
		textArea.setFont(f);

		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);

		JScrollPane scroll_panel = new JScrollPane(textArea);
		scroll_panel.setBackground(Color.darkGray);

		student_record_frame.add(scroll_panel);
		student_record_frame.setLocation(new Point(500, 300));
		student_record_frame.setVisible(true);
	}
}
