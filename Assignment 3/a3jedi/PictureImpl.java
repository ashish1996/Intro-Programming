package a3jedi;

public class PictureImpl implements Picture {
	private int width;
	private int height;
	private Pixel image[][];
	
	
	public PictureImpl(int width, int height) {
		if (width<=0 || height<=0) {
			throw new RuntimeException("width and height must be positive");
		}
		
		image = new Pixel[width][height];
		this.width = width;
		this.height = height;
		
		for (int i = 0; i<width; i++) {
			for (int j = 0; j<height; j++) {
				image [i][j] = new ColorPixel(0.5, 0.5, 0.5);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setPixel(int x, int y, Pixel p) {
		if (x<0 || y<0 || x>width || y>height || p==null){
			throw new RuntimeException("X and Y must be positive and be contained in picture");
		}
		image[x][y]=p;	
	}


	public Pixel getPixel(int x, int y) {
		if (x<0 || y<0 || x>width || y>height){
			throw new RuntimeException("X and Y must be positive and be contained in picture");
		}
		return image[x][y];
		
	}

	public int countRange(double low, double high) {
		if (low<0 || high<0) {
			throw new RuntimeException("low and high must be positive");
		}
		int counter=0;
		for( int i=0 ; i<width;i++) {
			for (int j = 0; j<height; j++) {
				if (image[i][j].getIntensity() >=low && image[i][j].getIntensity()<=high) {
					counter = counter + 1;
				}
			}
		}
		return counter;
	}

	public void print() {
		for (int i = 0; i<height; i++) {
			for ( int j=0; j<width; j++) {
			System.out.print(image[j][i].getChar());
				
			}
			System.out.println();
	}

}

	@Override
	public double unequalPixelRatio(Picture p) {
		if(this.getHeight()!=p.getHeight() || this.getWidth()!=p.getWidth() || p==null || this==null) {
			throw new RuntimeException("pictures aren't equal in size");
		}
		int totalPixels = this.getHeight()*this.getWidth();
		int pixelUnequalCounter = 0;
		for(int i=0; i<this.getWidth(); i++) {
			for(int j=0; j<this.getHeight(); j++) {
				if(p.getPixel(j,i).equals(this.getPixel(j,i))==false) {
					pixelUnequalCounter = pixelUnequalCounter +1;
				}
			}
		}
		double pixelProportion = (double) pixelUnequalCounter/(double) totalPixels;
		return pixelProportion;
	}

	@Override
	public double calculatePSNR(Picture p) {
		if(this.getHeight()!=p.getHeight() || this.getWidth()!=p.getWidth()) {
			throw new RuntimeException("pictures aren't equal in size");
		}
		
		if (this.getHeight() != p.getHeight() || this.getWidth() != p.getWidth()){
			throw new RuntimeException ("error");
		}
		if (p == this) {
			throw new RuntimeException ("error");
		}
		double max = 1.0;
		double squaredDifferencesArray[][]= new double[this.getWidth()][this.getHeight()];
		for (int i=0; i<this.getHeight(); i++) {
			for (int j=0; j<this.getWidth(); j++) {
				double initialDifference = p.getPixel(j,i).getIntensity()-this.getPixel(j,i).getIntensity();
				double initialDifferenceSquared = initialDifference*initialDifference;
				squaredDifferencesArray[j][i] = initialDifferenceSquared;
			}
		}
		
		double arraySum= 0;
		for (int i=0; i<this.getWidth(); i++) {
			for (int j=0; j<this.getHeight(); j++) {
				arraySum = arraySum + squaredDifferencesArray[i][j];
			}
		}
		double mse = arraySum/(this.getWidth()*this.getHeight());
		double PSNR = 20*Math.log10(max) - 10*Math.log10(mse);
		return PSNR;
	}
}
