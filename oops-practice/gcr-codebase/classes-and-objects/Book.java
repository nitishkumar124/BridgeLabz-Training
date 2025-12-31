package level1;

class Book {
	String title;
	String author;
	double price;

	Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	void displayBookInfo() {
		System.out.println("Title : " + title);
		System.out.println("Author : " + author);
		System.out.println("Price : " + price);
	}

	public static void main(String[] args) {
		Book book1 = new Book("2States", "Chetan Bhagat", 500.0);

		Book book2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);

		book1.displayBookInfo();
		System.out.println();
		book2.displayBookInfo();
	}
}
