package generics.online_market_place;

class MarketplaceUtils {

	public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
		double discountAmount = product.getPrice() * (percentage / 100);
		double newPrice = product.getPrice() - discountAmount;
		product.setPrice(newPrice);

		System.out.println("Applied " + percentage + "% discount to: " + product.getName());
	}
}