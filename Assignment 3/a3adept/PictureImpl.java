package a3adept;

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
}
