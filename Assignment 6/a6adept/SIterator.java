package a6adept;

import a6adept.Coordinate;
import a6adept.CoordinateGenerator;
import a6adept.Picture;
import a6adept.Pixel;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SIterator
implements Iterator<Pixel> {
    private CoordinateGenerator coordinate_generator;
    private Picture source;

    public SIterator(Picture source, int init_x, int init_y, int dx, int dy) {
        if (source == null) {
            throw new IllegalArgumentException("Source for window iterator can not be null");
        }
        this.coordinate_generator = new CoordinateGenerator(init_x, init_y, dx, dy, source.getWidth() - 1, source.getHeight() - 1);
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return this.coordinate_generator.hasNext();
    }

    @Override
    public Pixel next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No next pixel in sample iterator");
        }
        return this.source.getPixel(this.coordinate_generator.next());
    }
}
