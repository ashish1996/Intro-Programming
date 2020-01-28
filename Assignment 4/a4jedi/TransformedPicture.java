package a4jedi;

public class TransformedPicture extends AnyPicture implements Picture  {
private Picture source;
private PixelTransformation xform;
	
	public TransformedPicture (Picture source, PixelTransformation xform) {
		super(source.getWidth(),source.getHeight());
		this.source = source;
		this.xform = xform;
	}
	
	public PixelTransformation getXform() {
		return xform;
	}
	
	@Override
	public void setPixel(int x, int y, Pixel p) {
		throw new UnsupportedOperationException();
			}
		
	
	@Override
	public Pixel getPixel(int x, int y) {
		return getXform().transform(source.getPixel(x,y));
		
	
	}
	
}
