package collections.scenario_based;

import java.util.*;

public class ShoppingSystem {

	private Map<String, Double> inventory = new HashMap<>();

	private Map<String, Integer> cart = new LinkedHashMap<>();

	public ShoppingSystem() {

		inventory.put("Laptop", 1200.00);
		inventory.put("Mouse", 25.00);
		inventory.put("Keyboard", 75.00);
		inventory.put("Monitor", 300.00);
		inventory.put("USB Cable", 15.00);
	}

	public void addToCart(String itemName, int quantity) {
		if (inventory.containsKey(itemName)) {
			cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
			System.out.println("Added " + quantity + " x " + itemName + " to cart.");
		} else {
			System.out.println("Error: Item '" + itemName + "' not found in inventory.");
		}
	}

	public void displayCartInOrder() {
		System.out.println("\n--- Your Cart (Order Added) ---");
		cart.forEach((item, qty) -> System.out.println(item + " x" + qty));
	}

	public void displayItemsSortedByPrice() {
		System.out.println("\n--- Cart Items (Sorted by Price - Low to High) ---");

		TreeMap<Double, List<String>> priceMap = new TreeMap<>();

		for (String item : cart.keySet()) {
			double price = inventory.get(item);
			priceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(item);
		}

		priceMap.forEach((price, items) -> {
			for (String item : items) {
				System.out.println("$" + price + " : " + item);
			}
		});
	}

	public static void main(String[] args) {
		ShoppingSystem store = new ShoppingSystem();

		store.addToCart("Monitor", 1);
		store.addToCart("USB Cable", 2);
		store.addToCart("Laptop", 1);
		store.addToCart("Mouse", 1);

		store.displayCartInOrder();
		store.displayItemsSortedByPrice();
	}
}