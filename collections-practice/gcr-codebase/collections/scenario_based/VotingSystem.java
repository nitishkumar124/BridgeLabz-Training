package collections.scenario_based;

import java.util.*;

public class VotingSystem {

	private Map<String, Integer> voteTally = new HashMap<>();

	private Map<String, String> voteHistory = new LinkedHashMap<>();

	private int voteIdCounter = 1;

	public void castVote(String candidate) {

		voteTally.put(candidate, voteTally.getOrDefault(candidate, 0) + 1);

		String voteId = "VOTE_" + (voteIdCounter++);
		voteHistory.put(voteId, candidate);
	}

	public void displayAlphabeticalResults() {
		System.out.println("\n--- Election Results (Alphabetical) ---");

		TreeMap<String, Integer> sortedResults = new TreeMap<>(voteTally);
		sortedResults.forEach((name, votes) -> System.out.println(name + ": " + votes + " votes"));
	}

	public void displayVoteHistory() {
		System.out.println("\n--- Live Vote Feed (Chronological) ---");
		voteHistory.forEach((id, candidate) -> System.out.println(id + " cast for: " + candidate));
	}

	public static void main(String[] args) {
		VotingSystem election = new VotingSystem();

		election.castVote("Alice");
		election.castVote("Bob");
		election.castVote("Alice");
		election.castVote("Charlie");
		election.castVote("Bob");

		election.displayVoteHistory();
		election.displayAlphabeticalResults();
	}
}