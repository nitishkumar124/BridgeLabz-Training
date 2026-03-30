package week2;

import java.util.*;

public class LibraryManager {
	// Store book data
	private Book1[] inventory = { new Book1("The Great Gatsby", "F. Scott Fitzgerald"),
			new Book1("1984", "George Orwell"), new Book1("The Hobbit", "J.R.R. Tolkien"),
			new Book1("Java Programming", "John Smith") };

	public static void main(String[] args) {
		LibraryManager lib = new LibraryManager();

		lib.searchByTitle("1984");

		try {
			lib.checkoutBook("1984");
			lib.checkoutBook("1984");
		} catch (BookNotAvailableException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	// Search by partial title using
	public void searchByTitle(String query) {
		// Store results
		List<Book1> results = new ArrayList<>();

		for (Book1 b : inventory) {
			if (b.getTitle().toLowerCase().contains(query.toLowerCase())) {
				results.add(b);
			}
		}

		System.out.println("Search results for '" + query + "':");
		results.forEach(System.out::println);
	}

	// Update book status
	public void checkoutBook(String exactTitle) throws BookNotAvailableException {
		for (Book1 b : inventory) {
			if (b.getTitle().equalsIgnoreCase(exactTitle)) {
				if (!b.isAvailable()) {
					throw new BookNotAvailableException("The book '" + exactTitle + "' is already checked out.");
				}
				b.setAvailable(false);
				System.out.println("Successfully checked out: " + exactTitle);
				return;
			}
		}
		System.out.println("Book not found in inventory.");
	}
}

// Custom Exception
class BookNotAvailableException extends Exception {
	public BookNotAvailableException(String message) {
		super(message);
	}
}

class Book1 {
	private String title;
	private String author;
	private boolean isAvailable;

	public Book1(String title, String author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean status) {
		this.isAvailable = status;
	}

	@Override
	public String toString() {
		return (isAvailable ? "[Available] " : "[Checked Out] ") + title + " by " + author;
	}
}
