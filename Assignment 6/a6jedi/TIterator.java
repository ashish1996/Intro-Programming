package a6jedi;

import a6jedi.Coordinate;
import a6jedi.CoordinateGenerator;
import a6jedi.Picture;
import a6jedi.SubPicture;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TIterator
implements Iterator<SubPicture> {
    private Picture source;
    private CoordinateGenerator cg;
    private int tile_width;
    private int tile_height;

    public TIterator(Picture source, int tile_width, int tile_height) {
        if (source == null) {
            throw new IllegalArgumentException("Source for tile iterator can not be null");
        }
        this.tile_width = tile_width;
        this.tile_height = tile_height;
        this.source = source;
        int max_tile_x = source.getWidth() / tile_width * tile_width - 1;
        int max_tile_y = source.getHeight() / tile_height * tile_height - 1;
        this.cg = new CoordinateGenerator(0, 0, tile_width, tile_width, max_tile_x, max_tile_y);
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
        Coordinate lr = new Coordinate(ul.getX() + this.tile_width - 1, ul.getY() + this.tile_height - 1);
        return this.source.extract(ul, lr);
    }
}

