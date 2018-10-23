package application.libraries;

/**
 * 
 * @author Tookie
 *
 */
public abstract class LibraryCode {
	protected String[] filter;
	protected double contentNumber;
	protected String source;
	
	public LibraryCode() {
		source = null;//so that a file can't be created UNTIL a proper location is set (if tried will cause a NullPointerException)
		filter = new String[] {"alphabetical ascending", "alphabetical descending", "author", "genre"};
		contentNumber = 0;
	}
	
	public String[] getFilterList() {
		return filter;
	}
	public double getNumberOfItems() {
		return contentNumber;
	}

}
