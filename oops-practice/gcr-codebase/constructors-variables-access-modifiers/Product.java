package level1;

import java.util.*;

public class Product {

	static int totalProducts = 0;

	String productName;
	int price;

	Product(String productName, int price) {
		totalProducts++;
		this.productName = productName;
		this.price = price;
	}

	void displayProductDetails() {
		System.out.println("Product Name: " + productName);
		System.out.println("Price: $" + price + "\n");
	}

	static void displayTotalProducts() {
		System.out.println("Total number of products: " + totalProducts);
	}

	public static void main(String[] args) {

		Product p1 = new Product("Laptop", 600);
		Product p2 = new Product("MacBook", 1200);
		Product p3 = new Product("Smartphone", 200);
		p1.displayProductDetails();
		p2.displayProductDetails();
		p3.displayProductDetails();
		Product.displayTotalProducts();
		
		
	}
}
