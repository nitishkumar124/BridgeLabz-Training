package level1;

import java.util.*;

public class BankAccount {

	public int accountNumber;
	protected String accountHolder;
	private double balance;

	BankAccount(int accountNumber, String accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
		System.out.println("Balance updated: " + this.balance);
	}

	public static void main(String[] args) {
		SavingsAccount savings = new SavingsAccount(1245, "Rachit", 124512);
		System.out.println("AccountHolder: " + savings.getAccountHolder());
		System.out.println("AccountNumber: " + savings.getAccountNumber());
		System.out.println("Balance: " + savings.getBalance());
		savings.setBalance(451145);
	}
}

class SavingsAccount extends BankAccount {
	public SavingsAccount(int accountNumber, String accountHolder, double balance) {
		super(accountNumber, accountHolder, balance);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}
}
