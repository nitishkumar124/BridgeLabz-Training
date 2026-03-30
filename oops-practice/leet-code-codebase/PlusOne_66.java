package week2;

import java.util.Scanner;
import java.util.Arrays;

public class PlusOne_66 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter digits separated by spaces (e.g., 1 2 3): ");
		String input = scanner.nextLine();
		int[] digits = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

		int[] result = plusOne(digits);
		System.out.println("Result: " + Arrays.toString(result));

		scanner.close();
	}

	public static int[] plusOne(int[] digits) {
		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;

				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;
		return newNumber;
	}
}