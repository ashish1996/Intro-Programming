package a6adept;

import a6adept.PixelImpl;

public class ColorPixel
extends PixelImpl {
    private double red;
    private double green;
    private double blue;

    public ColorPixel(double r, double g, double b) {
        if (r > 1.0 || r < 0.0) {
            throw new RuntimeException("Red out of bounds");
        }
        if (g > 1.0 || g < 0.0) {
            throw new RuntimeException("Green out of bounds");
        }
        if (b > 1.0 || b < 0.0) {
            throw new RuntimeException("Blue out of bounds");
        }
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    @Override
    public double getRed() {
        return this.red;
    }

    @Override
    public double getBlue() {
        return this.blue;
    }

    @Override
    public double getGreen() {
        return this.green;
    }
}

