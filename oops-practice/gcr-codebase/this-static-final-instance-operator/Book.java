package level1;

class Book {
	static String libraryName = "GLA Library";

	final int isbn;
	String title;
	String author;

	public Book(String title, String author, int isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public static void displayLibraryName() {
		System.out.println("Library Name: " + libraryName);
	}

	public void displayDetails() {
		System.out.println("Title: " + this.title);
		System.out.println("Author: " + this.author);
		System.out.println("ISBN: " + this.isbn);
	}

	public static void main(String[] args) {
		Book myBook = new Book("Fundamentals Java", "Aryansh Baloch", 9785991);

		Book.displayLibraryName();
		if (myBook instanceof Book) {
			myBook.displayDetails();
		}
	}
}