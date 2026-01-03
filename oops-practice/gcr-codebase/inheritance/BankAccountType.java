package level1;

public class BankAccountType {
	public static void main(String[] args) {
		BankAccount a1 = new SavingsAccount();
		BankAccount a2 = new CheckingAccount();
		BankAccount a3 = new FixedDepositAccount();

		((SavingsAccount) a1).displayAccountType();
		((CheckingAccount) a2).displayAccountType();
		((FixedDepositAccount) a3).displayAccountType();
	}
}

class BankAccount {
	String accountNumber;
}

class SavingsAccount extends BankAccount {
	void displayAccountType() {
		System.out.println("Savings Account");
	}
}

class CheckingAccount extends BankAccount {
	void displayAccountType() {
		System.out.println("Checking Account");
	}
}

class FixedDepositAccount extends BankAccount {
	void displayAccountType() {
		System.out.println("Fixed Deposit Account");
	}
}