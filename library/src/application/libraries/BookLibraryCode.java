package application.libraries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import application.items.books.Book;

public class BookLibraryCode extends LibraryCode{
	private ArrayList<Book> books;
	private ArrayList<Book>filtered;
	private String source;

	public BookLibraryCode() {
		source = "";
		filtered = new ArrayList<Book>();
		books = new ArrayList<Book>();
		try {
			LoadBooks("src\\books");
			System.out.println("read all books");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void LoadBooks(String source) throws IOException {
		this.source = source;
		File list = new File(source + "\\bookList.txt");
		list.createNewFile();
		//read the file that contains a list of books
		try {
			BufferedReader files = new BufferedReader(new FileReader(list));
			String newFile = files.readLine();
			while (newFile != null) {
				File book = new File(source + "\\" + newFile + ".txt");
				BufferedReader readBook = new BufferedReader(new FileReader(book));
				Book newBook = new Book();
				try {
					newBook.setTitle(readBook.readLine());
					newBook.setAuthor(readBook.readLine());
					newBook.setSynopsis(readBook.readLine());
					newBook.setPages(Integer.parseInt(readBook.readLine()));
					newBook.setChapters(Integer.parseInt(readBook.readLine()));
					newBook.setCurrentPage(Integer.parseInt(readBook.readLine()));
					if (readBook.readLine().equals("true")){
						newBook.setRead(true);
					}
					else {
						newBook.setRead(false);
					}
					String next = readBook.readLine();
					if (next.equals("null")) {
						newBook.setPreviousBook(null);
					}
					else {
						newBook.setPreviousBook(new Book(source + "\\" + next + ".txt"));
					}
					next = readBook.readLine();
					if (next.equals("null")) {
						newBook.setNextBook(null);
					}
					else {
						newBook.setNextBook(new Book(source + next + ".txt"));
					}
					newBook.setRating(Integer.parseInt(readBook.readLine()));
					if (readBook.readLine().equals("{")) {
						next = readBook.readLine();
						while (!next.equals("}")) {
							newBook.addGenre(next);
							next = readBook.readLine();
						}
					}
					books.add(newBook);
					
				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				System.out.println(newBook.toString());
				newFile = files.readLine();
				readBook.close();
			}
			files.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}
	public void addBook(Book newBook) throws IOException{
		System.out.println(newBook.getTitle());
		FileWriter index = new FileWriter(new File(source + "\\" + "bookList.txt"), true);
		String builder = newBook.getTitle();
		index.write(builder + "\n");
		index.close();
		System.out.println("added book to list");
		FileWriter writer = new FileWriter(new File (source + "\\" + newBook.getTitle() + ".txt"), false);
		builder ="";
		builder += newBook.getTitle() + "\n";
		builder += newBook.getAuthor() + "\n";
		builder += newBook.getSynopsis() + "\n";
		builder += newBook.getPages() + "\n";
		builder += newBook.getChapters() + "\n";
		builder += newBook.getCurrentPage() + "\n";
		builder += newBook.isRead() + "\n";
		if (newBook.getPreviousBook() != null) {
			builder += newBook.getPreviousBook().getTitle() + "\n";
		}
		else {
			builder += "null\n";
		}
		if (newBook.getNextBook() != null) {
			builder += newBook.getNextBook().getTitle() + "\n";
		}
		else {
			builder += "null\n";
		}
		builder += newBook.getRating() + "\n";
		builder += "{\n";
		for (int i = 0; i <newBook.getGenres().size(); i++) {
			builder += newBook.getGenres().get(i) + "\n";
		}
		builder += "}\n";
		writer.write(builder);
		books.add(newBook);
		writer.close();

		System.out.println("written book");

	}

	/**
	 * search for a certain genre of books
	 * @param genre - genre to search for
	 */
	public void searchViaGenre(String genre) {
		filtered = new ArrayList<Book>();// clear the list first
		for (int i = 0; i <books.size(); i++) {
			if (books.get(i).getGenres().contains(genre)) {
				filtered.add(books.get(i));
			}
		}
	} 
	/**
	 * search for an author
	 * @param author - authors name
	 */
	public void searchViaAuthor(String author) {
		filtered = new ArrayList<Book>();
		for (int i = 0; i <books.size(); i++) {
			if (books.get(i).getAuthor() == author) {
				filtered.add(books.get(i));
			}
		}
	}
	/**
	 * search for a book based on title
	 * @param title - title of the book(s) to search for
	 */
	public void searchViaTitle(String title) {
		filtered = new ArrayList<Book>();
		for (int i = 0; i <books.size(); i++) {
			if (books.get(i).getTitle() == title) {
				filtered.add(books.get(i));
			}
		}
	}
	public void SortAscending() {
		//TODO 
	}
	public void sortDescending() {
		//TODO
	}
	/**
	 * gets all the read books
	 */
	public void FilterRead() {
		filtered = new ArrayList<Book>();
		for (int i = 0; i <books.size(); i++) {
			if (books.get(i).isRead()) {
				filtered.add(books.get(i));
			}
		}
	}
	/**
	 * search for a specific book based on its title (useful to set the previous/next book in a series)
	 * @param title
	 * @return the searched book
	 */
	public Book getSpecificBook(String title) {
		for (int i = 0; i <books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				return books.get(i);
			}
		}
		return null;
	}


	/*order of read and write
	 * 
	 * title
	 * author
	 * synopsis
	 * pages
	 * chapters
	 * current page
	 * read
	 * previous
	 * next
	 * rating
	 * {
	 * genres
	 * }
	 * 
	 */

}
