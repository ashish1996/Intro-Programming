package a6jedi;

import a6jedi.AnyPicture;
import a6jedi.GrayPixel;
import a6jedi.Pixel;

public class PictureImpl
extends AnyPicture {
    private Pixel[][] pixels;
    private static final Pixel INITIAL_PIXEL = new GrayPixel(0.5);

    public PictureImpl(int width, int height) {
        super(width, height);
        this.pixels = new Pixel[width][height];
        int x = 0;
        while (x < width) {
            int y = 0;
            while (y < height) {
                this.pixels[x][y] = INITIAL_PIXEL;
                ++y;
            }
            ++x;
        }
    }

    @Override
    public void setPixel(int x, int y, Pixel p) {
        if (p == null) {
            throw new RuntimeException("Pixel p is null");
        }
        if (x < 0 || x >= this.getWidth()) {
            throw new RuntimeException("x is out of bounds");
        }
        if (y < 0 || y >= this.getHeight()) {
            throw new RuntimeException("y is out of bounds");
        }
        this.pixels[x][y] = p;
    }

    @Override
    public Pixel getPixel(int x, int y) {
        if (x < 0 || x >= this.getWidth()) {
            throw new RuntimeException("x is out of bounds");
        }
        if (y < 0 || y >= this.getHeight()) {
            throw new RuntimeException("y is out of bounds");
        }
        return this.pixels[x][y];
    }
}

