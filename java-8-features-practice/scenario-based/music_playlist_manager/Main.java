package week6_java8.music_playlist_manager;

public class Main {
	public static void main(String[] args) {
		PlaylistManager myApp = new PlaylistManager();

		Song s1 = new Song("Blinding Lights", "The Weeknd");
		Song s2 = new Song("Levitating", "Dua Lipa");

		try {
			myApp.addSong(s1);
			myApp.addSong(s2);

			myApp.addSong(new Song("Blinding Lights", "The Weeknd"));
		} catch (SongAlreadyExistsException e) {
			System.err.println("User Error: " + e.getMessage());
		}

		myApp.playNext();
		myApp.playNext();

		myApp.showHistory();
	}
}