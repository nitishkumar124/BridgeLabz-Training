package week2.smart_shelf;

import java.util.*;

public class SmartLibrary {
	public static void main(String[] args) {
		ReadingList myKiosk = new ReadingList();

		// Adding books one by one (Simulating Real-time)
		myKiosk.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
		myKiosk.addBook(new Book("A Tale of Two Cities", "Charles Dickens"));
		myKiosk.addBook(new Book("Zeno's Conscience", "Italo Svevo"));
		myKiosk.addBook(new Book("Great Expectations", "Charles Dickens"));

		myKiosk.displayList();
	}
}
