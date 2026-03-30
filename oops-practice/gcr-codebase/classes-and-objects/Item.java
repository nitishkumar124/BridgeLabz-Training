package level1;

class Item {
	String itemCode;
	String itemName;
	double price;

	Item(String itemCode, String itemName, double price) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}

	void displayItem() {
		System.out.println("itemCode : " + itemCode);
		System.out.println("itemPrice : " + price);
		System.out.println("itemName : " + itemName);
		System.out.println("----------------------------");
	}

	double calculateTotal(int quantity) {
		return this.price * quantity;
	}

	public static void main(String[] args) {
		Item item1 = new Item("01AA", "Water bottle", 500.0);
		Item item2 = new Item("01BB", "Rice", 700.0);
		Item item3 = new Item("02AA", "blackboard", 400.0);

		item1.displayItem();
		item2.displayItem();
		item3.displayItem();
	}
}