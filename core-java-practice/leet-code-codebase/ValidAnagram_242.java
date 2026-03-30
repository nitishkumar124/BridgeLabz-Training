package week1;

import java.util.Scanner;

public class ValidAnagram_242 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first string (s): ");
		String s = scanner.nextLine();

		System.out.print("Enter second string (t): ");
		String t = scanner.nextLine();

		boolean result = isAnagram(s, t);
		System.out.println("Are they anagrams? " + result);

		scanner.close();
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] counter = new int[26];

		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}

		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}
}