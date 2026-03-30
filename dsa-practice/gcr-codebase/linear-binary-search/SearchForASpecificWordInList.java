package linear_binary_search;

import java.util.*;

public class SearchForASpecificWordInList {

	public static void main(String[] args) {
		String[] sentences = { "Hello Aryansh.", "Aryansh Chaudhary.", "Aryansh from Dauji." };
		System.out.println("First sentence with [Aryansh]: " + getFirstSentenceWord(sentences, "Aryansh"));

	}

	public static String getFirstSentenceWord(String[] sentences, String word) {
		for (int i = 0; i < sentences.length; i++) {
			String sentence = sentences[i];
			if (sentence.contains(word))
				return sentence;
		}
		return "NOT Found.";
	}
}
