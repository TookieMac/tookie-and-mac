package application.libraries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import application.items.videos.Film;

public class FilmLibraryCode extends LibraryCode{
	private ArrayList<Film> films;
	private ArrayList<Film> filtered;

	/**
	 * create a new library of films at the default source location
	 */
	public FilmLibraryCode() {
		films = new ArrayList<Film>();
		filtered = new ArrayList<Film>();
		try {
			LoadFilms("src\\films");
			System.out.println("read all films");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * create the library with a given source location
	 * @param source - source location of the film index file
	 */
	public FilmLibraryCode(String source) {
		this.source = source;
		films = new ArrayList<Film>();
		filtered = new ArrayList<Film>();
		try {
			LoadFilms(source);
			System.out.println("read all films");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * load the current flims to the library
	 * @param source
	 * @throws IOException
	 */
	private void LoadFilms(String source) throws IOException {
		File list = new File(source + "\\FilmList.txt");
		list.createNewFile();
		//read the file that contains a list of films
		try {
			BufferedReader files = new BufferedReader(new FileReader(list));
			String newFile = files.readLine();
			while (newFile != null) {
				File book = new File(source + "\\" + newFile + ".txt");
				BufferedReader readFilm = new BufferedReader(new FileReader(book));
				Film newFilm = new Film();
				try {
					newFilm.setTitle(readFilm.readLine());
					newFilm.setDirector(readFilm.readLine());
					newFilm.setSynopsis(readFilm.readLine());
					newFilm.setDuration(Double.parseDouble(readFilm.readLine()));
					newFilm.setCurrentTime(Double.parseDouble(readFilm.readLine()));
					if (readFilm.readLine().equals("true")){
						newFilm.setWatched(true);
					}
					else {
						newFilm.setWatched(false);
					}
					String next = readFilm.readLine();
					if (next.equals("null")) {
						newFilm.setPrevious(null);
					}
					else {
						newFilm.setPrevious(new Film(source + "\\" + next + ".txt"));
					}
					next = readFilm.readLine();
					if (next.equals("null")) {
						newFilm.setNext(null);
					}
					else {
						newFilm.setNext(new Film(source + next + ".txt"));
					}
					newFilm.setRating(Integer.parseInt(readFilm.readLine()));
					if (readFilm.readLine().equals("{")) {
						next = readFilm.readLine();
						while (!next.equals("}")) {
							newFilm.addGenre(next);
							next = readFilm.readLine();
						}
					}
					films.add(newFilm);

				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				System.out.println(newFilm.toString());
				newFile = files.readLine();
				readFilm.close();
			}
			files.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * add a new film to the library
	 * @param newFilm
	 * @throws IOException
	 */
	public void addFilm(Film newFilm) throws IOException{
		System.out.println(newFilm.getTitle());
		FileWriter index = new FileWriter(new File(source + "\\" + "bookList.txt"), true);
		String builder = newFilm.getTitle();
		index.write(builder + "\n");
		index.close();
		System.out.println("added book to list");
		FileWriter writer = new FileWriter(new File (source + "\\" + newFilm.getTitle() + ".txt"), false);
		builder ="";
		builder += newFilm.getTitle() + "\n";
		builder += newFilm.getDirector() + "\n";
		builder += newFilm.getSynopsis() + "\n";
		builder += newFilm.getDuration() + "\n";
		builder += newFilm.getCurrentTime() + "\n";
		builder += newFilm.isWatched() + "\n";
		if (newFilm.getPrevious() != null) {
			builder += newFilm.getPrevious().getTitle() + "\n";
		}
		else {
			builder += "null\n";
		}
		if (newFilm.getNext() != null) {
			builder += newFilm.getNext().getTitle() + "\n";
		}
		else {
			builder += "null\n";
		}
		builder += newFilm.getRating() + "\n";
		builder += "{\n";
		for (int i = 0; i <newFilm.getGenres().size(); i++) {
			builder += newFilm.getGenres().get(i) + "\n";
		}
		builder += "}\n";
		writer.write(builder);
		films.add(newFilm);
		writer.close();

		System.out.println("written book");

	}


}
