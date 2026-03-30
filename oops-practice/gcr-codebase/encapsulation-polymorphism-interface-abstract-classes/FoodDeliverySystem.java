package level1;

import java.util.*;

public class FoodDeliverySystem {
	public static void main(String[] args) {
		FoodItem[] myOrder = { new VegItem("Paneer Tikka", 12.00, 2), new NonVegItem("Chicken Burger", 15.00, 1),
				new VegItem("Garlic Bread", 5.50, 1) };

		if (myOrder[0] instanceof Discountable) {
			((Discountable) myOrder[0]).applyDiscount(10);
		}

		processOrder(myOrder);
	}

	public static void processOrder(FoodItem[] items) {
		double grandTotal = 0;
		System.out.println("--- Processing Your Order ---");

		for (FoodItem item : items) {
			item.getItemDetails();
			double total = item.calculateTotalPrice();
			System.out.println("Line Total: $" + total);
			grandTotal += total;
		}

		System.out.println("-----------------------------");
		System.out.printf("GRAND TOTAL: $%.2f%n", grandTotal);
	}
}

//Interface
interface Discountable {
	void applyDiscount(double percentage);

	String getDiscountDetails();
}

//Abstract class
abstract class FoodItem {
	private String itemName;
	private double price;
	private int quantity;

	public FoodItem(String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = (quantity > 0) ? quantity : 1;
	}

	// Concrete method
	public void getItemDetails() {
		System.out.printf("Item: %-15s | Base Price: $%.2f | Qty: %d%n", itemName, price, quantity);
	}

	// Abstract method
	public abstract double calculateTotalPrice();

	// Getters
	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
}

class VegItem extends FoodItem implements Discountable {
	private double discountApplied = 0;

	public VegItem(String name, double price, int qty) {
		super(name, price, qty);
	}

	@Override
	public double calculateTotalPrice() {
		return (getPrice() * getQuantity()) - discountApplied;
	}

	@Override
	public void applyDiscount(double percentage) {
		this.discountApplied = (getPrice() * getQuantity()) * (percentage / 100);
	}

	@Override
	public String getDiscountDetails() {
		return "Veg Promo applied: -$" + discountApplied;
	}
}

class NonVegItem extends FoodItem {
	private final double SURCHARGE = 2.50;

	public NonVegItem(String name, double price, int qty) {
		super(name, price, qty);
	}

	@Override
	public double calculateTotalPrice() {

		return (getPrice() + SURCHARGE) * getQuantity();
	}
}
