package a6novice;

import a6novice.Coordinate;
import a6novice.Pixel;
import a6novice.SubPicture;

public interface Picture
extends Iterable<Pixel> {
    public int getWidth();

    public int getHeight();

    public void setPixel(int var1, int var2, Pixel var3);

    public Pixel getPixel(int var1, int var2);

    public int countRange(double var1, double var3);

    public void print();

    public SubPicture extract(int var1, int var2, int var3, int var4);

    public void setPixel(Coordinate var1, Pixel var2);

    public Pixel getPixel(Coordinate var1);

    public SubPicture extract(Coordinate var1, Coordinate var2);
}

