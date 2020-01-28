package a6jedi;

import a6jedi.Picture;

public interface SubPicture
extends Picture {
    public Picture getSource();

    public int getXOffset();

    public int getYOffset();
}

