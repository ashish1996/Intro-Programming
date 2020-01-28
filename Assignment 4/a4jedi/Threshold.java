package a4jedi;

public class Threshold implements PixelTransformation{
	private double threshold;
	
	public Threshold (double threshold) {
		this.threshold=threshold;
		
	}
	
	public Pixel transform (Pixel p) {
		if (p.getIntensity() > threshold) {
			GrayPixel WhitePixelTransformed = new GrayPixel(1.0);
			return WhitePixelTransformed;
		}
		else {
			GrayPixel BlackPixelTransformed = new GrayPixel(0.0);
			return BlackPixelTransformed;
		}
	}
}
