package level2;

import java.util.Arrays;
import java.util.Scanner;

public class SplitTextIntoWords {

	public static int len(String str) {
		int length = 0;
		try {
			int i = 0;
			while (true) {
				char ch = str.charAt(i);
				i++;
				length++;
			}

		} catch (Exception e) {
			return length;
		}
	}

	public static String[] split(String s) {

		if (len(s) == 0)
			return new String[] {};

		int spaceCount = 0;
		for (int i = 0; i < len(s); i++) {
			if (s.charAt(i) == ' ')
				spaceCount++;
		}

		String[] words = new String[spaceCount + 1];

		String temp = "";
		int k = 0;
		for (int i = 0; i < len(s); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				words[k++] = temp;
				temp = "";
				continue;
			}
			temp += ch;
		}
		words[k] = temp;
		return words;

	}

	public static boolean compareStringArrays(String[] a1, String[] a2) {
		if (a1.length != a2.length)
			return false;

		for (int i = 0; i < a2.length; i++) {
			if (!a1[i].equals(a2[i]))
				return false;
		}

		return true;
	}

	public static void printArr(String[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " | ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("enter some text : ");

		String text = sc.nextLine();
		String[] strArr1 = split(text);
		String[] strArr2 = text.split(" ");

		System.out.println("using custom split() words : ");
		printArr(strArr1);
		System.out.println("using built-in split() words : ");
		printArr(strArr2);
		System.out.println("comparison result : " + compareStringArrays(strArr1, strArr2));
	}

}
