package level2;


public class CartItem {

	String itemName;
	double price;
	int quantity;

	public CartItem(String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		System.out.print("Item : " + itemName + ", ");
		System.out.print("Price : $" + price + ", ");
		System.out.println("Item : " + itemName);
	}

	void addItem(int a) {
		this.quantity += a;
		System.out.println("Added " + a + " of " + this.itemName + " to the cart.");
	}

	void removeCart(int r) {
		this.quantity -= r;
		System.out.println("Removed " + r + " of " + this.itemName + " from the cart.");
	}

	void totalCost() {
		System.out.println("Total Cost : $" + (this.quantity * this.price));
	}

	public static void main(String[] args) {
		CartItem cart = new CartItem("Laptop", 999.99, 1);
		cart.addItem(2);
		cart.removeCart(1);
		cart.totalCost();

	}
}
