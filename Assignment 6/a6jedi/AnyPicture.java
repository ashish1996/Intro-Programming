package a6jedi;

import a6jedi.Coordinate;
import a6jedi.ZigzagIterator;
import a6jedi.Picture;
import a6jedi.Pixel;
import a6jedi.RowMajorPixelIterator;
import a6jedi.SIterator;
import a6jedi.SubPicture;
import a6jedi.SubPictureImpl;
import a6jedi.TIterator;
import a6jedi.WIterator;
import java.io.PrintStream;
import java.util.Iterator;

public abstract class AnyPicture
implements Picture {
    private int width;
    private int height;

    protected AnyPicture(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Illegal width or height");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public abstract void setPixel(int var1, int var2, Pixel var3);

    @Override
    public abstract Pixel getPixel(int var1, int var2);

    @Override
    public int countRange(double low, double high) {
        int count = 0;
        int x = 0;
        while (x < this.getWidth()) {
            int y = 0;
            while (y < this.getHeight()) {
                double intensity = this.getPixel(x, y).getIntensity();
                if (intensity >= low && intensity <= high) {
                    ++count;
                }
                ++y;
            }
            ++x;
        }
        return count;
    }

    @Override
    public void print() {
        int y = 0;
        while (y < this.getHeight()) {
            int x = 0;
            while (x < this.getWidth()) {
                System.out.print(this.getPixel(x, y).getChar());
                ++x;
            }
            System.out.println();
            ++y;
        }
    }

    @Override
    public SubPicture extract(int xOffset, int yOffset, int width, int height) {
        return new SubPictureImpl(this, xOffset, yOffset, width, height);
    }

    @Override
    public void setPixel(Coordinate c, Pixel p) {
        if (c == null) {
            throw new IllegalArgumentException("Coordinate for setPixel is null");
        }
        this.setPixel(c.getX(), c.getY(), p);
    }

    @Override
    public Pixel getPixel(Coordinate c) {
        if (c == null) {
            throw new IllegalArgumentException("Coordinate for getPixel is null");
        }
        return this.getPixel(c.getX(), c.getY());
    }

    @Override
    public SubPicture extract(Coordinate corner_a, Coordinate corner_b) {
        if (corner_a == null || corner_b == null) {
            throw new IllegalArgumentException("Coordinate for extract is null");
        }
        int min_x = corner_a.getX() < corner_b.getX() ? corner_a.getX() : corner_b.getX();
        int max_x = corner_a.getX() >= corner_b.getX() ? corner_a.getX() : corner_b.getX();
        int min_y = corner_a.getY() < corner_b.getY() ? corner_a.getY() : corner_b.getY();
        int max_y = corner_a.getY() >= corner_b.getY() ? corner_a.getY() : corner_b.getY();
        return this.extract(min_x, min_y, max_x - min_x + 1, max_y - min_y + 1);
    }

    @Override
    public Iterator<Pixel> iterator() {
        return new RowMajorPixelIterator(this);
    }

    @Override
    public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy) {
        if (init_x < 0 || init_x >= this.getWidth() || init_y < 0 || init_y >= this.getHeight()) {
            throw new IllegalArgumentException("Initial x and y of sampling must be within picture");
        }
        if (dx < 1 || dy < 0) {
            throw new IllegalArgumentException("dx and dy must be positive");
        }
        return new SIterator(this, init_x, init_y, dx, dy);
    }

    @Override
    public Iterator<SubPicture> window(int window_width, int window_height) {
        if (window_width < 1 || window_height < 1) {
            throw new IllegalArgumentException("Window width and height must be positive");
        }
        if (window_width > this.getWidth() || window_height > this.getHeight()) {
            throw new IllegalArgumentException("Window width and height must be smaller than picture width and height");
        }
        return new WIterator(this, window_width, window_height);
    }

    @Override
    public Iterator<SubPicture> tile(int tile_width, int tile_height) {
        if (tile_width < 1 || tile_height < 1) {
            throw new IllegalArgumentException("Tile width and height must be positive");
        }
        if (tile_width > this.getWidth() || tile_height > this.getHeight()) {
            throw new IllegalArgumentException("Tile width and height must be smaller than picture width and height");
        }
        return new TIterator(this, tile_width, tile_height);
    }

    @Override
    public Iterator<Pixel> zigzag() {
        return new ZigzagIterator(this);
    }
}

