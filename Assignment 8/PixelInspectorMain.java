package a8;
// Main method for implementing the pixel inspector tool
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelInspectorMain {

	public static void main(String[] args) throws IOException {
		Picture p = A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		PixelInspectorWidget w = new PixelInspectorWidget(p);
		// Creates outer frame
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 8 Pixel Inspector");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creates panel for new settings
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(w, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}
	
}
