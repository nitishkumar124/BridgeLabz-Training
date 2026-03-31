package generics.smart_warehouse_system;

import java.util.*;

class WarehouseManager {
	public static void displayInventory(List<? extends WarehouseItem> items) {
		System.out.println("\n--- Current Inventory Report ---");
		for (WarehouseItem item : items) {
			System.out.println(item);
		}
		System.out.println("--------------------------------\n");
	}
}