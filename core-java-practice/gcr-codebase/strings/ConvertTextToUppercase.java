package level1;

import java.util.*;

public class ConvertTextToUppercase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the text : ");
		String text = sc.nextLine();

		String str1 = convertToUpperCase(text);

		String str2 = text.toUpperCase();

		boolean equals = compareStrings(str1, str2);

		System.out.println("using charAt():  " + str1);
		System.out.println("using toUpperCase() Method:    " + str2);
		System.out.println("equals : " + equals);

	}

	public static boolean compareStrings(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static String convertToUpperCase(String text) {
		String result = "";

		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				result += ((char) (ch - 32));
			} else {
				result += ch;
			}
		}
		return result.toString();
	}

}
