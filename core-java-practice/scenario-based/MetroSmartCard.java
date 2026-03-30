package practice_problems;

import java.util.Scanner;

public class MetroSmartCard {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		double balance = getInitialBalance();

		while (balance > 0) {
			System.out.println("\nCurrent Balance: ₹" + balance);
			System.out.print("Enter travel distance in km (or -1 to exit): ");

			double distance = scanner.nextDouble();
			if (distance == -1)
				break;

			int fare = calculateFare(distance);

			if (balance >= fare) {
				balance -= fare;
				System.out.println("Fare Deducted: ₹" + fare);
				System.out.println("Remaining Balance: ₹" + balance);
			} else {
				System.out.println("Insufficient balance! Please top up your card.");
				System.out.println("Required: ₹" + fare + " | Available: ₹" + balance);
				break;
			}
		}

		System.out.println("Thank you for traveling with Delhi Metro!");
	}

	public static int calculateFare(double distance) {
		return (distance <= 10) ? 20 : (distance <= 25) ? 40 : 60;
	}

	public static double getInitialBalance() {
		System.out.print("Enter initial Smart Card balance: ₹");
		return scanner.nextDouble();
	}
}