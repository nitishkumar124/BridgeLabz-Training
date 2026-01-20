package generics.smart_warehouse_system;

public class SmartWarehouseSystem {
	public static void main(String[] args) {

		Storage<Electronics> techStorage = new Storage<>();
		techStorage.addItem(new Electronics("Laptop", 1200.00));
		techStorage.addItem(new Electronics("Smartphone", 800.00));

		Storage<Furniture> homeStorage = new Storage<>();
		homeStorage.addItem(new Furniture("Office Chair", 150.00));

		WarehouseManager.displayInventory(techStorage.getItems());
		WarehouseManager.displayInventory(homeStorage.getItems());
	}
}