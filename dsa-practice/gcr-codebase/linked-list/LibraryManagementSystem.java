package linked_list;

import java.util.*;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		LibrarySystem lib = new LibrarySystem();
		lib.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 101, 1);
		lib.addBook("1984", "George Orwell", "Dystopian", 102, 2);
		lib.addBook("The Hobbit", "J.R.R. Tolkien", "Fantasy", 103, 1);

		lib.displayForward();
		System.out.println("Total books: " + lib.getBookCount());

		lib.updateStatus(102, false);
		lib.removeBook(101);

		lib.displayReverse();
	}
}

class Book {
	String title;
	String author;
	String genre;
	int bookId;
	boolean isAvailable;
	Book next;
	Book prev;

	public Book(String title, String author, String genre, int bookId) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.bookId = bookId;
		this.isAvailable = true; 
		this.next = null;
		this.prev = null;
	}
}

class LibrarySystem {
	private Book head;
	private Book tail;
	private int totalBooks;

	public LibrarySystem() {
		this.head = null;
		this.tail = null;
		this.totalBooks = 0;
	}

	// Add Book (Beginning, End, or Position)
	public void addBook(String title, String author, String genre, int id, int pos) {
		Book newBook = new Book(title, author, genre, id);

		if (head == null) {
			head = tail = newBook;
		} else if (pos <= 1) { 
			newBook.next = head;
			head.prev = newBook;
			head = newBook;
		} else {
			Book temp = head;
			int currentPos = 1;
			while (temp.next != null && currentPos < pos - 1) {
				temp = temp.next;
				currentPos++;
			}
			newBook.next = temp.next;
			newBook.prev = temp;
			if (temp.next != null) {
				temp.next.prev = newBook;
			} else {
				tail = newBook;
			}
			temp.next = newBook;
		}
		totalBooks++;
	}

	// Remove Book by ID
	public void removeBook(int id) {
		Book current = head;
		while (current != null) {
			if (current.bookId == id) {
				if (current == head) {
					head = head.next;
					if (head != null)
						head.prev = null;
					else
						tail = null; 
				} else if (current == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				totalBooks--;
				System.out.println("Book ID " + id + " removed.");
				return;
			}
			current = current.next;
		}
		System.out.println("Book ID " + id + " not found.");
	}

	// Search by Title or Author
	public void search(String query) {
		Book temp = head;
		boolean found = false;
		while (temp != null) {
			if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
				System.out.println(
						"Found: [" + temp.bookId + "] " + temp.title + " by " + temp.author + " (" + temp.genre + ")");
				found = true;
			}
			temp = temp.next;
		}
		if (!found)
			System.out.println("No matching books found.");
	}

	// Update Availability
	public void updateStatus(int id, boolean status) {
		Book temp = head;
		while (temp != null) {
			if (temp.bookId == id) {
				temp.isAvailable = status;
				System.out.println("Status updated for: " + temp.title);
				return;
			}
			temp = temp.next;
		}
	}

	// Display Records
	public void displayForward() {
		System.out.println("\n--- Library Inventory (Forward) ---");
		Book temp = head;
		while (temp != null) {
			System.out.println(temp.title + " | Status: " + (temp.isAvailable ? "Available" : "Checked Out"));
			temp = temp.next;
		}
	}

	public void displayReverse() {
		System.out.println("\n--- Library Inventory (Reverse) ---");
		Book temp = tail;
		while (temp != null) {
			System.out.println(temp.title + " | ID: " + temp.bookId);
			temp = temp.prev;
		}
	}

	// Count Books
	public int getBookCount() {
		return totalBooks;
	}
}
