package extras2;

import java.util.Scanner;

public class NumberGuessingGame {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("Think of a number between 1 and 100, and I will try to guess it.");
		System.out.println("Feedback options: 'high', 'low', or 'correct'.");

		playGame();
	}

	public static void playGame() {
		int low = 1;
		int high = 100;
		boolean guessedCorrectly = false;
		int attempts = 0;

		while (!guessedCorrectly) {
			attempts++;
			int guess = generateGuess(low, high);
			String feedback = receiveFeedback(guess);

			if (feedback.equals("correct")) {
				System.out.println("Hooraay! I found it in " + attempts + " tries.");
				guessedCorrectly = true;
			} else {
				if (feedback.equals("high")) {
					high = guess - 1;
				} else if (feedback.equals("low")) {
					low = guess + 1;
				}

				if (low > high) {
					System.out.println("Wait, something is wrong. Your feedback is contradicting itself!");
					break;
				}
			}
		}
	}

	public static int generateGuess(int low, int high) {
		return low + (high - low) / 2;
	}

	public static String receiveFeedback(int guess) {
		System.out.print("Is it " + guess + "? (high/low/correct): ");
		return scanner.nextLine().toLowerCase().trim();
	}
}