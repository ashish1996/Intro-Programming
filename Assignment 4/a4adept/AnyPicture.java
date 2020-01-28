package a4adept;

public abstract class AnyPicture implements Picture {
	
	
		private int width;
		private int height;
		private Pixel image [][];
		
		
		public AnyPicture(int width, int height) {
			if (width < 0) {
				throw new IllegalArgumentException("width can't be negative");
			}
			if (height < 0) {
				throw new IllegalArgumentException("Height can't be negative");
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
			if (p == null) {
				throw new RuntimeException ( "null");
			}
			image[x][y] = p;
			
		}
	
		public Pixel getPixel(int x, int y) {
			return image[x][y];
		}
		
		public int countRange(double low, double high) {
			int pixelCounter = 0;
			for (int i = 0; i<width; i++) {
				for (int j = 0; j<height; j++)
				if (image[i][j].getIntensity() >= low && image[i][j].getIntensity()<= high) {
					pixelCounter = pixelCounter + 1;
				}
			}
			return pixelCounter;
		}
		
		public void print() {
			for (int i = 0; i<height; i++) {
				for ( int j=0; j<width; j++) {
				System.out.print(image[j][i].getChar());
					
				}
				System.out.println();
		}
		}
		 public SubPictureImpl extract(int xOffset, int yOffset, int width, int height) {
			  SubPictureImpl anotherSub = new SubPictureImpl(this, xOffset, yOffset, width, height);
			  return anotherSub;
			 }

		}


