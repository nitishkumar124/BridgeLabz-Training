package level1;

import java.util.*;

public class BankingSystem {

	public static void main(String[] args) {
		BankAccount savings = new SavingsAccount(101, "Aryansh",  1000);
		BankAccount current = new CurrentAccount(102, "Himanshu",  1500);
		savings.displayAccountDetails();
		savings.deposit(1000);
		current.displayAccountDetails();
		current.withdraw(1000);
	}
}

interface Loanable {
	public void appyForLoan();

	public void calculateLoanEligibility();
}

abstract class BankAccount implements Loanable {
	private int accountNumber;
	private String holderName;
	protected double balance;

	BankAccount(int accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	void displayAccountDetails() {
		System.out.println('\n' + "Account No.: " + accountNumber);
		System.out.println("Account Holder Name: " + holderName);
		System.out.println("Balance: " + balance);
	}

	void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited: $" + amount + " " + "Balance: $" + balance);
	}

	void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Withdrew: $" + amount + " " + "Balance: $" + balance);
		} else {
			System.out.println("Insufficient Balance.");
		}

	}

	abstract double calculateInterest();

	public void calculateLoanEligibility() {
		System.out.println("Eligible for loan.");
	}
}

class SavingsAccount extends BankAccount {

	SavingsAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	double calculateInterest() {
		return balance * 0.04;
	}

	@Override
	public void appyForLoan() {
		// TODO Auto-generated method stub

	}
}

class CurrentAccount extends BankAccount {

	CurrentAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	double calculateInterest() {
		return balance * 0.06;
	}

	@Override
	public void appyForLoan() {
		// TODO Auto-generated method stub

	}
}