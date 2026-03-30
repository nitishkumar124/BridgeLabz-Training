package week2.online_voting_system;

interface ElectionService {
	void registerVoter(Voter voter);

	void registerCandidate(Candidate candidate);

	void castVote(String voterId, String candidateId) throws DuplicateVoteException;

	void declareResults();
}