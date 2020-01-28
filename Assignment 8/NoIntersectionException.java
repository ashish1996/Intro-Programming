package a8;
// Returns a runtime inspection if no intersection exists between regions
public class NoIntersectionException extends Exception {

	public NoIntersectionException() {
		super("Empty intersection");
	}
}
