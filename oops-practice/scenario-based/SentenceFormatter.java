package week2;

import java.util.*;

public class SentenceFormatter {

	static String formatText(String text) {
		text = text.trim();
		String result = "";
		boolean cap = true;

		for (int i = 0; i < text.length();) {
			char ch = text.charAt(i);
			if (ch == '.' || ch == ',' || ch == '?' || ch == '!') {
				result += ch;
				result += " ";
				if (ch != ',')
					cap = true;
				i++;
			} else if (ch == ' ') {
				result += " ";
				while (true) {
					ch = text.charAt(i);
					if (ch != ' ')
						break;
					i++;
				}
			} else {
				if (cap) {
					cap = false;
					result += ("" + ch).toUpperCase();
				} else {
					result += ch;
				}
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text: ");
		String text = sc.nextLine();
		System.out.println(formatText(text));
		sc.close();
	}
}
