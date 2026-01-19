package week3;

import java.util.Scanner;

public class CheckIfTwoStringArraysAreEquivalent_1662 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter strings for word1 separated by spaces: ");
		String[] word1 = scanner.nextLine().split("\\s+");

		System.out.print("Enter strings for word2 separated by spaces: ");
		String[] word2 = scanner.nextLine().split("\\s+");

		boolean result = arrayStringsAreEqual(word1, word2);
		System.out.println("Are the arrays equivalent? " + result);

		scanner.close();
	}

	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		int wordIdx1 = 0, charIdx1 = 0;
		int wordIdx2 = 0, charIdx2 = 0;

		while (wordIdx1 < word1.length && wordIdx2 < word2.length) {

			if (word1[wordIdx1].charAt(charIdx1) != word2[wordIdx2].charAt(charIdx2)) {
				return false;
			}

			charIdx1++;
			if (charIdx1 == word1[wordIdx1].length()) {
				wordIdx1++;
				charIdx1 = 0;
			}

			charIdx2++;
			if (charIdx2 == word2[wordIdx2].length()) {
				wordIdx2++;
				charIdx2 = 0;
			}
		}

		return wordIdx1 == word1.length && wordIdx2 == word2.length;
	}
}