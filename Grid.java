import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Grid implements ActionListener {
	private JButton[] button;
	private int size;
	private int clicks;
	private String correctOrder;

	public Grid(int newSize, int buttonSize) {
		clicks = 0;
		size = newSize * newSize;
		button = new JButton[size];
		correctOrder = "";
		
		for (int i = 1; i < size; i++) {
			correctOrder += i + " ";
		}
		correctOrder += " ";

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
		}

		UniqueRNG urng = new UniqueRNG(size);
		Integer[] integers = urng.getNumList();

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

			// We only want numbers in the range [1, size)
			if (integers[n] == size) {
				b.setText("");
			} else {
				b.setText(integers[n].toString());
			}

			n++;
			b.addActionListener(this);
		}
	}

	private void switchButtons(JButton[] buttons, int i, int offset) {
		if (button[i+offset].getText() == "") {
			button[i+offset].setText(button[i].getText());
			button[i].setText("");
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String buttonOrder = "";
		int sideSize = (int) Math.sqrt(size); // Size of one side

		for (int i = 0; i < size; i++) {
			if (obj == button[i]) {
				clicks++;

				// Horizontal
				if (i > 0) {
					switchButtons(button, i, -1);
					break;
				}

				if (i < size - 1) {
					switchButtons(button, i, 1);
					break;
				}

				// Vertical
				if (i >= sideSize) {
					switchButtons(button, i, -sideSize);
					break;
				}

				if (i < size - sideSize) {
					switchButtons(button, i, sideSize);
					break;
				}
			}
		}

		for (JButton b : button) {
			buttonOrder += b.getText() + " ";
		}

		if (buttonOrder.equals(correctOrder)) {
			win();
		}
	}

	private void win() {
		System.out.println("Congratulations! You won after " + clicks + " clicks.");

		if (clicks < 0) {
			System.out.println("Wait... " + clicks + "?");
			System.out.println("What did you do?");
		}

		System.exit(0);
	}

	public void draw(JFrame frame) {
		for (JButton b : button) {
			frame.add(b);
		}
	}
}
