package level2;

import java.util.Scanner;

public class StringLength {

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
			System.out.println("exception occured!");			
		}
		return length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter some text : ");
		String text = sc.next();
		int len1 = len(text);
		int len2 = text.length();
		boolean equals = len1 == len2 ? true : false;
		System.out.println("length using charAt() : " + len1);
		System.out.println("length using length() : " + len2);
		System.out.print("equals : " + equals);
	}

}
