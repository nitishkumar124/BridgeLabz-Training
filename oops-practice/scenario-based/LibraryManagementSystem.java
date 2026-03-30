package week2;

import java.util.Scanner;

public class LibraryManagementSystem {
	// Store books data in an Array
	private static Book[] books = { new Book("The Great Gatsby", "F. Scott Fitzgerald"),
			new Book("1984", "George Orwell"), new Book("The Hobbit", "J.R.R. Tolkien"),
			new Book("Java Programming", "John Smith") };

	public static void main(String[] args) {
		searchByTitle("1984");
		checkoutBook("The Hobbit");
		displayAllBooks();
	}

	// Search for partial title
	public static void searchByTitle(String query) {
		System.out.println("\n--- Search Results for '" + query + "' ---");
		for (Book b : books) {
			if (b.title.toLowerCase().contains(query.toLowerCase())) {
				b.displayInfo();
			}
		}
	}

	// Update book status
	public static void checkoutBook(String title) {
		for (Book b : books) {
			if (b.title.equalsIgnoreCase(title)) {
				if (b.isAvailable) {
					b.isAvailable = false;
					System.out.println("\nSuccessfully checked out: " + b.title);
				} else {
					System.out.println("\nSorry, " + b.title + " is already out.");
				}
				return;
			}
		}
		System.out.println("\nBook not found.");
	}

	public static void displayAllBooks() {
		System.out.println("\n--- Current Library Inventory ---");
		for (Book b : books) {
			b.displayInfo();
		}
	}
}

class Book {
	String title;
	String author;
	boolean isAvailable;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	public void displayInfo() {
		String status = isAvailable ? "[Available]" : "[Checked Out]";
		System.out.println(status + " " + title + " by " + author);
	}
}