package linked_list;

import java.util.*;

public class MovieManagementSystem {
	public static void main(String[] args) {
		MovieManager list = new MovieManager();
		list.addMovie("Inception", "Nolan", 2010, 8.8, 1);
		list.addMovie("The Matrix", "Wachowskis", 1999, 8.7, 2);
		list.addMovie("Interstellar", "Nolan", 2014, 8.6, 2);

		list.displayForward();
		list.displayReverse();

		list.search("Nolan", null);
		list.removeMovie("The Matrix");
		list.displayForward();
	}
}

class Movie {
	String title;
	String director;
	int year;
	double rating;
	Movie next;
	Movie prev;

	public Movie(String title, String director, int year, double rating) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.rating = rating;
		this.next = null;
		this.prev = null;
	}
}

class MovieManager {
	private Movie head;
	private Movie tail;

	// Add Movie
	public void addMovie(String title, String director, int year, double rating, int pos) {
		Movie newMessage = new Movie(title, director, year, rating);
		
		if (head == null) {
			head = tail = newMessage;
			return;
		}

		if (pos <= 1) {
			newMessage.next = head;
			head.prev = newMessage;
			head = newMessage;
			return;
		}

		Movie temp = head;
		int currentPos = 1;
		while (temp.next != null && currentPos < pos - 1) {
			temp = temp.next;
			currentPos++;
		}

		newMessage.next = temp.next;
		newMessage.prev = temp;

		if (temp.next != null) {
			temp.next.prev = newMessage;
		} else {
			tail = newMessage; 
		}
		temp.next = newMessage;
	}

	// Remove Movie by Title
	public void removeMovie(String title) {
		Movie temp = head;
		while (temp != null) {
			if (temp.title.equalsIgnoreCase(title)) {
				if (temp == head) {
					head = head.next;
					if (head != null)
						head.prev = null;
				} else if (temp == tail) {
					tail = tail.prev;
					if (tail != null)
						tail.next = null;
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				System.out.println("Removed: " + title);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Movie not found.");
	}

	// Search by Director or Rating
	public void search(String director, Double rating) {
		Movie temp = head;
		boolean found = false;
		while (temp != null) {
			if ((director != null && temp.director.equalsIgnoreCase(director))
					|| (rating != null && temp.rating == rating)) {
				System.out.println("Found: " + temp.title + " (" + temp.year + ") - Directed by: " + temp.director);
				found = true;
			}
			temp = temp.next;
		}
		if (!found)
			System.out.println("No movies matching the criteria.");
	}

	// Display Forward and Reverse
	public void displayForward() {
		System.out.println("\n--- Movies (Forward) ---");
		Movie temp = head;
		while (temp != null) {
			System.out.println(temp.title + " | " + temp.rating);
			temp = temp.next;
		}
	}

	public void displayReverse() {
		System.out.println("\n--- Movies (Reverse) ---");
		Movie temp = tail;
		while (temp != null) {
			System.out.println(temp.title + " | " + temp.rating);
			temp = temp.prev;
		}
	}

	// Update Rating
	public void updateRating(String title, double newRating) {
		Movie temp = head;
		while (temp != null) {
			if (temp.title.equalsIgnoreCase(title)) {
				temp.rating = newRating;
				System.out.println("Rating updated for " + title);
				return;
			}
			temp = temp.next;
		}
	}
}
