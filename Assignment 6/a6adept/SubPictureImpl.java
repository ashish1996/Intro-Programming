package a6adept;

import a6adept.AnyPicture;
import a6adept.Picture;
import a6adept.Pixel;
import a6adept.SubPicture;

public class SubPictureImpl
extends AnyPicture
implements SubPicture {
    private Picture source;
    private int x_offset;
    private int y_offset;

    public SubPictureImpl(Picture source, int xOffset, int yOffset, int width, int height) {
        super(width, height);
        if (source == null) {
            throw new IllegalArgumentException("source picture is null");
        }
        if (xOffset < 0 || xOffset >= source.getWidth()) {
            throw new IllegalArgumentException("xOffset out of range");
        }
        if (yOffset < 0 || yOffset >= source.getHeight()) {
            throw new IllegalArgumentException("xOffset out of range");
        }
        if (xOffset + width > source.getWidth()) {
            throw new IllegalArgumentException("subpicture too wide for source");
        }
        if (yOffset + height > source.getHeight()) {
            throw new IllegalArgumentException("subpicture too tall for source");
        }
        this.source = source;
        this.x_offset = xOffset;
        this.y_offset = yOffset;
    }

    @Override
    public void setPixel(int x, int y, Pixel p) {
        this.source.setPixel(x + this.x_offset, y + this.y_offset, p);
    }

    @Override
    public Pixel getPixel(int x, int y) {
        return this.source.getPixel(x + this.x_offset, y + this.y_offset);
    }

    @Override
    public Picture getSource() {
        return this.source;
    }

    @Override
    public int getXOffset() {
        return this.x_offset;
    }

    @Override
    public int getYOffset() {
        return this.y_offset;
    }
}

