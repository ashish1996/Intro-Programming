package a8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
// Widget for the Pixel Inspector Tool
public class PixelInspectorWidget extends JPanel implements MouseListener, MouseMotionListener {

	private PictureView picView;
	private Picture p;
	private Pixel currentPixel;

	private JPanel infoPanel;
	private JPanel coordinateData;
	private JPanel pixelValueData;
	private JPanel pixelVisual;

	private JLabel xCoord;
	private JLabel yCoord;
	private JLabel redLabel;
	private double redValue;
	private JLabel greenLabel;
	private double greenValue;
	private JLabel blueLabel;
	private double blueValue;
	private JLabel intensityLabel;

	private JPanel pixelRepresenter;
	private JPanel pixelFollower;
	private Color hoverColor;
	private Color selectedColor;

	public PixelInspectorWidget(Picture p) {
		setLayout(new BorderLayout());

		this.p = p;

		picView = new PictureView(p.createObservable());
		picView.addMouseListener(this);
		picView.addMouseMotionListener(this);
		add(picView, BorderLayout.CENTER);

		//The infoPanel holds 2 elements: the x and y value and rgb/brightness.

		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(6,1));

		//X, Y values
		coordinateData = new JPanel();
		coordinateData.setLayout(new GridLayout(2,1));
		xCoord = new JLabel("X: "+0);
		coordinateData.add(xCoord);
		yCoord = new JLabel("Y: "+0);
		coordinateData.add(yCoord);
		infoPanel.add(coordinateData);

		//RGB, BRIGHTNESS
		pixelValueData = new JPanel();
		pixelValueData.setLayout(new GridLayout(4,1));
		redLabel = new JLabel("Red: "+0);
		pixelValueData.add(redLabel);
		greenLabel = new JLabel("Green: "+0);
		pixelValueData.add(greenLabel);
		blueLabel = new JLabel("Blue: "+0);
		pixelValueData.add(blueLabel);
		intensityLabel = new JLabel("Brightness: "+0.0000);
		pixelValueData.add(intensityLabel);
		infoPanel.add(pixelValueData);

		pixelVisual = new JPanel();
		pixelVisual.setLayout(new GridLayout(2,0));
		pixelFollower = new JPanel();
		hoverColor = new Color(255, 255, 255);
		pixelFollower.setBackground(hoverColor);
		pixelVisual.add(pixelFollower);
		pixelRepresenter = new JPanel();
		selectedColor = new Color(0, 0, 0);
		pixelRepresenter.setBackground(selectedColor);
		pixelVisual.add(pixelRepresenter);

		add(infoPanel, BorderLayout.WEST);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() == picView) {
			selectedColor = new Color(A8Helper.pixelToRGB(p.getPixel(e.getX(), e.getY())));
			pixelRepresenter.setBackground(selectedColor);

			xCoord.setText("X: "+e.getX());
			yCoord.setText("Y: "+e.getY());

			currentPixel = p.getPixel(e.getX(), e.getY());

			redValue = (new Color(A8Helper.pixelToRGB(currentPixel)).getRed())/255.0;
			redLabel.setText("Red: "+String.format("%.3f", redValue));
			greenValue = (new Color(A8Helper.pixelToRGB(currentPixel)).getGreen())/255.0;
			greenLabel.setText("Green: "+String.format("%.3f", greenValue));
			blueValue = (new Color(A8Helper.pixelToRGB(currentPixel)).getBlue())/255.0;
			blueLabel.setText("Blue: "+String.format("%.3f", blueValue));
			intensityLabel.setText("Brightness: "+String.format("%.4f", currentPixel.getIntensity()));
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
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//Just for showing the color we are hovering over...
		if (e.getX()<p.getWidth() && e.getY()<p.getHeight()) {
			hoverColor = new Color(A8Helper.pixelToRGB(p.getPixel(e.getX(), e.getY())));
			pixelFollower.setBackground(hoverColor);
		}
	}

}