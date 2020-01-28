package a6jedi;

import a6jedi.Picture;
import a6jedi.Pixel;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ZigzagIterator
implements Iterator<Pixel> {
    private Picture source;
    private int cur_x;
    private int cur_y;
    private boolean done;

    public ZigzagIterator(Picture source) {
        this.source = source;
        this.cur_x = 0;
        this.cur_y = 0;
        this.done = false;
    }

    @Override
    public boolean hasNext() {
        return !this.done;
    }

    @Override
    public Pixel next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("Zig zag is complete");
        }
        Pixel p = this.source.getPixel(this.cur_x, this.cur_y);
        if (this.cur_x == this.source.getWidth() - 1 && this.cur_y == this.source.getHeight() - 1) {
            this.done = true;
        } else if ((this.cur_x + this.cur_y) % 2 == 0) {
            if (this.cur_x == this.source.getWidth() - 1) {
                ++this.cur_y;
            } else if (this.cur_y == 0) {
                ++this.cur_x;
            } else {
                --this.cur_y;
                ++this.cur_x;
            }
        } else if (this.cur_y == this.source.getHeight() - 1) {
            ++this.cur_x;
        } else if (this.cur_x == 0) {
            ++this.cur_y;
        } else {
            --this.cur_x;
            ++this.cur_y;
        }
        return p;
    }
}