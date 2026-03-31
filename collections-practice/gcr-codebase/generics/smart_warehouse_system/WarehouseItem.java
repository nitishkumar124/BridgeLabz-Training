package generics.smart_warehouse_system;

abstract class WarehouseItem {
	private String name;
	private double price;

	public WarehouseItem(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + name + " ($" + price + ")";
	}
}

class Electronics extends WarehouseItem {
	public Electronics(String name, double price) {
		super(name, price);
	}
}

class Groceries extends WarehouseItem {
	public Groceries(String name, double price) {
		super(name, price);
	}
}

class Furniture extends WarehouseItem {
	public Furniture(String name, double price) {
		super(name, price);
	}
}