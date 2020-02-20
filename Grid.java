import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Grid implements ActionListener {
	private JButton[] button;
	private int size;

	public Grid(int newSize, int buttonSize) {
		size = newSize * newSize;
		button = new JButton[size];

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
		}

		UniqueRNG urng = new UniqueRNG(size);
		Integer[] i = urng.getNumList();
		int x = buttonSize;
		int y = buttonSize;
		int count = 0;

		int n = 0;

		for (JButton b : button) {
			b.setBounds(x, y, buttonSize, buttonSize);
			x += buttonSize;
			count++;

			if (count % newSize == 0) {
				y += buttonSize;
				x = buttonSize;
			}

			b.setText(i[n].toString());
			n++;
			b.addActionListener(this);
		}

		button[size - 1].setText("");
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		for (JButton b : button) {
			if (obj == b) {
				System.out.println("This one!");
				break;
			}
		}
	}

	public void draw(JFrame frame) {
		for (JButton b : button) {
			frame.add(b);
		}
	}
}
