package a8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
// Widget for the Image Adjuster Tool
public class ImageAdjusterWidget extends JPanel implements ChangeListener {

	private PictureView picView;
	private Picture picture;
	private Picture output;

	private JPanel infoPanel;

	private JPanel blur;
	private JSlider blurSlider;
	private JLabel blurLabel;

	private JPanel intensity;
	private JSlider intensitySlider;
	private JLabel intensityLabel;

	private JPanel saturation;
	private JSlider saturationSlider;
	private JLabel saturationLabel;

	public ImageAdjusterWidget(Picture p) {
		setLayout(new BorderLayout());

		picture = p;
		picView = new PictureView(p.createObservable());
		add(picView, BorderLayout.EAST);

		infoPanel = new JPanel(); // creates infopanel
		infoPanel.setLayout(new GridLayout(3,1));

		blur = new JPanel();// creates blur tool
		blur.setLayout(new FlowLayout());
		blurLabel = new JLabel("Blur: ");
		blur.add(blurLabel);
		blurSlider = new JSlider();
		blurSlider.setValue(0);
		blurSlider.setMinimum(0);
		blurSlider.setMaximum(5);
		blurSlider.setMajorTickSpacing(1);
		blurSlider.setSnapToTicks(true);
		blurSlider.setPaintTicks(true);
		blurSlider.setPaintLabels(true);
		blurSlider.addChangeListener(this);
		blur.add(blurSlider);
		infoPanel.add(blur);

		saturation = new JPanel();// creates saturation tool
		saturation.setLayout(new FlowLayout());
		saturationLabel = new JLabel("Saturation: ");
		saturation.add(saturationLabel);
		saturationSlider = new JSlider();
		saturationSlider.setValue(0);
		saturationSlider.setMinimum(-100);
		saturationSlider.setMaximum(100);
		saturationSlider.setMajorTickSpacing(25);
		saturationSlider.setMinorTickSpacing(5);
		saturationSlider.setSnapToTicks(false);
		saturationSlider.setPaintTicks(true);
		saturationSlider.setPaintLabels(true);
		saturationSlider.addChangeListener(this);
		saturation.add(saturationSlider);
		infoPanel.add(saturation);

		intensity = new JPanel(); // creates intensity tool
		intensity.setLayout(new FlowLayout());
		intensityLabel = new JLabel("Brightness: ");
		intensity.add(intensityLabel);
		intensitySlider = new JSlider();
		intensitySlider.setValue(0);
		intensitySlider.setMinimum(-100);
		intensitySlider.setMaximum(100);
		intensitySlider.setMajorTickSpacing(25);
		intensitySlider.setMinorTickSpacing(5);
		intensitySlider.setSnapToTicks(false);
		intensitySlider.setPaintTicks(true);
		intensitySlider.setPaintLabels(true);
		intensitySlider.addChangeListener(this);
		intensity.add(intensitySlider);
		infoPanel.add(intensity);

		add(infoPanel, BorderLayout.SOUTH);
	}
	// indicates if anything is changed and communicates it from and to slider
	@Override
	public void stateChanged(ChangeEvent e) {
		output = new PictureImpl(picture.getWidth(), picture.getHeight());

		//Resets the output image
		initializeOutput();

		blurImage(blurSlider.getValue());
		saturateImage(saturationSlider.getValue());
		brightenImage(intensitySlider.getValue());

		picView.setPicture(output.createObservable());
		add(picView);
	}
	// blurs the image
	private void blurImage(int blurAmount) {
		if (blurAmount == 0) {
			return;
		}
		int pixelsInBlurredRegion = 0;
		double redSum = 0;
		double greenSum = 0;
		double blueSum = 0;
		Pixel avg;
		Picture p = output;

		for (int x=0; x<p.getWidth(); x++) {
			for (int y=0; y<p.getHeight(); y++) {
				for (int i=x-blurAmount; i<=x+blurAmount; i++) {
					for (int j=y-blurAmount; j<=y+blurAmount; j++) {
						if (i<p.getWidth() && i>=0 && j<p.getHeight() && j>=0 && !(i==x && j==y)) {
							redSum += p.getPixel(i, j).getRed();
							greenSum += p.getPixel(i, j).getGreen();
							blueSum += p.getPixel(i, j).getBlue();
							pixelsInBlurredRegion++;
						}
					}
				}
				avg = new ColorPixel(redSum/pixelsInBlurredRegion, greenSum/pixelsInBlurredRegion, 
						blueSum/pixelsInBlurredRegion);
				output.setPixel(x, y, avg);
				redSum = 0;
				greenSum = 0;
				blueSum = 0;
				pixelsInBlurredRegion = 0;
			}
		}
	}
	// saturates the image
	private void saturateImage(int saturateAmount) {
		double red;
		double green;
		double blue;
		double mostIntensePixel = 0;
		for (int x=0; x<output.getWidth(); x++) {
			for (int y=0; y<output.getHeight(); y++) {
				if (saturateAmount < 0) {
					red = output.getPixel(x, y).getRed() * (1.0 + (saturateAmount / 100.0) ) - 
							(output.getPixel(x, y).getIntensity() * saturateAmount / 100.0);
					green = output.getPixel(x, y).getGreen() * (1.0 + (saturateAmount / 100.0) ) - 
							(output.getPixel(x, y).getIntensity() * saturateAmount / 100.0);
					blue = output.getPixel(x, y).getBlue() * (1.0 + (saturateAmount / 100.0) ) - 
							(output.getPixel(x, y).getIntensity() * saturateAmount / 100.0);
					output.setPixel(x, y, new ColorPixel(red, green, blue));
				} else if (saturateAmount > 0) {
					if (output.getPixel(x, y).getRed() >= output.getPixel(x, y).getGreen()) {
						if (output.getPixel(x, y).getRed() >= output.getPixel(x, y).getBlue() && 
								output.getPixel(x, y).getRed() > 0) {
							mostIntensePixel = output.getPixel(x, y).getRed();
						} else if (output.getPixel(x, y).getBlue() > 0) {
							mostIntensePixel = output.getPixel(x, y).getBlue();
						}
					} else if (output.getPixel(x, y).getRed() < output.getPixel(x, y).getGreen()){
						if (output.getPixel(x, y).getGreen() >= output.getPixel(x, y).getBlue() && 
								output.getPixel(x, y).getGreen() > 0) {
							mostIntensePixel = output.getPixel(x, y).getGreen();
						} else if (output.getPixel(x, y).getBlue() > 0) {
							mostIntensePixel = output.getPixel(x, y).getBlue();
						}
					}

					if (Math.abs(mostIntensePixel) < .00001)  {
						continue;
					}

					red = output.getPixel(x, y).getRed() * ((mostIntensePixel + ((1.0 - mostIntensePixel) * 
							(saturateAmount / 100.0))) / mostIntensePixel);
					green = output.getPixel(x, y).getGreen() * ((mostIntensePixel + ((1.0 - mostIntensePixel) * 
							(saturateAmount / 100.0))) / mostIntensePixel);
					blue = output.getPixel(x, y).getBlue() * ((mostIntensePixel + ((1.0 - mostIntensePixel) * 
							(saturateAmount / 100.0))) / mostIntensePixel);
					output.setPixel(x, y, new ColorPixel(red, green, blue));
				}
			}
		}
	}
	// brightens the image
	private void brightenImage(int brightenAmount) {
		double red;
		double green;
		double blue;
		Picture p = output;
		for (int x=0; x<p.getWidth(); x++) {
			for (int y=0; y<p.getHeight(); y++) {
				if (brightenAmount < 0) {
					red = p.getPixel(x, y).getRed()+(brightenAmount/100.0*(p.getPixel(x, y).getRed()));
					green = p.getPixel(x, y).getGreen()+(brightenAmount/100.0*(p.getPixel(x, y).getGreen()));
					blue = p.getPixel(x, y).getBlue()+(brightenAmount/100.0*(p.getPixel(x, y).getBlue()));
				} else {
					red = p.getPixel(x, y).getRed()+(brightenAmount/100.0*(1-p.getPixel(x, y).getRed()));
					green = p.getPixel(x, y).getGreen()+(brightenAmount/100.0*(1-p.getPixel(x, y).getGreen()));
					blue = p.getPixel(x, y).getBlue()+(brightenAmount/100.0*(1-p.getPixel(x, y).getBlue()));
				}
				output.setPixel(x, y, new ColorPixel(red, green, blue));
			}
		}
	}
	// produces the intial output
	private void initializeOutput() {
		for (int x=0; x<picture.getWidth(); x++) {
			for (int y=0; y<picture.getHeight(); y++) {
				output.setPixel(x, y, picture.getPixel(x, y));
			}
		}
	}

}
