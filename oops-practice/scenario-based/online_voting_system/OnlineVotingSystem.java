package week2.online_voting_system;

public class OnlineVotingSystem {
	public static void main(String[] args) {
		ElectionService election = new SecureElectionService();

		// 1. Setup Candidates
		election.registerCandidate(new Candidate("C1", "Alice Smith", "Tech Party"));
		election.registerCandidate(new Candidate("C2", "Bob Jones", "Logic Party"));

		// 2. Register Voters
		Voter v1 = new Voter("V101", "Charlie");
		Voter v2 = new Voter("V102", "Diana");
		election.registerVoter(v1);
		election.registerVoter(v2);

		try {
			// 3. Successful Voting
			election.castVote("V101", "C1");
			election.castVote("V102", "C2");

			// 4. Duplicate Vote Attempt
			System.out.println("Attempting to vote again for Charlie...");
			election.castVote("V101", "C2");

		} catch (DuplicateVoteException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		// 5. Declare Results
		election.declareResults();
	}
}