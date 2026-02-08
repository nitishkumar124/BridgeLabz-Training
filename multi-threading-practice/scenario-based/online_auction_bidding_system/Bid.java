package week8_multi_threading.online_auction_bidding_system;

class Bid {
	private User user;
	private double amount;

	public Bid(User user, double amount) {
		this.user = user;
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public double getAmount() {
		return amount;
	}
}