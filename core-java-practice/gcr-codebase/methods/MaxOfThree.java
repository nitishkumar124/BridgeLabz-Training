package extras2;

import java.util.Scanner;

public class MaxOfThree {

	public static void main(String[] args) {
		int[] numbers = getUserInputs();
		int max = calculateMax(numbers[0], numbers[1], numbers[2]);

		displayResult(max);
	}

	public static int[] getUserInputs() {
		Scanner scanner = new Scanner(System.in);
		int[] inputs = new int[3];

		for (int i = 0; i < 3; i++) {
			System.out.print("Enter integer " + (i + 1) + ": ");

			while (!scanner.hasNextInt()) {
				System.out.println("Not a valid integer.");
				scanner.next();
			}
			inputs[i] = scanner.nextInt();
		}
		return inputs;
	}

	public static int calculateMax(int a, int b, int c) {
		int max = a;

		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}

		return max;
	}

	public static void displayResult(int result) {
		System.out.println("The maximum number is: " + result);
	}
}