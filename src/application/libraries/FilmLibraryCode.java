package application.libraries;

import java.util.ArrayList;

import application.items.videos.Film;

public class FilmLibraryCode extends LibraryCode{
	private ArrayList<Film> films;
	private ArrayList<Film> filtered;
	private String source;

	public FilmLibraryCode() {
		films = new ArrayList<Film>();
		filtered = new ArrayList<Film>();
		source = "";

	}


}
