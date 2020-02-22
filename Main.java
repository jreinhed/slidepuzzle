import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
	public static void main(String[] args) {
		int size = 4, buttonSize = 100;
		int reqSize = size * buttonSize;

		JFrame frame = new JFrame("Slide Puzzle");
		Grid grid = new Grid(frame, size, buttonSize);
		frame.setSize(reqSize, reqSize + 25);

		grid.draw(frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);

	}
}
