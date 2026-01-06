package level1;

import java.util.*;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		LibraryItem[] inventory = { new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
				new DVD("D001", "Inception", "Christopher Nolan"),
				new Magazine("M001", "National Geographic", "Various") };

		System.out.println("--- Library Catalog ---");
		for (LibraryItem item : inventory) {
			item.getItemDetails();
			int days = item.getLoanDuration();

			if (days > 0) {
				System.out.println("Loan Period: " + days + " days.");
			} else {
				System.out.println("Status: Reference Only (No Loan).");
			}
			System.out.println();
		}
	}
}

interface Reservable {
	void reserveItem(String borrowerId);

	boolean checkAvailability();
}

abstract class LibraryItem {
	private String itemId;
	private String title;
	private String author;
	protected boolean isCheckedOut = false;

	public LibraryItem(String itemId, String title, String author) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
	}

	public void getItemDetails() {
		System.out.println("[" + itemId + "] " + title + " by " + author);
	}

	public abstract int getLoanDuration();

	public String getTitle() {
		return title;
	}

}

class Book extends LibraryItem implements Reservable {
	public Book(String id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 21;
	}

	@Override
	public void reserveItem(String borrowerId) {
		System.out.println("Book '" + getTitle() + "' reserved for: " + borrowerId);
	}

	@Override
	public boolean checkAvailability() {
		return !isCheckedOut;
	}
}

class DVD extends LibraryItem {
	public DVD(String id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 7;
	}
}

class Magazine extends LibraryItem {
	public Magazine(String id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 0;
	}
}