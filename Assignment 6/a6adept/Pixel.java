package a6adept;

public interface Pixel {
    public double getRed();
    public double getBlue();
    public double getGreen();
    public double getIntensity();
    public char getChar();
    public Pixel blend(Pixel var1, double var2);
    public Pixel lighten(double var1);
    public Pixel darken(double var1);
    public boolean equals(Pixel var1);
}

