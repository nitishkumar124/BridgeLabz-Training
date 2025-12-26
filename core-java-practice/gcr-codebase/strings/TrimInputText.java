package level2;

import java.util.*;

public class TrimInputText {

	public static String trim(String s) {
		String result = "";

		int start = 0, end = s.length() - 1;

		while (s.charAt(start) == ' ')
			start++;
		while (s.charAt(end) == ' ')
			end--;

		for (int i = start; i <= end; i++) {
			result += s.charAt(i);
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text : ");
		String input = sc.nextLine();
		String newString = trim(input);
		System.out.println("Original String : " + input);
		System.out.println("Trimmed String : " + newString);
		sc.close();
	}
}
