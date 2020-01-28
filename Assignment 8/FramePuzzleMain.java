package a8;

// Main Method for implementing the Frame Puzzle Tool
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePuzzleMain {

	public static void main(String[] args) throws IOException {
		Picture p = A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		FramePuzzleWidget f = new FramePuzzleWidget(p);
		
		JFrame main_frame = new JFrame(); // Creates frame
		main_frame.setTitle("Assignment 8 Frame Puzzle");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top_panel = new JPanel();  // Creates panel with puzzle in it
		top_panel.setLayout(new BorderLayout());
		top_panel.add(f, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}
	
}