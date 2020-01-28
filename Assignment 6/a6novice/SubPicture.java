package a6novice;

import a6novice.Picture;

public interface SubPicture
extends Picture {
    public Picture getSource();

    public int getXOffset();

    public int getYOffset();
}

