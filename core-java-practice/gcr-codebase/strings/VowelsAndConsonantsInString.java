package level2;

import java.util.Scanner;

public class VowelsAndConsonantsInString {

	public static char checkVowelConsonant(char ch) {
		char t = ch;
		if (ch >= 'A' && ch <= 'Z') {
			t = (char) ('A' - ch + 'a');
		}

		if (t >= 'a' && t <= 'z') {
			if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
				return 'v';
			} else
				return 'c';
		} else {
			return 'n';
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter some text : ");
		String s = sc.nextLine();
		int vowels = 0, consonants = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = checkVowelConsonant(s.charAt(i));
			if (ch == 'v')
				vowels++;
			else if (ch == 'c')
				consonants++;
		}
		
		System.out.println("vowels : " + vowels);
		System.out.println("consonants : " + consonants);

	}

}
