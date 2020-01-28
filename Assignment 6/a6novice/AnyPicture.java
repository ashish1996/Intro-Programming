package a6novice;

import a6novice.Coordinate;
import a6novice.RowMajorPixelIterator;
import a6novice.Picture;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;
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
}

