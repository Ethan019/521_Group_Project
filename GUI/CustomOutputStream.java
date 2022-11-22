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
	private JTextArea text_area;
	private boolean is_editable;

	public CustomOutputStream(JTextArea text_area, boolean is_editable)
	{
		this.text_area = text_area;
		this.is_editable = is_editable;
	}

	@Override
	public void write(int b) throws IOException
	{
		// textArea.setText(textArea.getText() + String.valueOf((char) b));
		text_area.append(String.valueOf((char) b));
		text_area.setCaretPosition(text_area.getDocument().getLength());

		text_area.setEditable(is_editable);
		// text_area.setEnabled(is_editable);
	}

	public static void main(String Title, boolean is_editable)
	{
		JFrame student_record_frame = new JFrame(Title);
		student_record_frame.setSize(450, 350);
		student_record_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea textArea = new JTextArea(50, 40);
		textArea.setBackground(Color.GRAY);
		textArea.setForeground(Color.BLACK);
		Font f = new Font("Consolas", Font.PLAIN, 12);
		textArea.setFont(f);

		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea, is_editable));
		System.setOut(printStream);
		System.setErr(printStream);

		JScrollPane scroll_panel = new JScrollPane(textArea);
		scroll_panel.setBackground(Color.darkGray);

		student_record_frame.add(scroll_panel);
		student_record_frame.setLocation(new Point(500, 300));
		student_record_frame.setVisible(true);
	}
}
