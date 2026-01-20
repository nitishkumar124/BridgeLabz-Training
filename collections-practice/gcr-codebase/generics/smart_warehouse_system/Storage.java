package generics.smart_warehouse_system;

import java.util.ArrayList;
import java.util.List;

class Storage<T extends WarehouseItem> {
	private List<T> items = new ArrayList<>();

	public void addItem(T item) {
		items.add(item);
		System.out.println("Added to storage: " + item.getName());
	}

	public List<T> getItems() {
		return items;
	}
}