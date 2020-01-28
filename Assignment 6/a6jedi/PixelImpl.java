package a6jedi;

import a6jedi.ColorPixel;
import a6jedi.GrayPixel;
import a6jedi.Pixel;

public abstract class PixelImpl
implements Pixel {
    private static final double RED_INTENSITY_FACTOR = 0.299;
    private static final double GREEN_INTENSITY_FACTOR = 0.587;
    private static final double BLUE_INTENSITY_FACTOR = 0.114;
    private static final Pixel WHITE_PIXEL = new GrayPixel(1.0);
    private static final Pixel BLACK_PIXEL = new GrayPixel(0.0);
    private static final char[] PIXEL_CHAR_MAP = new char[]{'#', 'M', 'X', 'D', '<', '>', 's', ':', '-', ' ', ' '};

    @Override
    public abstract double getRed();

    @Override
    public abstract double getBlue();

    @Override
    public abstract double getGreen();

    @Override
    public double getIntensity() {
        return 0.299 * this.getRed() + 0.587 * this.getGreen() + 0.114 * this.getBlue();
    }

    @Override
    public char getChar() {
        int char_idx = (int)(this.getIntensity() * 10.0);
        return PIXEL_CHAR_MAP[char_idx];
    }

    @Override
    public Pixel lighten(double factor) {
        if (factor < 0.0 || factor > 1.0) {
            throw new RuntimeException("Lighten factor out of range");
        }
        return WHITE_PIXEL.blend(this, factor);
    }

    @Override
    public Pixel darken(double factor) {
        if (factor < 0.0 || factor > 1.0) {
            throw new RuntimeException("Darken factor out of range");
        }
        return BLACK_PIXEL.blend(this, factor);
    }

    @Override
    public Pixel blend(Pixel p, double weight) {
        if (weight < 0.0 || weight > 1.0) {
            throw new RuntimeException("Blend weight out of range");
        }
        if (p == null) {
            throw new RuntimeException("Blend pixel is null");
        }
        return new ColorPixel(this.getRed() * weight + p.getRed() * (1.0 - weight), this.getGreen() * weight + p.getGreen() * (1.0 - weight), this.getBlue() * weight + p.getBlue() * (1.0 - weight));
    }

    @Override
    public boolean equals(Pixel p) {
        if (p == null) {
            throw new RuntimeException("Pixel passed to equals method is null");
        }
        double max_intensity = this.getIntensity() > p.getIntensity() ? this.getIntensity() : p.getIntensity();
        double equal_bound = max_intensity * 0.1;
        if (Math.abs(this.getRed() - p.getRed()) < equal_bound && Math.abs(this.getGreen() - p.getGreen()) < equal_bound && Math.abs(this.getBlue() - p.getBlue()) < equal_bound) {
            return true;
        }
        return false;
    }
}

