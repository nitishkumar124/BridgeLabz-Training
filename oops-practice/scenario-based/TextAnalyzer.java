package week2;

import java.util.*;

public class TextAnalyzer {

	static String[] words(String text) {
		text = SentenceFormatter.formatText(text).trim();
		if (text.isEmpty()) {
			System.out.println("Invalid Input.");
			return null;
		}
		String[] words = text.split(" ");
		return words;
	}

	static int countWords(String text) {
		int count = words(text).length;
		return count != 0 ? count : 0;
	}

	static String longestWord(String text) {
		String[] words = words(text);
		if (words == null)
			return "no words";
		int index = 0, longestWordIndex = 0;
		while (index < words.length) {
			if (words[longestWordIndex].length() < words[index].length()) {
				longestWordIndex = index;
			}
			index++;
		}
		return words[longestWordIndex];
	}

	static String replaceAll(String text, String word, String word2) {
		String[] words = words(text);
		String result = " ";
		for (int i = 0; i < words.length; i++) {
			if (words[i].equalsIgnoreCase(word)) {
				words[i] = word2;
			}
			result += words[i] + " ";
		}
		return result.trim();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.nextLine();
		System.out.println("input text: " + text);
		System.out.println("word count: " + countWords(text));
		System.out.println("longest word: " + longestWord(text));
		System.out.print("input the word to replace: ");
		String word = sc.nextLine();
		System.out.print("input the word to replace with: ");
		String word2 = sc.nextLine();
		System.out.println("after replacing word occurances: " + replaceAll(text, word, word2));
		sc.close();
	}
}
