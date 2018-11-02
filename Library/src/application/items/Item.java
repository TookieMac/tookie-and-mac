package application.items;

import java.util.ArrayList;
/**
 * 
 * @author tookie
 *
 */
public abstract class Item {
	protected int rating;
	protected String title;
	protected String synopsis;
	protected String series;
	protected ArrayList<String> genres;


	public Item() {
		rating = 0;
		title = "";
		synopsis = "";
		series = "";
		genres = new ArrayList<String>();
	}


	//accessors and mutators
	public void setSeries(String series) {
		this.series = series;
	}
	public String getSeries() {
		return series;
	}
	public void addGenre(String genre) {
		this.genres.add(genre);
	}	
	public void setGernes(ArrayList<String> genres) {
		this.genres = genres;
	}
	public ArrayList<String> getGenres(){
		return genres;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "title: " + title + ", rating: " + rating;
	}
}
