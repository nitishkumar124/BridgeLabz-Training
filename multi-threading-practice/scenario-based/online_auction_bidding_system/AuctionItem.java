package week8_multi_threading.online_auction_bidding_system;

import java.util.TreeMap;

class AuctionItem {
	private String itemName;
	private TreeMap<User, Double> bids = new TreeMap<>();

	public AuctionItem(String itemName) {
		this.itemName = itemName;
	}

	public void placeBid(User user, double amount) throws InvalidBidException {
		double highestBid = getHighestBidAmount();

		if (amount <= highestBid) {
			throw new InvalidBidException("Bid must be higher than current highest bid: " + highestBid);
		}
		bids.put(user, amount);
		System.out.println(user + " placed bid: " + amount);
	}

	public double getHighestBidAmount() {
		return bids.values().stream().max(Double::compare).orElse(0.0);
	}

	public void showAllBids() {
		System.out.println("All bids for item: " + itemName);
		bids.forEach((user, amount) -> System.out.println(user + " -> " + amount));
	}
}