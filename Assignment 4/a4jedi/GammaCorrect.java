package a4jedi;

public class GammaCorrect implements PixelTransformation  {
	private double gamma;
	
	
	public GammaCorrect (double gamma) {
		
		this.gamma = gamma;
		
	}
	
	public Pixel transform(Pixel p) {
		double correctedRed = Math.pow(p.getRed(), (1.0/gamma));
		double correctedBlue = Math.pow(p.getBlue(), (1.0/gamma));
		double correctedGreen = Math.pow(p.getGreen(), (1.0/gamma));
		ColorPixel gammaCorrectedPixel = new ColorPixel(correctedRed, correctedGreen,correctedBlue);
		return gammaCorrectedPixel;
	}

}
