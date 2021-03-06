// Copyright (c) 2020 Johan Reinhed <jreinhed@protonmail.com>
// 
// Permission to use, copy, modify, and/or distribute this software for any
// purpose with or without fee is hereby granted, provided that the above
// copyright notice and this permission notice appear in all copies.
// 
// THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
// WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
// ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
// WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
// ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
// OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Grid implements ActionListener {
	private JButton[] button;
	private int size;
	private int clicks;
	private String buttonOrder;
	private String correctOrder;
	private JFrame frame;

	public Grid(JFrame caller, int newSize, int buttonSize) {
		frame = caller;
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

		int x = 0;
		int y = 0;
		int count = 0;
		int n = 0;

		for (JButton b : button) {
			b.setBounds(x, y, buttonSize, buttonSize);
			x += buttonSize;
			count++;

			if (count % newSize == 0) {
				y += buttonSize;
				x = 0;
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
		if (button[i + offset].getText() == "") {
			button[i + offset].setText(button[i].getText());
			button[i].setText("");
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		int sideSize = (int) Math.sqrt(size); // Size of one side

		for (int i = 0; i < size; i++) {
			if (obj == button[i]) {
				buttonOrder = "";
				clicks++;

				// Horizontal
				// FIXME: A square at the end of one line
				// should not be treated as "adjacent"
				// to a square at the beginning of the
				// next line.
				if (i > 0) {
					switchButtons(button, i, -1);
				}
				if (i < size - 1) {
					switchButtons(button, i, 1);
				}

				// Vertical
				if (i >= sideSize) {
					switchButtons(button, i, -sideSize);
				}
				if (i < size - sideSize) {
					switchButtons(button, i, sideSize);
				}

				break;
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
		String winString = "Congratulations! You won after " + clicks + " clicks.";
		if (clicks < 0) {
			winString += "\n\nWait... " + clicks + "?\n";
			winString += "What did you do?";
		}

		JOptionPane.showMessageDialog(frame, winString);
		System.exit(0);
	}

	public void draw(JFrame frame) {
		for (JButton b : button) {
			frame.add(b);
		}
	}
}
