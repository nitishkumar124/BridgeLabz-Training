package level3;

import java.util.*;

public class UniqueCharacters {

	static int len(String s) {
		int l = 0;

		try {
			int i = 0;
			while (s.charAt(i++) != '\n')
				l++;
		} catch (Exception e) {
		}
		return l;
	}

	static void print(char[] arr) {
		System.out.println("Unique Characters :");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text : ");
		String s = sc.nextLine();
		char[] arr = new char[len(s)];
		int index = 0;
		for (int i = 0; i < len(s); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') continue;
			boolean flag = true;
			for (int j = 0; j < arr.length; j++) {
				char temp = arr[j];
				if (ch == temp) {
					flag = false;
					break;
				}
			}
			if (flag) {
				arr[index++] = ch;
			}
		}
		print(arr);

		sc.close();
	}
}
