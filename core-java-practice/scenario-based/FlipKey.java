package week1;

import java.util.*;

public class FlipKey {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter input: ");
		String input = sc.nextLine();
		System.out.println(cleanseAndInvert(input));
		sc.close();
	}

	public static String cleanseAndInvert(String input) {
		if (!isValid(input))
			return "Invalid Input";

		StringBuilder result = new StringBuilder("");

		for (char ch : input.toCharArray())
			if (ch % 2 != 0)
				result.append(Character.toLowerCase(ch));

		result.reverse();

		for (int i = 0; i < result.length(); i++)
			if (i % 2 == 0)
				result.setCharAt(i, Character.toUpperCase(result.charAt(i)));

		return "The generated key is - " + result.toString();

	}

	static boolean isValid(String input) {

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'))
				return false;
		}
		return input.length() >= 6;
	}

}
