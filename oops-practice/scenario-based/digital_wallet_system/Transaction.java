package week2.digital_wallet_system;
//OOP: Transaction Record
class Transaction {
 private String timestamp;
 private String type;
 private double amount;

 public Transaction(String type, double amount) {
     this.timestamp = new java.util.Date().toString();
     this.type = type;
     this.amount = amount;
 }

 @Override
 public String toString() {
     return "[" + timestamp + "] " + type + ": $" + amount;
 }
}

//OOP: Wallet Entity
