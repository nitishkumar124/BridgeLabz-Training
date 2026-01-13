package week2.online_voting_system;

import java.util.*;

class SecureElectionService implements ElectionService {
	private Map<String, Voter> voters = new HashMap<>();
	private Map<String, Candidate> candidates = new HashMap<>();
	private Map<String, Integer> voteCounts = new HashMap<>();

	// CRUD: Voter Registration
	public void registerVoter(Voter voter) {
		voters.put(voter.getVoterId(), voter);
	}

	// CRUD: Candidate Management
	public void registerCandidate(Candidate candidate) {
		candidates.put(candidate.getCandidateId(), candidate);
		voteCounts.put(candidate.getCandidateId(), 0);
	}

	// Business Logic: Secure Vote Casting
	public void castVote(String voterId, String candidateId) throws DuplicateVoteException {
		Voter voter = voters.get(voterId);

		if (voter == null) {
			System.out.println("Voter not registered!");
			return;
		}
		if (voter.hasVoted()) {
			throw new DuplicateVoteException("SECURITY ALERT: Voter " + voterId + " has already cast a vote.");
		}
		if (!candidates.containsKey(candidateId)) {
			System.out.println("Invalid Candidate ID.");
			return;
		}

		// Logic: Record the vote
		voteCounts.put(candidateId, voteCounts.get(candidateId) + 1);
		voter.setHasVoted(true); // Mark as voted
		System.out.println("Vote cast successfully for: " + candidates.get(candidateId).getName());
	}

	// CRUD: Result Declaration
	public void declareResults() {
		System.out.println("\n===== ELECTION RESULTS =====");
		candidates.forEach((id, candidate) -> {
			System.out
					.println(candidate.getName() + " (" + candidate.getParty() + "): " + voteCounts.get(id) + " votes");
		});
		System.out.println("============================\n");
	}
}