import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
	public static void main(String[] args) {
		Grid grid = new Grid(4, 100);

		JFrame frame = new JFrame("Game");

		grid.draw(frame);

		frame.setSize(1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);

	}
}
