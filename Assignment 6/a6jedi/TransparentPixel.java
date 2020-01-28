package a6jedi;

import a6jedi.Pixel;

public interface TransparentPixel
extends Pixel {
    public double getTransparency();

    public TransparentPixel blend(TransparentPixel var1, double var2);
}

