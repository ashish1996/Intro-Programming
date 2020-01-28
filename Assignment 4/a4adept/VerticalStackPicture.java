package a4adept;

public class VerticalStackPicture extends AnyPicture implements Picture{
	
	private Picture top;
	private Picture bottom;
	
	
	public VerticalStackPicture (Picture top, Picture bottom) {
		super(Validate.validatePicture(top).getWidth(), Validate.validatePicture(top).getHeight() + Validate.validatePicture(bottom).getHeight());
		if ( top == null || bottom == null) {
			throw new IllegalArgumentException("Pictures are null");
		}
		if (Validate.validatePicture(top).getWidth() != Validate.validatePicture(bottom).getWidth()) {
			throw new IllegalArgumentException("Height's aren't equal");
		}
		
		this.top = top;
		this.bottom = bottom;
		
	
	}
		@Override
		public void setPixel(int x, int y, Pixel p) {
			if (p == null) {
				throw new IllegalArgumentException ( "null");
			}
			if (y<top.getHeight()) {
				top.setPixel(x, y, p);
				}
				else {
				bottom.setPixel(x, y-top.getHeight(), p);
				}
			
		}
		//getters
		@Override
		public Pixel getPixel(int x, int y) {
			if (y<top.getHeight()) {
			return top.getPixel(x, y);
			}
			else {
			return bottom.getPixel(x, y-top.getHeight());
			}
		
	}
		
		
		
}

