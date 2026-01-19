package week3;

import java.util.Scanner;

public class IsomorphicStrings_205 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter string s: ");
		String s = scanner.nextLine();

		System.out.print("Enter string t: ");
		String t = scanner.nextLine();

		boolean result = isIsomorphic(s, t);
		System.out.println("Are the strings isomorphic? " + result);

		scanner.close();
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] mapS = new int[256];
		int[] mapT = new int[256];

		for (int i = 0; i < s.length(); i++) {
			char charS = s.charAt(i);
			char charT = t.charAt(i);

			if (mapS[charS] != mapT[charT]) {
				return false;
			}

			mapS[charS] = i + 1;
			mapT[charT] = i + 1;
		}

		return true;
	}
}