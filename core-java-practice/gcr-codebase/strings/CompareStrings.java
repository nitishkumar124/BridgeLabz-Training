package level1;

import java.util.*;

public class CompareStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("str1 : ");
		String str1 = sc.nextLine();
		System.out.print("str2 : ");
		String str2 = sc.nextLine();
		
		boolean checkCharAt = compareStrings(str1, str2);
		boolean checkEquals = str1.equals(str2);
		
		System.out.println("using charAt() : " + checkCharAt);
		System.out.println("using equals() : " + checkEquals);

	}

	public static boolean compareStrings(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		for (int i = 0; i < str1.length(); i++)
			if (str1.charAt(i) != str2.charAt(i))
				return false;

		return true;
	}

}
