package level1;

public class Book {

	protected String title;
	private String author;
	public double price;
	boolean availability = true;
	public String ISBN;

	Book() {
		this.title = "Book1";
		this.author = "Author1";
		this.price = 99.99;
	}

	Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public void setAuthor(String a) {
		author = a;
	}

	public String getAuthor() {
		return author;
	}

	void borrow() {
		if (this.availability) {
			System.out.println("Book Borrowed : " + this.title);
			this.availability = false;
		} else {
			System.out.println("Book NOT available to be borrowed.");
		}
	}

	public static void main(String[] args) {
//		Book b1 = new Book();
//		Book b2 = new Book("Fire and Ash", "James Cameroon", 199);			
//		b2.borrow();
//		b2.borrow();
		
		EBook e = new EBook();
		e.ISBN = "012026";
		e.title = "New Year Starts Today";
		e.setAuthor("Dave");
		e.getISBN();
		e.getTitle();
		System.out.println("Author: " + e.getAuthor());

	}
}

class EBook extends Book {
	public void getISBN() {
		System.out.println("ISBN: " + ISBN);
	}

	public void getTitle() {
		System.out.println("Title: " + title);
	}
}
