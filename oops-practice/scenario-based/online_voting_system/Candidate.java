package week2.online_voting_system;

public class Candidate {
	private String candidateId;
	private String name;
	private String party;

	Candidate(String candidateId, String name, String party) {
		this.candidateId = candidateId;
		this.name = name;
		this.party = party;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public String getName() {
		return name;
	}

	public String getParty() {
		return party;
	}
}