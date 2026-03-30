package week2;

import java.util.Scanner;

public class ClimbingStairs_70 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of steps (n): ");
		if (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter an integer.");
			return;
		}
		int n = scanner.nextInt();

		int result = climbStairs(n);
		System.out.println("Distinct ways to climb to the top: " + result);

		scanner.close();
	}

	public static int climbStairs(int n) {
		// Base cases
		if (n <= 2)
			return n;

		int first = 1;
		int second = 2;

		for (int i = 3; i <= n; i++) {
			int current = first + second;
			first = second;
			second = current;
		}

		return second;
	}
}