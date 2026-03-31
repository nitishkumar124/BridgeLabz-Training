package generics.online_market_place;

interface Category {
	String getCategoryName();
}

class BookCategory implements Category {
	public String getCategoryName() {
		return "Books";
	}
}

class GadgetCategory implements Category {
	public String getCategoryName() {
		return "Electronics";
	}
}

class Product<T extends Category> {
	private String name;
	private double price;
	private T category;

	public Product(String name, double price, T category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s - $%.2f", category.getCategoryName(), name, price);
	}
}