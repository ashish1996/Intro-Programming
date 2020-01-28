package a4jedi;

public class Validate {
	public static Picture validatePicture(Picture o){
        if (o == null){
            throw new IllegalArgumentException("Picture passed is null");
        }
        return o;
    }
}
