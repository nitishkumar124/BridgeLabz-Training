package level1;

import java.util.*;

public class CreateSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("string : ");
		String str = sc.nextLine();
		System.out.print("start index : ");
		int start = sc.nextInt();
		System.out.print("end index : ");
		int end = sc.nextInt();

		String subStr1 = createSubstring(str, start, end);
		String subStr2 = str.substring(start, end);

		System.out.println("using charAt() : " + subStr1);
		System.out.println("using substring() : " + subStr2);

	}

	public static String createSubstring(String str, int start, int end) {
		String subStr = "";

		while (start <= end)
			subStr += str.charAt(start++);

		return subStr;

	}

}
