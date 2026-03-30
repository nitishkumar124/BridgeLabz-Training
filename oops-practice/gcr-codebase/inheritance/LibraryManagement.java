package level1;

public class LibraryManagement {
	public static void main(String[] args) {
		Author a = new Author("Java Basics", 2024, "James", "Java Expert");
		a.display();
	}
}

class Book {
	String title;
	int year;

	Book(String title, int year) {
		this.title = title;
		this.year = year;
	}
}

class Author extends Book {
	String name;
	String bio;

	Author(String title, int year, String name, String bio) {
		super(title, year);
		this.name = name;
		this.bio = bio;
	}

	void display() {
		System.out.println("Book: " + title);
		System.out.println("Year: " + year);
		System.out.println("Author: " + name);
		System.out.println("Bio: " + bio);
	}
}