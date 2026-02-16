package week9;

import java.util.*;

public class ReverseWordsinaStringIII_557 {
	public String reverseWords(String s) {
		String[] words = s.split(" ");
		String str = "";

		for (String word : words) {
			String reversed = "";

			for (int i = word.length() - 1; i >= 0; i--) {
				reversed += word.charAt(i);
			}
			str += reversed + " ";
		}
		return str.trim();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string : ");
		String s = sc.nextLine();
		ReverseWordsinaStringIII_557 solution = new ReverseWordsinaStringIII_557();
		String result = solution.reverseWords(s);
		System.out.println("Reversed words in the string: " + result);
		sc.close();
	}
}
