import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
	public static void main(String[] args) {
		int size = 4, buttonSize = 100;
		int reqSize = size * buttonSize;
		Grid grid = new Grid(size, buttonSize);

		JFrame frame = new JFrame("Slide Puzzle");
		frame.setSize(reqSize, reqSize + 25);

		grid.draw(frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);

	}
}
