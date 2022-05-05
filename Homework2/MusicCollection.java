import java.util.Scanner;

/**
 * 
 * @author Tam Doan
 * HW2, MusicCollection allows the user to go through the different albums,
 * see favorite tracks, and change genres of said tracks.
 *
 */

public class MusicCollection {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		// creating out music collection
		Song song1 = new Song("Little Star", "Silence Wang");
		Song song2 = new Song("Yume No You Na", "Yusuke Saeki");
		Song song3 = new Song("Stay With Me", "Chanyeol, PUNCH","pop");
		
		Album album1 = new Album("Starry Skies", song1, 4);
		Album album2 = new Album("Yume No You Na", song2);
		Album album3 = new Album("Goblin OST", song3, 1);
		
		int input = 1;
		
		while (input!=0) {
			System.out.println("Music Collection:\n");
			System.out.println("[1] "+album1.getTitle()+"\n[2] "+album2.getTitle()+"\n[3] "+album3.getTitle());
			System.out.print("Select an Album (0 to quit): ");
			
			input = scanner.nextInt();
			
			if(input == 1) {
				albumOptions(album1);
			} // end if
			else if(input == 2) {
				albumOptions(album2);
				
			} // end else-if
			else if (input ==3) {
				albumOptions(album3);
				
			} // end else-if
			
		} // end while
	} //end main
	
	// @params Album
	// takes the album chosen by the user and allows them to see favorite track
	// or change genre of that track.
	static void albumOptions(Album album) {
		System.out.println("\n"+album.toString());
		int choice =3;
		
		while (choice!=0) {
			System.out.println("\nAlbum options:");
			System.out.println("[1] Get Favorite Track\n[2] Change genre\n[0] return");
			System.out.print("Selection: ");
			
			choice = scanner.nextInt();
			
			if (choice == 1) {
				System.out.println("\nTrack No. "+album.getTrackNumber()+": "+album.getFavoriteTrack());
			} // end if
			else if(choice ==2) {
				System.out.print("\nNew genre: ");
				String genre = scanner.next();
				album.setGenre(genre);
			} // end else-if
		
		} // end while
	} // end albumOptions

}
