package week6_java8.music_playlist_manager;

import java.util.*;

class PlaylistManager {
	private LinkedList<Song> playlist = new LinkedList<>();
	private Stack<Song> history = new Stack<>();
	private Set<Song> songLibrary = new HashSet<>();

	public void addSong(Song song) throws SongAlreadyExistsException {
		if (songLibrary.contains(song)) {
			throw new SongAlreadyExistsException("Conflict: '" + song.getTitle() + "' is already in the playlist.");
		}
		songLibrary.add(song);
		playlist.add(song);
		System.out.println("Added: " + song);
	}

	public void playNext() {
		if (playlist.isEmpty()) {
			System.out.println("Playlist is empty!");
			return;
		}

		Song currentSong = playlist.poll();
		System.out.println("Playing: " + currentSong);

		history.push(currentSong);
	}

	public void showHistory() {
		System.out.println("\n--- Recently Played (Newest First) ---");

		for (int i = history.size() - 1; i >= 0; i--) {
			System.out.println(history.get(i));
		}
	}
}