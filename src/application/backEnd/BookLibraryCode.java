package application.backEnd;

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
	private String source;

	public BookLibraryCode() {
		source = "";
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
		if (newBook.getNextBook() != null) {
		builder += newBook.getNextBook().getTitle() + "\n";
		}
		else {
			builder += "null\n";
		}
		if (newBook.getPreviousBook() != null) {
		builder += newBook.getPreviousBook().getTitle() + "\n";
		}
		else {
			builder += "null\n";
		}
		builder += newBook.getRating() + "\n";
		writer.write(builder);
		books.add(newBook);
		writer.close();
		
		System.out.println("written book");
		
	}

	public void searchViaGenre(String genre) {

	} 
	public void searchViaAuthor(String author) {

	}
	public void searchViaTitle(String title) {

	}
	public void SortAscending() {

	}
	public void sortDescending() {

	}
	public void FilterRead() {

	}



}
