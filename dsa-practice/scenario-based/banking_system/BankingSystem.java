package week3.banking_system;

public class BankingSystem {
	public static void main(String[] args) {

		BankAccount savings = new SavingsAccount("12345", 1000.0);
		System.out.printf("Savings (1000): %.2f%n", savings.calculateFee());

		BankAccount s2 = new SavingsAccount("SAV-500", 500.0);
		System.out.printf("Savings (500): %.2f%n", s2.calculateFee());

		BankAccount c1 = new CheckingAccount("CHK-1500", 1500.0);
		System.out.printf("Checking (1500): %.2f%n", c1.calculateFee());

		BankAccount c2 = new CheckingAccount("CHK-500", 500.0);
		System.out.printf("Checking (500): %.2f%n", c2.calculateFee());
	}
}