package a3jedi;

public class ColorPixel implements Pixel {
	private double red;
	private double green;
	private double blue;
	
	
	public ColorPixel(double red, double green, double blue) {
		this.red = red;
		this.green=green;
		this.blue = blue;
		if (red<0.0 || red>1.0) {
			throw new RuntimeException("Explanation string");
		}
		if (blue<0.0 || blue>1.0) {
			throw new RuntimeException("Explanation string");
		}
		if (green<0.0 || green>1.0) {
			throw new RuntimeException("Explanation string");
		}
}
	
	public double getRed() {
		return red;
	}
	
	public double getGreen() {
		return green;
	}

	public double getBlue() {
		return blue;
	}
	
	public double getIntensity() {
		double intensity = 0.299 * red + 0.587 * green + 0.114 * blue;
		return intensity;
	}

	public char getChar() {
		char[] charList = {'#','M','X','D','<','>','s',':','-',' '};
		if (getIntensity()>=0.0 && getIntensity()<0.10) {
			return charList[0];
		}
		else if(getIntensity()>=0.1 && getIntensity()<0.2) {
			return charList[1];
		}
		else if(getIntensity()>=0.2 && getIntensity()<0.3) {
			return charList[2];
		}
		else if(getIntensity()>=0.3 && getIntensity()<0.4) {
			return charList[3];
		}
		else if(getIntensity()>=0.4 && getIntensity()<0.5) {
			return charList[4];
		}
		else if(getIntensity()>=0.5 && getIntensity()<0.6) {
			return charList[5];
		}
		else if(getIntensity()>=0.6 && getIntensity()<0.7) {
			return charList[6];
		}
		else if(getIntensity()>=0.7 && getIntensity()<0.8) {
			return charList[7];
		}else if(getIntensity()>=0.8 && getIntensity()<0.9) {
			return charList[8];
		}else {
			return charList[9];
		}
	}
	
	public Pixel blend( Pixel p, double weight) {
		if (weight<0.0 || weight>1.0 || p==null) {
			throw new RuntimeException("Explanation string");
		}
		
		return new ColorPixel((red*weight) + (p.getRed()*(1-weight)), (green*weight) + (p.getGreen()*(1-weight)), (blue*weight) + (p.getBlue()*(1-weight))); 
	
	}
	
	public Pixel lighten(double factor){
		if (factor<0.0 || factor>1.0) {
			throw new RuntimeException("Explanation string");
		}
		Pixel WhitePixel = new ColorPixel(1.0, 1.0, 1.0);
		return WhitePixel.blend(this, factor);	
	}
	
	public Pixel darken(double factor){
		if (factor<0.0 || factor>1.0) {
			throw new RuntimeException("Explanation string");
		}
		Pixel BlackPixel = new ColorPixel(0, 0, 0);
		return BlackPixel.blend(this, factor);
	}
	
	public boolean equals(Pixel p) {
		if(p==null) {
			throw new RuntimeException("pixel can't be null");
		}
		double currentPixelIntensity = this.getIntensity();
		double inputPixelIntensity = p.getIntensity();
		double brightestPixelIntensity;
		if (currentPixelIntensity>inputPixelIntensity) {
			 brightestPixelIntensity = currentPixelIntensity;
		} else {brightestPixelIntensity = inputPixelIntensity;} 
		double tenPercentBrightestPixel = 0.1*brightestPixelIntensity;
		double redDifference = Math.abs(this.getRed()-p.getRed());
		double greenDifference = Math.abs(this.getGreen()-p.getGreen());
		double blueDifference = Math.abs(this.getBlue()-p.getBlue());
		if (redDifference<tenPercentBrightestPixel && greenDifference<tenPercentBrightestPixel && blueDifference < tenPercentBrightestPixel) {
			return true;
		} 
		else {
			return false;
		}
		}

		
	}


