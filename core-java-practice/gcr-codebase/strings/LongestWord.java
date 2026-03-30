package extras;

import java.util.*;

public class LongestWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text: ");
		String s = sc.nextLine();

		String[] words = s.split(" ");

		String longest = words[0];

		for (String word : words) {
			if (longest.length() < word.length()) {
				longest = word;
			}
		}
		System.out.println("Longest word : " + longest);

		sc.close();
	}
}
