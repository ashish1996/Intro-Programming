package a4jedi;

public class SubPictureImpl extends AnyPicture implements SubPicture {
	private int xOffset;
	private Picture source;
	private int yOffset;
	private int width;
	private int height;

	
	
	
	
	public SubPictureImpl(Picture source, int xOffset, int yOffset, int width, int height) {
		super(width,height);
		this.width = super.getWidth();
		this.height = super.getHeight();
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.source = source;
		
		if (source == null) {
			throw new IllegalArgumentException("Result from getSource() does not match source picture");
		}
		
		if (xOffset > Validate.validatePicture(source).getWidth() && xOffset<0) {
			throw new IllegalArgumentException("width is not in bounds");
		}
		if (yOffset > Validate.validatePicture(source).getWidth() && yOffset<0) {
			throw new IllegalArgumentException("width is not in bounds");
		}
		
		if (xOffset + (width)> Validate.validatePicture(source).getWidth()) {
			throw new IllegalArgumentException("width is not in bounds");
		}
		if (yOffset + (height)> Validate.validatePicture(source).getHeight()) {
			throw new IllegalArgumentException("width is not in bounds");
		}

		
		
	}
	
	public int getXOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}
	
	public Picture getSource() {
		return source;
	}
	

	@Override
	public void setPixel(int x, int y, Pixel p) {
		if (p == null) {
			throw new RuntimeException ( "null");
		}
		
		source.setPixel(x+xOffset,y+yOffset, p) ;
		
	}
	
	@Override
	public Pixel getPixel(int x, int y) {
		return source.getPixel(x+xOffset, y+yOffset);
	}
	

	
}


