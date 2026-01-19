package week2;

import java.util.Scanner;

public class AddDigits_258 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a non-negative integer: ");
		if (!scanner.hasNextInt()) {
			System.out.println("Invalid input.");
			return;
		}
		int num = scanner.nextInt();

		int result = addDigits(num);
		System.out.println("The digital root is: " + result);

		scanner.close();
	}

	public static int addDigits(int num) {
		if (num == 0)
			return 0;
		if (num % 9 == 0)
			return 9;
		return num % 9;
	}
}