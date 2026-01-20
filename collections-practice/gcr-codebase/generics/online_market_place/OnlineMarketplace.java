package generics.online_market_place;

public class OnlineMarketplace {
	public static void main(String[] args) {
		Catalog marketplace = new Catalog();

		Product<BookCategory> novel = new Product<>("Java Programming", 50.0, new BookCategory());
		Product<GadgetCategory> phone = new Product<>("Smartphone X", 999.99, new GadgetCategory());

		MarketplaceUtils.applyDiscount(novel, 10);
		MarketplaceUtils.applyDiscount(phone, 5);

		marketplace.addProduct(novel);
		marketplace.addProduct(phone);

		marketplace.showCatalog();
	}
}