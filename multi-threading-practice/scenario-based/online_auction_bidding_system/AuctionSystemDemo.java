package week8_multi_threading.online_auction_bidding_system;

public class AuctionSystemDemo {
	public static void main(String[] args) {
		AuctionItem item = new AuctionItem("iPhone 15");

		User u1 = new User("U101", "Alice");
		User u2 = new User("U102", "Bob");
		User u3 = new User("U103", "Charlie");

		try {
			item.placeBid(u1, 50000);
			item.placeBid(u2, 52000);
			item.placeBid(u3, 51000);
		} catch (InvalidBidException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Highest Bid: " + item.getHighestBidAmount());
		item.showAllBids();
	}
}