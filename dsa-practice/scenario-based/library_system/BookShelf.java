package week3.library_system;

import java.util.*;

public class BookShelf {
	private Map<String, LinkedList<Book>> catalog;
	private Set<Book> uniqueBooks;

	public BookShelf() {
		catalog = new HashMap<>();
		uniqueBooks = new HashSet<>();
	}

	public void addBook(Book book) {
		if (uniqueBooks.contains(book)) {
			System.out.println("Error: '" + book.getTitle() + "' already exists in the library.");
			return;
		}

		uniqueBooks.add(book);

		catalog.putIfAbsent(book.getGenre(), new LinkedList<>());
		catalog.get(book.getGenre()).add(book);
		System.out.println("Added: " + book.getTitle() + " to " + book.getGenre());
	}

	public void removeBook(String genre, String title) {
		if (catalog.containsKey(genre)) {
			LinkedList<Book> books = catalog.get(genre);
			boolean removed = books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));

			if (removed) {
				uniqueBooks.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
				System.out.println("Removed: " + title + " from " + genre);
			} else {
				System.out.println("Book not found in " + genre);
			}
		} else {
			System.out.println("Genre " + genre + " does not exist.");
		}
	}

	public void displayCatalog() {
		System.out.println("\n--- Library Catalog ---");
		if (catalog.isEmpty()) {
			System.out.println("The shelf is empty.");
		}
		for (Map.Entry<String, LinkedList<Book>> entry : catalog.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println("-----------------------\n");
	}
}