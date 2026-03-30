package level2;

import java.util.Scanner;

public class VowelsAndConsonantsInString2 {

	public static String[] checkVowelConsonant(char ch) {
		char t = ch;
		if (ch >= 'A' && ch <= 'Z') {
			t = (char) ('A' - ch + 'a');
		}

		if (t >= 'a' && t <= 'z') {
			if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
				return new String[] { t + "", "vowel" };
			} else
				return new String[] { t + "", "consonant" };
		} else {
			return new String[] { t + "", "not a letter" };
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter some text : ");
		String s = sc.nextLine();
		int vowels = 0, consonants = 0;

		String[][] arr = new String[s.length()][2];

		for (int i = 0; i < s.length(); i++) {
			String[] ch = checkVowelConsonant(s.charAt(i));
			arr[i] = ch;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " : " + arr[i][1]);
		}

	}

}
