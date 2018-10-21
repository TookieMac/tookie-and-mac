package application.items.books;

import application.items.Item;

/**
 * 
 * @author tookie
 *
 */
public class Book extends Item{
	private int pages;
	private int chapters;
	private int currentPage;
	private String author;
	private boolean read;
	private Book previousBook;
	private Book nextBook;
	
/**
 * creates a new (blank) book
 */
	public Book() {
		pages = 0;
		chapters = 0;
		currentPage = 0;
		read = false;
		previousBook = null;
		nextBook = null;
		author = "";
	}
	/**
	 * creates a new book with some beginning properties
	 * @param title - title of the book
	 * @param pages - total number of pages in the book
	 * @param chapters - total number of chapters in the book
	 * @param currentPage - current page the reader is up to
	 * @param read - whether or not the book is currently being read
	 */
	public Book(String title, String author, int pages, int chapters, int currentPage, boolean read) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.chapters = chapters;
		this.currentPage = currentPage;
		this.read = read;
		previousBook = null;
		nextBook = null;
	}
	
	public Book(String book) {
		
	}

	//accessors and mutators
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public Book getPreviousBook() {
		return previousBook;
	}
	public void setPreviousBook(Book previousBook) {
		this.previousBook = previousBook;
	}
	public Book getNextBook() {
		return nextBook;
	}
	public void setNextBook(Book nextBook) {
		this.nextBook = nextBook;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getChapters() {
		return chapters;
	}
	public void setChapters(int chapters) {
		this.chapters = chapters;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}

	@Override
	public String toString() {
		return "title: " + title + ", rating: " + rating + ", pages: " + pages + ", chapters: " + chapters;
	}
}
