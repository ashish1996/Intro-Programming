package a6jedi;

import a6jedi.Coordinate;
import a6jedi.Pixel;
import a6jedi.SubPicture;
import java.util.Iterator;

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
    public Iterator<Pixel> sample(int var1, int var2, int var3, int var4);
    public Iterator<SubPicture> window(int var1, int var2);
    public Iterator<SubPicture> tile(int var1, int var2);
    public Iterator<Pixel> zigzag();
}

