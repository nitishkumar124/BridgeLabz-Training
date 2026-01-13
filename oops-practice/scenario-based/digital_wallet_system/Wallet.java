package week2.digital_wallet_system;
import java.util.ArrayList;
import java.util.List;

class Wallet {
	 private double balance;
	 private List<Transaction> history = new ArrayList<>();

	 public void deposit(double amount) {
	     balance += amount;
	     history.add(new Transaction("DEPOSIT", amount));
	 }

	 public void withdraw(double amount) throws InsufficientBalanceException {
	     if (amount > balance) throw new InsufficientBalanceException("Insufficient funds!");
	     balance -= amount;
	     history.add(new Transaction("WITHDRAWAL", amount));
	 }

	 public double getBalance() { return balance; }
	 public List<Transaction> getHistory() { return history; }
	}