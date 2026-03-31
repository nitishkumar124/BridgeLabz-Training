package m1_practice_problems;

import java.util.*;

public class KeyGeneration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();

			String result = process(input);
			System.out.println(result);
		}
	}

	public static String process(String str) {
		if (str == null || str.length() == 0) {
			return "Invalid Input (empty string)";
		}

		if (str.length() < 6) {
			return "Invalid Input (length < 6)";
		}

		if (str.contains(" ")) {
			return "Invalid Input (contains space)";
		}

		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				return "Invalid Input (contains digits)";
			}
		}

		for (char c : str.toCharArray()) {
			if (!Character.isLetter(c)) {
				return "Invalid Input (contains special character)";
			}
		}

		str = str.toLowerCase();

		StringBuilder filtered = new StringBuilder();
		for (char c : str.toCharArray()) {
			if ((int) c % 2 != 0) {
				filtered.append(c);
			}
		}

		filtered.reverse();

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < filtered.length(); i++) {
			char c = filtered.charAt(i);
			if (i % 2 == 0) {
				result.append(Character.toUpperCase(c));
			} else {
				result.append(c);
			}
		}
		return "The generated key is - " + result.toString();

	}
}
