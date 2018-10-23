package application.backEnd;

/**
 * 
 * @author Tookie
 *
 */
public abstract class LibraryCode {
	protected String[] filter;
	
	public LibraryCode() {
		filter = new String[] {"alphabetical ascending", "alphabetical descending", "author", "genre"};
		
	}

}
