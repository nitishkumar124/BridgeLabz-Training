package level1;

import java.util.Scanner;

public class ConvertTextToLowercase {

	public static String convertToLowercase(String str) {
		String lowercaseStr = "";
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				lowercaseStr += (char)(ch - 'A' + 'a');
			else
				lowercaseStr += ch;
		}
		
		return lowercaseStr;
	}
	
	public static boolean compareStrings(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter some text : ");
		String text = sc.next();
		String str1 = convertToLowercase(text);
		String str2 = text.toLowerCase();
		boolean equals = compareStrings(str1, str2);
		
		System.out.println("using charAt() : " + str1);
		System.out.println("using toLowerCase() : " + str2);
		System.out.println("equals : " + equals);

	}

}
