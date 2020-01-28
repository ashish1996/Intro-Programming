package a6jedi;

import a6jedi.Coordinate;
import a6jedi.CoordinateGenerator;
import a6jedi.Picture;
import a6jedi.SubPicture;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WIterator
implements Iterator<SubPicture> {
    private Picture source;
    private CoordinateGenerator cg;
    private int window_width;
    private int window_height;

    public WIterator(Picture source, int window_width, int window_height) {
        if (source == null) {
            throw new IllegalArgumentException("can not be null");
        }
        this.window_width = window_width;
        this.window_height = window_height;
        this.source = source;
        int max_window_x = source.getWidth() - window_width;
        int max_window_y = source.getHeight() - 1;
        this.cg = new CoordinateGenerator(0, 0, 1, 1, max_window_x, max_window_y);
    }

    @Override
    public boolean hasNext() {
        return this.cg.hasNext();
    }

    @Override
    public SubPicture next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No next window");
        }
        Coordinate ul = this.cg.next();
        Coordinate lr = new Coordinate(ul.getX() + this.window_width - 1, ul.getY() + this.window_height - 1);
        return this.source.extract(ul, lr);
    }
}
