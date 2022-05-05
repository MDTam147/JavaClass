/**
 * 
 * @author Tam Doan
 * For HW2
 * Album class which holds a Song class. Used in MusicCollection class.
 *
 */

public class Album {
	private String title;
	private String artist;
	private String genre;
	private Song favoriteTrack;
	private int trackNumber;
	
	static int numAlbums;
	
	// constructors
	public Album(String title, Song favoriteTrack, int trackNumber) {
		this.title = title;
		this.favoriteTrack = favoriteTrack;
		this.trackNumber = trackNumber;
		this.artist = favoriteTrack.getArtist();
		this.genre = favoriteTrack.getGenre();
		
		numAlbums++;
	}
	
	public Album(String title, Song favoriteTrack) {
		this(title, favoriteTrack, 1);
	}
	
	// getters
	public String getTitle() {
		return this.title;
	}
	public Song getFavoriteTrack() {
		return this.favoriteTrack;
	}
	public int getTrackNumber() {
		return this.trackNumber;
	}
	
	// setters
	public void setGenre(String genre) {
		favoriteTrack.setGenre(genre);
	}
	
	public String toString() {
		String out = "\""+title + "\" by " + artist +": "+genre;
		return out;
	}

}
