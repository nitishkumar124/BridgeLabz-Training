package week2.online_voting_system;
//OOP: Voter Entity
class Voter {
 private String voterId;
 private String name;
 private boolean hasVoted = false;

 public Voter(String voterId, String name) {
     this.voterId = voterId;
     this.name = name;
 }

 public String getVoterId() { return voterId; }
 public String getName() { return name; }
 public boolean hasVoted() { return hasVoted; }
 public void setHasVoted(boolean status) { this.hasVoted = status; }
}