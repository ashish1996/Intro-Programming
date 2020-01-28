package a8;

import java.awt.AWTException;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
// Widget for creating the FramePuzzle Tool
public class FramePuzzleWidget extends JPanel implements MouseListener, KeyListener {

	private PuzzleTracker[][] picViewGrid;
	private PuzzleTracker clicked;
	private Picture p;
	private JPanel gridContainer;
	private JPanel blankTile;
	private int pictureWidth;
	private int pictureHeight;
	private int pieceWidth;
	private int pieceHeight;
	private static final int PUZZLE_WIDTH = 5; 
	private static final int PUZZLE_HEIGHT = 5; 
	private static final Color BLANK_TILE_COLOR = Color.GREEN;

	public FramePuzzleWidget(Picture p) {
		setLayout(new BorderLayout());

		this.p = p;

		//Empty Space JPanel
		blankTile = new JPanel();
		blankTile.setBackground(BLANK_TILE_COLOR);

		renderPuzzle();

		this.setFocusable(true);
		this.addKeyListener(this);
	}

	private void renderPuzzle() {// Creates the layout of the puzzle
		if (picViewGrid == null) {

			//HOLD TILES
			gridContainer = new JPanel(new GridLayout(PUZZLE_HEIGHT, PUZZLE_WIDTH));
			gridContainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); //Just for show
			gridContainer.setBackground(Color.GRAY);

			//WIDTH AND HEIGHT TO BE DIVISIBLE BY FIVE
			pictureWidth = p.getWidth() - (p.getWidth() % (int)(p.getWidth()/(double)PUZZLE_WIDTH));
			pictureHeight = p.getHeight() - (p.getHeight() % (int)(p.getHeight()/(double)PUZZLE_HEIGHT));

			//SIZE OF THE TILES
			pieceWidth = pictureWidth / PUZZLE_WIDTH;
			pieceHeight = pictureHeight / PUZZLE_HEIGHT;

			//FILLS THE GRID  WITH SUBPICTURES OF THE PICTURE,
			//FILLS THE LAST SLOT WITH THE BLANK TILE
			picViewGrid = new PuzzleTracker[PUZZLE_WIDTH][PUZZLE_HEIGHT];
			for (int j=0; j<PUZZLE_HEIGHT; j++) {
				for (int i=0; i<PUZZLE_WIDTH; i++) {
					if (i==PUZZLE_WIDTH-1 && j==PUZZLE_HEIGHT-1) {
						gridContainer.add(blankTile);
						break;
					}
					picViewGrid[i][j] = new PuzzleTracker(p.extract(i*pieceWidth, 
							j*pieceHeight, pieceWidth, pieceHeight).createObservable(), i, j);
					picViewGrid[i][j].addMouseListener(this);
					gridContainer.add(picViewGrid[i][j]);
				}
			}
			add(gridContainer);

		} else {

			gridContainer.removeAll();

			//REFILLS THE GRID 
			for (int j=0; j<PUZZLE_HEIGHT; j++) {
				for (int i=0; i<PUZZLE_WIDTH; i++) {
					if (picViewGrid[i][j] != null) {
						gridContainer.add(picViewGrid[i][j]);
						picViewGrid[i][j].addMouseListener(this);
					} else {
						gridContainer.add(blankTile);
					}
				}
			}
			gridContainer.revalidate();
			gridContainer.repaint();
			this.add(gridContainer);
		}


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clicked = (PuzzleTracker) e.getSource();

		int x = clicked.getX();
		int y = clicked.getY();

		//Shifts the blank tile to the clicked tile 

		if (x < PUZZLE_WIDTH-1 && nullIsToRight(x, y)) {
			while (picViewGrid[x][y] != null) {
				simulateKeyRelease('R', getNullX(), getNullY());
			}
			return;
		}
		if (x > 0 && nullIsToLeft(x, y)) {
			while (picViewGrid[x][y] != null) {
				simulateKeyRelease('L', getNullX(), getNullY());
			}
			return;
		}
		if (y < PUZZLE_HEIGHT-1 && nullIsBelow(y, x)) {
			while (picViewGrid[x][y] != null) {
				simulateKeyRelease('D', getNullX(), getNullY());
			}
			return;
		}
		if (y > 0 && nullIsAbove(y, x)) {
			while (picViewGrid[x][y] != null) {
				simulateKeyRelease('U', getNullX(), getNullY());
			}
			return;
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int x = 0;
		int y = 0;

		//LOCATION OF THE BLANK TILE
		for (int i=0; i<PUZZLE_WIDTH; i++) {
			for (int j=0; j<PUZZLE_HEIGHT; j++) {
				if (picViewGrid[i][j] == null) {
					x = i;
					y = j;
					break;
				}
			}
		}

		try {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_KP_RIGHT) {
				picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x+1][y].getObsPic(), x, y);
				picViewGrid[x+1][y] = null;
				renderPuzzle();
				return;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_KP_LEFT) {
				picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x-1][y].getObsPic(), x, y);
				picViewGrid[x-1][y] = null;
				renderPuzzle();
				return;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_KP_UP) {
				picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x][y-1].getObsPic(), x, y);
				picViewGrid[x][y-1] = null;
				renderPuzzle();
				return;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_KP_DOWN) {
				picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x][y+1].getObsPic(), x, y);
				picViewGrid[x][y+1] = null;
				renderPuzzle();
				return;
			}
		} catch (ArrayIndexOutOfBoundsException e1) {

		}
	}

	private void simulateKeyRelease(char direction, int x, int y) {
		if (direction == 'L') {
			picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x+1][y].getObsPic(), x, y);
			picViewGrid[x+1][y] = null;
			renderPuzzle();
			return;
		}
		if (direction == 'R') {
			picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x-1][y].getObsPic(), x, y);
			picViewGrid[x-1][y] = null;
			renderPuzzle();
			return;
		}
		if (direction == 'D') {
			picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x][y-1].getObsPic(), x, y);
			picViewGrid[x][y-1] = null;
			renderPuzzle();
			return;
		}
		if (direction == 'U') {
			picViewGrid[x][y] = new PuzzleTracker(picViewGrid[x][y+1].getObsPic(), x, y);
			picViewGrid[x][y+1] = null;
			renderPuzzle();
			return;
		}
	}

	private boolean nullIsToRight(int start, int y) {
		for (int x=start+1; x<PUZZLE_WIDTH; x++) {
			if (picViewGrid[x][y] == null) {
				return true;
			}
		}
		return false;
	}

	private boolean nullIsToLeft(int start, int y) {
		for (int x=start; x>=0; x--) {
			if (picViewGrid[x][y] == null) {
				return true;
			}
		}
		return false;
	}

	private boolean nullIsBelow(int start, int x) {
		for (int y=start; y<PUZZLE_HEIGHT; y++) {
			if (picViewGrid[x][y] == null) {
				return true;
			}
		}
		return false;
	}

	private boolean nullIsAbove(int start, int x) {
		for (int y=start; y>=0; y--) {
			if (picViewGrid[x][y] == null) {
				return true;
			}
		}
		return false;
	}

	private int getNullX() {
		for (int x=0; x<PUZZLE_WIDTH; x++) {
			for (int y=0; y<PUZZLE_HEIGHT; y++) {
				if (picViewGrid[x][y] == null) {
					return x;
				}
			}
		}
		return 0;
	}

	private int getNullY() {
		for (int x=0; x<PUZZLE_WIDTH; x++) {
			for (int y=0; y<PUZZLE_HEIGHT; y++) {
				if (picViewGrid[x][y] == null) {
					return y;
				}
			}
		}
		return 0;
	}



}