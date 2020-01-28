package a6jedi;

import a6jedi.ColorPixel;
import a6jedi.Pixel;
import a6jedi.TransparentPixel;

public class TransparentColorPixel
extends ColorPixel
implements TransparentPixel {
    private double transparency;

    public TransparentColorPixel(double r, double g, double b, double t) {
        super(r, g, b);
        if (t > 1.0 || t < 0.0) {
            throw new RuntimeException("Transparency out of bounds");
        }
        this.transparency = t;
    }

    @Override
    public TransparentPixel blend(TransparentPixel p, double weight) {
        Pixel blended_base = this.blend(p, weight);
        return new TransparentColorPixel(blended_base.getRed(), blended_base.getGreen(), blended_base.getBlue(), this.getTransparency() * p.getTransparency());
    }

    @Override
    public double getTransparency() {
        return this.transparency;
    }
}

