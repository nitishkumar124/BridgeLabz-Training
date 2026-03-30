package week2;

import java.util.Scanner;

public class FindTheIndexOfTheFirstOccurrence_28 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter haystack string: ");
		String haystack = scanner.nextLine();

		System.out.print("Enter needle string: ");
		String needle = scanner.nextLine();

		int result = strStr(haystack, needle);
		System.out.println("First occurrence index: " + result);

		scanner.close();
	}

	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty())
			return 0;

		int hLen = haystack.length();
		int nLen = needle.length();

		for (int i = 0; i <= hLen - nLen; i++) {
			if (haystack.substring(i, i + nLen).equals(needle)) {
				return i;
			}
		}

		return -1;
	}
}