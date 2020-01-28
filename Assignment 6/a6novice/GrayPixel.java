package a6novice;

import a6novice.PixelImpl;

public class GrayPixel
extends PixelImpl {
    private double intensity;

    public GrayPixel(double intensity) {
        if (intensity < 0.0 || intensity > 1.0) {
            throw new RuntimeException("Intensity value out of range");
        }
        this.intensity = intensity;
    }

    @Override
    public double getRed() {
        return this.intensity;
    }

    @Override
    public double getBlue() {
        return this.intensity;
    }

    @Override
    public double getGreen() {
        return this.intensity;
    }

    @Override
    public double getIntensity() {
        return this.intensity;
    }
}

