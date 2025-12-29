package extras2;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a positive integer to check: ");
		if (scanner.hasNextInt()) {
			int number = scanner.nextInt();

			if (isPrime(number)) {
				System.out.println(number + " is a prime number.");
			} else {
				System.out.println(number + " is not a prime number.");
			}
		} else {
			System.out.println("Invalid input. Please enter a whole number.");
		}

		scanner.close();
	}

	public static boolean isPrime(int n) {

		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i <= n / 2; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}