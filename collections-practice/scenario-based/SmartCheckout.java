package week4_collections;

import java.util.*;

class Item {
	double price;
	int stock;

	Item(double price, int stock) {
		this.price = price;
		this.stock = stock;
	}
}

class Customer {
	String name;
	List<String> shoppingList;

	Customer(String name, List<String> items) {
		this.name = name;
		this.shoppingList = items;
	}
}

public class SmartCheckout {

	private Map<String, Item> inventory = new HashMap<>();

	private Queue<Customer> queue = new LinkedList<>();

	public void setupInventory() {
		inventory.put("Milk", new Item(2.50, 50));
		inventory.put("Bread", new Item(1.80, 30));
		inventory.put("Eggs", new Item(4.00, 20));
		inventory.put("Apple", new Item(0.50, 100));
	}

	public void addCustomer(Customer customer) {
		queue.add(customer);
		System.out.println("Customer " + customer.name + " joined the queue.");
	}

	public void processNextCustomer() {
		if (queue.isEmpty()) {
			System.out.println("No customers in queue.");
			return;
		}

		Customer currentCustomer = queue.poll();
		double totalBill = 0.0;

		System.out.println("\n--- Processing: " + currentCustomer.name + " ---");

		for (String itemName : currentCustomer.shoppingList) {
			if (inventory.containsKey(itemName)) {
				Item item = inventory.get(itemName);

				if (item.stock > 0) {
					totalBill += item.price;
					item.stock--;
					System.out.println(itemName + ": $" + item.price + " (Stock left: " + item.stock + ")");
				} else {
					System.out.println(itemName + ": Out of stock!");
				}
			} else {
				System.out.println(itemName + ": Not found in store.");
			}
		}
		System.out.println("Total Bill for " + currentCustomer.name + ": $" + totalBill);
	}

	public static void main(String[] args) {
		SmartCheckout checkout = new SmartCheckout();
		checkout.setupInventory();

		checkout.addCustomer(new Customer("Alice", Arrays.asList("Milk", "Bread", "Apple")));
		checkout.addCustomer(new Customer("Bob", Arrays.asList("Eggs", "Milk", "Chocolate")));

		checkout.processNextCustomer();
		checkout.processNextCustomer();
	}
}
