package week8_multi_threading.online_auction_bidding_system;

class User implements Comparable<User> {
	private String userId;
	private String name;

	public User(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(User other) {
		return this.userId.compareTo(other.userId); 
	}

	@Override
	public String toString() {
		return name;
	}
}