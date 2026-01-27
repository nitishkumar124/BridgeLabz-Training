package java_exceptions;

@SuppressWarnings("serial")
class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

class BankAccount {
	private double balance;

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient funds for withdrawal of " + amount);
		}
		balance -= amount;
	}
}

public class BankAccountMain {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(5000);

		try {
			account.withdraw(6000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
