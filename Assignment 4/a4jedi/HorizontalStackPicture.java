package a4jedi;

public class HorizontalStackPicture extends AnyPicture implements Picture {
	
				
				private Picture left;
				private Picture right;
				
	public HorizontalStackPicture (Picture left, Picture right) {
		super(Validate.validatePicture(left).getWidth()+Validate.validatePicture(right).getWidth(),Validate.validatePicture(left).getHeight());
		if ( left == null || right == null) {
			throw new IllegalArgumentException("Pictures are null");
		}
		if (Validate.validatePicture(left).getHeight() != Validate.validatePicture(right).getHeight()) {
			throw new IllegalArgumentException("Height's aren't equal");
		}
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void setPixel(int x, int y, Pixel p) {
		if (p == null) {
			throw new IllegalArgumentException ( "null");
		}
		if (x<left.getWidth()) {
			left.setPixel(x, y,p);
			}
			else {
			right.setPixel(x-left.getWidth(), y,p);
			}
		
	}
	//getters
	@Override
	public Pixel getPixel(int x, int y) {
		if (x<left.getWidth()) {
		return left.getPixel(x, y);
		}
		else  {
		return right.getPixel(x-left.getWidth(), y);
		}
		
	}
	
	
}
					

	


