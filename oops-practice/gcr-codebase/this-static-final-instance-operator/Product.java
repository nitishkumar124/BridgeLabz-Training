package level1;

import java.util.*;

public class Product {

	static double discount = 25;

	String productName;
	double price;
	int quantity;
	final int productID;

	static void updateDiscount(double d) {
		discount = d;
		System.out.println("Updated Discount Rate: " + discount + "%\n");
	}

	Product(String productName, double price, int quantity, int productID) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productID = productID;
	}

	void displayProductDetails() {
		double discountedPrice = ((100.0 - discount) / 100.0) * price;
		System.out.println("Product ID: " + productID);
		System.out.println("Product Name: " + productName);
		System.out.println("Price: $" + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Discount: " + discount + "%");
		System.out.println("Price after Discount: $" + discountedPrice + "\n");
	}

	public static void main(String[] args) {
		Product p1 = new Product("Smartphone", 1200, 1, 101);
		Product p2 = new Product("Earbuds", 100, 1, 183);

		if (p1 instanceof Product)
			p1.displayProductDetails();

		Product.updateDiscount(30);

		if (p2 instanceof Product)
			p2.displayProductDetails();
	}
}
