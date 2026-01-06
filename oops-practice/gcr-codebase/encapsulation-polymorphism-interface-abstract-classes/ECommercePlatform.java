package level1;

import java.util.*;

public class ECommercePlatform {
//	Description: Develop a simplified e-commerce platform:
//		Create an abstract class Product with fields like productId, name, and price, and an abstract method calculateDiscount().
//		Extend it into concrete classes: Electronics, Clothing, and Groceries.
//		Implement an interface Taxable with methods calculateTax() and getTaxDetails() for applicable product categories.
//		Use encapsulation to protect product details, allowing updates only through setter methods.
//		Showcase polymorphism by creating a method that calculates and prints the final price (price + tax - discount) for a list of Product.
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Electronics(101, "SmartPhone", 900));
		products.add(new Clothing(102, "Hoodie", 199));
		products.add(new Groceries(103, "Rice", 50));

		for (Product p : products) {
			p.displayProductDetails();
		}
	}
}

interface Taxable {
	void calculateTax();

	void getTaxDetails();
}

abstract class Product {
	int productID;
	String name;
	double price;
	double tax = 0;

	Product(int productID, String name, double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
	}

	abstract double calculateDiscount();

	void displayProductDetails() {
		System.out.println('\n' + "Name: " + name);
		System.out.println("Product ID: " + productID);
		System.out.println("Price: $" + price);
		System.out.println("Final Price(including tax): $" + getFinalPrice());
	}

	double getFinalPrice() {
		return tax + calculateDiscount();
	}
}

class Electronics extends Product implements Taxable {

	public Electronics(int productID, String name, double price) {
		super(productID, name, price);
		calculateTax();
	}

	double calculateDiscount() {
		return price * .75;
	}

	public void calculateTax() {
		tax = calculateDiscount() * .18;
	}

	@Override
	public void getTaxDetails() {
		System.out.println("Tax: $" + tax);

	}
}

class Clothing extends Product implements Taxable {

	public Clothing(int productID, String name, double price) {
		super(productID, name, price);
		calculateTax();
	}

	double calculateDiscount() {
		return price * .65;
	}

	public void calculateTax() {
		tax = calculateDiscount() * .10;
	}

	@Override
	public void getTaxDetails() {
		System.out.println("Tax: $" + tax);

	}
}

class Groceries extends Product implements Taxable {

	public Groceries(int productID, String name, double price) {
		super(productID, name, price);
	}

	double calculateDiscount() {
		return price * .85;
	}
	
	public void calculateTax() {
		tax = calculateDiscount() * .5;
	}

	@Override
	public void getTaxDetails() {
		System.out.println("Tax: $" + tax);

	}
}
