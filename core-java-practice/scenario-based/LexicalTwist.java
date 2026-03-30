package week4_collections;

import java.util.Scanner;

public class LexicalTwist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the first word: ");
		String word1 = sc.nextLine();

		System.out.print("Enter the second word: ");
		String word2 = sc.nextLine();

		if (isValid(word1) && isValid(word2)) {

			if (isReversed(word1, word2)) {
				System.out.println("word_1 transformed: " + replaceAllVowels(convertToLowercase(reverse(word1))));
			} else {
				String combinedWord = convertToUppercase(word1 + word2);
				int vowels = countVowels(combinedWord), consonants = countConsonants(combinedWord);
				if (vowels == consonants) {
					System.out.println("Vowels and consonants are equal");
				} else if (vowels > consonants) {
					System.out.println("first 2 vowels: " + firstTwoVowels(combinedWord));
				} else {
					System.out.println("first 2 consonants: " + firstTwoConsonants(combinedWord));
				}
			}
		}

	}

	public static boolean isReversed(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;

		return equals(convertToLowercase(word1), reverse(convertToLowercase(word2)));
	}

	public static boolean equals(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;

		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				return false;
		}
		return true;
	}

	public static String convertToLowercase(String word) {
		String lowercase = "";
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				ch = (char) (ch - 'A' + 'a');
			lowercase += ch;
		}
		return lowercase;
	}

	static String convertToUppercase(String word) {
		String uppercase = "";

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch >= 'a' && ch <= 'z')
				ch = (char) (ch - 'a' + 'A');
			uppercase += ch;
		}
		return uppercase;
	}

	static String reverse(String word) {
		String reversed = "";
		for (int i = 0; i < word.length(); i++) {
			reversed = word.charAt(i) + reversed;
		}
		return reversed;
	}

	static String replaceAllVowels(String word) {
		String result = "";

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (isVowel(ch))
				result += '@';
			else
				result += ch;
		}
		return result;
	}

	static int countVowels(String word) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (isVowel(ch))
				count++;
		}
		return count;
	}

	static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U';
	}

	static int countConsonants(String word) {
		return word.length() - countVowels(word);
	}

	static String firstTwoVowels(String word) {
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (isVowel(ch) && !isDuplicate(result, word.charAt(i)) && result.length() < 2)
				result += ch;
		}
		return result;
	}

	static String firstTwoConsonants(String word) {
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!isVowel(ch) && !isDuplicate(result, word.charAt(i)) && result.length() < 2)
				result += ch;
		}
		return result;
	}

	static boolean isDuplicate(String word, char ch) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch)
				return true;
		}
		return false;
	}

	static boolean isValid(String word) {
		boolean flag = true;

		for (char ch : word.toCharArray()) {
			if (ch == ' ') {
				flag = false;
				break;
			}
		}

		if (!flag)
			System.out.println(word + " is an invalid word");
		return flag;
	}

}
