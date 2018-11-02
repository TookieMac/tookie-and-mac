package application.items.videos;

import application.items.Item;

/**
 * 
 * @author Tookie
 *
 */
public class Film extends Item{
	private String director;
	private double duration;
	private double currentTime;
	private boolean watched;
	private Film next;
	private Film previous;
	
	public Film (String film) {
		director = "";
		duration = 0;
		currentTime = 0;
		watched = false;
		next = null;
		previous = null;
	}
	public Film() {
		director = "";
		duration = 0;
		currentTime = 0;
		watched = false;
		next = null;
		previous = null;
	}
	public String getDirector() {
		return director;
	}
	public double getDuration() {
		return duration;
	}
	public double getCurrentTime() {
		return currentTime;
	}
	public boolean isWatched() {
		return watched;
	}
	public Film getNext() {
		return next;
	}
	public Film getPrevious() {
		return previous;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public void setCurrentTime(double currentTime) {
		this.currentTime = currentTime;
	}
	public void setWatched(boolean watched) {
		this.watched = watched;
	}
	public void setNext(Film next) {
		this.next = next;
	}
	public void setPrevious(Film previous) {
		this.previous = previous;
	}
	
}
