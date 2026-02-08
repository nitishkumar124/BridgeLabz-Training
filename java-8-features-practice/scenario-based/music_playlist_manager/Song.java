package week6_java8.music_playlist_manager;

import java.util.*;

class Song {
	private String title;
	private String artist;

	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Song))
			return false;
		Song song = (Song) o;
		return title.equalsIgnoreCase(song.title) && artist.equalsIgnoreCase(song.artist);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title.toLowerCase(), artist.toLowerCase());
	}

	@Override
	public String toString() {
		return title + " by " + artist;
	}
}