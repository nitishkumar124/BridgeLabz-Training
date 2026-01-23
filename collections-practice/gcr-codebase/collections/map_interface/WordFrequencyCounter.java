package collections.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordFrequencyCounter {

	public static void main(String[] args) {

		String input = "Hello world, hello Java! Java is fun.";

		Map<String, Integer> frequencies = countWordFrequency(input);

		System.out.println("Word Frequencies:");
		frequencies.forEach((word, count) -> System.out.println(word + ": " + count));
	}

	public static Map<String, Integer> countWordFrequency(String text) {
		Map<String, Integer> map = new HashMap<>();

		String[] words = text.toLowerCase().split("\\W+");

		for (String word : words) {
			if (!word.isEmpty()) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}

		return map;
	}

	public static void processFile(String filePath) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filePath));

	}
}