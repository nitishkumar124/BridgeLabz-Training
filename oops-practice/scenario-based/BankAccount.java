package week2;

public class BankAccount {
	String accountNumber;
	double balance;

	BankAccount(String accNo, double initialBal) {
		accountNumber = accNo;
		balance = initialBal;
	}

	void deposit(double amt) {
		if (amt <= 0) {
			System.out.println("Deposit amount should be positive");
			return;
		}
		balance += amt;
		System.out.println("Deposited: " + amt);
	}

	void withdraw(double amt) {
		if (amt <= 0) {
			System.out.println("Withdraw amount should be positive");
		} else if (amt > balance) {
			System.out.println("Insufficient balance");
		} else {
			balance -= amt;
			System.out.println("Withdrawn: " + amt);
		}
	}

	void checkBalance() {
		System.out.println("Current Balance: " + balance);
	}

	public static void main(String[] args) {
		BankAccount acc = new BankAccount("ACC101", 5000);
		acc.checkBalance();
		acc.deposit(2000);
		acc.withdraw(1000);
		acc.withdraw(7000);
		acc.checkBalance();
	}
}