package a6jedi;

import a6jedi.Picture;
import a6jedi.Pixel;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RowMajorPixelIterator
implements Iterator<Pixel> {
    private Picture source;
    private int current_x;
    private int current_y;

    public RowMajorPixelIterator(Picture source) {
        this.source = source;
        this.current_x = 0;
        this.current_y = 0;
    }

    @Override
    public boolean hasNext() {
        return this.current_y < this.source.getHeight();
    }

    @Override
    public Pixel next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No more pixels");
        }
        Pixel p = this.source.getPixel(this.current_x, this.current_y);
        if (this.current_x == this.source.getWidth() - 1) {
            this.current_x = 0;
            ++this.current_y;
        } else {
            ++this.current_x;
        }
        return p;
    }
}

