package a8;

import java.awt.Color;

import javax.swing.BorderFactory;

// Keeps track of x and y values of PictureView components in the FramePuzzleWidget...


public class PuzzleTracker extends PictureView {

	private int x;
	private int y;
	private ObservablePicture obsP;

	public PuzzleTracker(ObservablePicture obsP, int x, int y) {
		super(obsP);
		this.obsP = obsP;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public ObservablePicture getObsPic() {
		return this.obsP;
	}

}
