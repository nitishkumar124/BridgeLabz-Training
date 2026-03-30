package level3;

import java.util.Scanner;

public class CharacterFrequencyUsingToCharArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String s = sc.nextLine();

		String[] result = findFrequency(s);

		System.out.println("\nCharacter Frequencies: ");
		for (String entry : result) {
			if (entry != null) {
				System.out.println(entry);
			}
		}

		sc.close();
	}

	public static String[] findFrequency(String s) {
		char[] chars = s.toCharArray();
		int[] freq = new int[chars.length];

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '0' || chars[i] == ' ') {
				continue;
			}

			freq[i] = 1;
			for (int j = i + 1; j < chars.length; j++) {
				if (chars[i] == chars[j]) {
					freq[i]++;
					chars[j] = '0';
				}
			}
		}

		String[] arr = new String[chars.length];
		int count = 0;

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != '0' && chars[i] != ' ') {
				arr[count] = chars[i] + " - " + freq[i];
				count++;
			}
		}

		return arr;
	}
}