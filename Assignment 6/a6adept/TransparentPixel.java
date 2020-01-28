package a6adept;

import a6adept.Pixel;

public interface TransparentPixel
extends Pixel {
    public double getTransparency();

    public TransparentPixel blend(TransparentPixel var1, double var2);
}

