
package a6novice;

import a6novice.Pixel;

public interface TransparentPixel
extends Pixel {
    public double getTransparency();

    public TransparentPixel blend(TransparentPixel var1, double var2);
}

