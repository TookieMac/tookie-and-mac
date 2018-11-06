package application.libraries;

/**
 * 
 * @author Tookie
 *
 */
public abstract class LibraryCode {
	protected String[] filter;
	protected double contentNumber;
	
	public LibraryCode() {
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
