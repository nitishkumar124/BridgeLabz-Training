package week3.library_system;

import java.util.Objects;

public class Book {
	private String title;
	private String author;
	private String genre;

	public Book(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Book))
			return false;
		Book book = (Book) o;
		return Objects.equals(title.toLowerCase(), book.title.toLowerCase());
	}

	@Override
	public int hashCode() {
		return Objects.hash(title.toLowerCase());
	}

	@Override
	public String toString() {
		return String.format("[%s by %s]", title, author);
	}
}