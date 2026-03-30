package week2.online_voting_system;

class DuplicateVoteException extends Exception {
	public DuplicateVoteException(String message) {
		super(message);
	}
}