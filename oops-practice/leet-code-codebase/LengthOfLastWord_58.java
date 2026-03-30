package week2;

import java.util.Scanner;

public class LengthOfLastWord_58 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String s = scanner.nextLine();

		int result = lengthOfLastWord(s);
		System.out.println("Length of the last word: " + result);

		scanner.close();
	}

	public static int lengthOfLastWord(String s) {
		int length = 0;
		int i = s.length() - 1;

		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}

		while (i >= 0 && s.charAt(i) != ' ') {
			length++;
			i--;
		}

		return length;
	}
}