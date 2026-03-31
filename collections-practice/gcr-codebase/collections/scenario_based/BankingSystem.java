package collections.scenario_based;

import java.util.*;

class WithdrawalRequest {
	String accountNumber;
	double amount;

	public WithdrawalRequest(String accountNumber, double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
}

public class BankingSystem {

	private Map<String, Double> accounts = new HashMap<>();

	private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

	public void deposit(String accountNumber, double amount) {
		accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
		System.out.println("Deposited $" + amount + " to " + accountNumber);
	}

	public void requestWithdrawal(String accountNumber, double amount) {
		withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
		System.out.println("Withdrawal request queued: " + accountNumber + " for $" + amount);
	}

	public void processWithdrawals() {
		System.out.println("\n--- Processing Transaction Queue ---");
		while (!withdrawalQueue.isEmpty()) {
			WithdrawalRequest request = withdrawalQueue.poll();
			double currentBalance = accounts.getOrDefault(request.accountNumber, 0.0);

			if (currentBalance >= request.amount) {
				accounts.put(request.accountNumber, currentBalance - request.amount);
				System.out.println("SUCCESS: " + request.accountNumber + " withdrew $" + request.amount);
			} else {
				System.out.println("FAILED: Insufficient funds for " + request.accountNumber);
			}
		}
	}

	public void displayRichList() {
		System.out.println("\n--- Accounts Sorted by Balance (Highest First) ---");

		TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>(Collections.reverseOrder());

		for (Map.Entry<String, Double> entry : accounts.entrySet()) {
			sortedAccounts.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
		}

		sortedAccounts.forEach((balance, accountList) -> {
			for (String acc : accountList) {
				System.out.println("Balance: $" + balance + " | Account: " + acc);
			}
		});
	}

	public static void main(String[] args) {
		BankingSystem bank = new BankingSystem();

		bank.deposit("ACC101", 5000.0);
		bank.deposit("ACC102", 1500.0);
		bank.deposit("ACC103", 5000.0);
		bank.deposit("ACC104", 12000.0);

		bank.requestWithdrawal("ACC101", 2000.0);
		bank.requestWithdrawal("ACC102", 2000.0);
		bank.requestWithdrawal("ACC104", 500.0);

		bank.processWithdrawals();

		bank.displayRichList();
	}
}