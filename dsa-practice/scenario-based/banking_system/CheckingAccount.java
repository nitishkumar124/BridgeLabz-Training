package week3.banking_system;

public class CheckingAccount extends BankAccount {
	public CheckingAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

	@Override
	public double calculateFee() {
		if (getBalance() < 1000.0) {
			return 1.0;
		}
		return 0.0;
	}
}