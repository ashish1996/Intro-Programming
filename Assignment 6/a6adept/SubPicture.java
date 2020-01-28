package a6adept;

import a6adept.Picture;

public interface SubPicture
extends Picture {
    public Picture getSource();

    public int getXOffset();

    public int getYOffset();
}

