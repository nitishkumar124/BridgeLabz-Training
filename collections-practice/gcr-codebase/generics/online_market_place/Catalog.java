package generics.online_market_place;

import java.util.ArrayList;
import java.util.List;

class Catalog {

	private List<Product<? extends Category>> inventory = new ArrayList<>();

	public void addProduct(Product<? extends Category> product) {
		inventory.add(product);
	}

	public void showCatalog() {
		System.out.println("\n--- Marketplace Catalog ---");
		for (Product<? extends Category> p : inventory) {
			System.out.println(p);
		}
	}
}