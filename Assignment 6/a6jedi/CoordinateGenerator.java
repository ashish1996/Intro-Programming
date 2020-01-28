package a6jedi;

import a6jedi.Coordinate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CoordinateGenerator
implements Iterator<Coordinate> {
    private int init_x;
    private int init_y;
    private int dx;
    private int dy;
    private int max_x;
    private int max_y;
    private int cur_x;
    private int cur_y;

    public CoordinateGenerator(int init_x, int init_y, int dx, int dy, int max_x, int max_y) {
        this.init_x = init_x;
        this.init_y = init_y;
        this.dx = dx;
        this.dy = dy;
        this.max_x = max_x;
        this.max_y = max_y;
        this.cur_x = init_x;
        this.cur_y = init_y;
    }

    @Override
    public boolean hasNext() {
        return this.cur_y <= this.max_y;
    }

    @Override
    public Coordinate next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No more coordinates to generate");
        }
        Coordinate c = new Coordinate(this.cur_x, this.cur_y);
        this.cur_x += this.dx;
        if (this.cur_x > this.max_x) {
            this.cur_x = this.init_x;
            this.cur_y += this.dy;
        }
        return c;
    }
}

