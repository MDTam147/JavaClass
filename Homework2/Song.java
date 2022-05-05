/**
 * 
 * @author Tam Doan
 * For HW2
 * Song class used in Album and Music Collection classes.
 *
 */
public class Song {
	private String title;
	private String artist;
	private String genre;
	
	// constructors
	public Song(String title, String artist, String genre) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
	}
	
	public Song(String title, String artist) {
		this(title, artist, "unknown");
	}
	
	// getters
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getGenre() {
		return genre;
	}
	
	// setters 
	public void setTitle(String title) {
		this.title = title;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String toString() {
		String out = title + " - "+artist+", Genre: "+genre;
		return out;
	}

}
