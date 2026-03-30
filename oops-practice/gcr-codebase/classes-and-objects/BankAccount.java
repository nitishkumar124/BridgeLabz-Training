package level2;

public class BankAccount {
	String accountHolder;
	int accountNumber;
	double balance;

	void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited: " + amount);
	}

	void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Withdraw amount is : " + amount);
		} else {
			System.out.println("Insufficient balance");
		}
	}

	void showBalance() {
		System.out.println("Current balance: " + balance);
	}

	public static void main(String[] args) {
		BankAccount acc = new BankAccount();
		acc.balance = 700;

		acc.showBalance();
		acc.deposit(200);
		acc.showBalance();
		acc.withdraw(100);
		acc.showBalance();
		acc.withdraw(1000);
	}
}