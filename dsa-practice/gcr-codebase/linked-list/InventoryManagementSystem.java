package linked_list;

public class InventoryManagementSystem {
	public static void main(String[] args) {
		InventoryManager inventory = new InventoryManager();

		// Sample Data
		inventory.addItem("Laptop", 101, 10, 800.00, 1);
		inventory.addItem("Mouse", 102, 50, 25.50, 2);
		inventory.addItem("Keyboard", 103, 30, 45.00, 2); // Insert Keyboard at position 2

		inventory.displayAll();

		System.out.println("\nSearching for 'Mouse':");
		inventory.search("Mouse");

		inventory.updateQuantity(101, 12);

		System.out.println("\nSorting by Price (Descending):");
		inventory.sortInventory(true, false);
		inventory.displayAll();

		inventory.displayTotalValue();
	}
}

class Item {
	String name;
	int id;
	int quantity;
	double price;
	Item next;

	public Item(String name, int id, int quantity, double price) {
		this.name = name;
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}
}

class InventoryManager {
	private Item head;

	// 1. Add Item (Beginning, End, or Specific Position)
	public void addItem(String name, int id, int quantity, double price, int pos) {
		Item newItem = new Item(name, id, quantity, price);

		if (pos <= 1 || head == null) {
			newItem.next = head;
			head = newItem;
			return;
		}

		Item temp = head;
		for (int i = 1; i < pos - 1 && temp.next != null; i++) {
			temp = temp.next;
		}
		newItem.next = temp.next;
		temp.next = newItem;
		System.out.println("Item added successfully.");
	}

	// 2. Remove Item by ID
	public void removeItem(int id) {
		if (head == null)
			return;

		if (head.id == id) {
			head = head.next;
			return;
		}

		Item temp = head;
		while (temp.next != null && temp.next.id != id) {
			temp = temp.next;
		}

		if (temp.next != null) {
			temp.next = temp.next.next;
			System.out.println("Item ID " + id + " removed.");
		} else {
			System.out.println("Item not found.");
		}
	}

	// 3. Update Quantity
	public void updateQuantity(int id, int newQty) {
		Item temp = head;
		while (temp != null) {
			if (temp.id == id) {
				temp.quantity = newQty;
				System.out.println("Quantity updated.");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Item not found.");
	}

	// 4. Search by ID or Name
	public void search(String query) {
		Item temp = head;
		boolean found = false;
		while (temp != null) {
			if (String.valueOf(temp.id).equals(query) || temp.name.equalsIgnoreCase(query)) {
				System.out.println("Found: " + temp.name + " | ID: " + temp.id + " | Qty: " + temp.quantity
						+ " | Price: $" + temp.price);
				found = true;
			}
			temp = temp.next;
		}
		if (!found)
			System.out.println("No matching item found.");
	}

	// 5. Calculate Total Inventory Value
	public void displayTotalValue() {
		double total = 0;
		Item temp = head;
		while (temp != null) {
			total += (temp.price * temp.quantity);
			temp = temp.next;
		}
		System.out.println("\nTotal Inventory Value: $" + String.format("%.2f", total));
	}

	// 6. Sort Inventory (Bubble Sort)
	public void sortInventory(boolean sortByPrice, boolean ascending) {
		if (head == null || head.next == null)
			return;

		boolean swapped;
		do {
			swapped = false;
			Item current = head;
			while (current.next != null) {
				boolean condition = false;
				if (sortByPrice) {
					condition = ascending ? (current.price > current.next.price) : (current.price < current.next.price);
				} else {
					condition = ascending ? (current.name.compareToIgnoreCase(current.next.name) > 0)
							: (current.name.compareToIgnoreCase(current.next.name) < 0);
				}

				if (condition) {
					// Swap data fields
					String tName = current.name;
					current.name = current.next.name;
					current.next.name = tName;
					int tId = current.id;
					current.id = current.next.id;
					current.next.id = tId;
					int tQty = current.quantity;
					current.quantity = current.next.quantity;
					current.next.quantity = tQty;
					double tPrice = current.price;
					current.price = current.next.price;
					current.next.price = tPrice;
					swapped = true;
				}
				current = current.next;
			}
		} while (swapped);
		System.out.println("Inventory sorted.");
	}

	public void displayAll() {
		if (head == null) {
			System.out.println("Inventory is empty.");
			return;
		}
		Item temp = head;
		System.out.println("\n--- Current Inventory ---");
		while (temp != null) {
			System.out.printf("ID: %d | Name: %-10s | Qty: %d | Price: $%.2f\n", temp.id, temp.name, temp.quantity,
					temp.price);
			temp = temp.next;
		}
	}
}