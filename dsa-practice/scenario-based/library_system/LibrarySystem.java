package week3.library_system;

import java.util.*;

public class LibrarySystem {
	public static void main(String[] args) {
		BookShelf myLibrary = new BookShelf();


		myLibrary.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
		myLibrary.addBook(new Book("Dune", "Frank Herbert", "Sci-Fi"));
		myLibrary.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy"));


		myLibrary.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));

		myLibrary.displayCatalog();


		myLibrary.removeBook("Sci-Fi", "Dune");

		myLibrary.displayCatalog();
	}
}