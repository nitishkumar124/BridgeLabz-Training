package level1;

import java.util.*;

public class StringCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("str : ");
		String str = sc.nextLine();

		char[] charArr1 = stringCharacters(str);
		char[] charArr2 = str.toCharArray();

		System.out.print("Char Array1 : ");
		printArr(charArr1);
		System.out.print("Char Array2 : ");
		printArr(charArr2);
		boolean checkCharArrayEquality = compareCharArray(charArr1, charArr2);
		System.out.print("charArray1 equals charArray2 : " + checkCharArrayEquality);

	}

	public static char[] stringCharacters(String str) {
		int size = str.length();
		char[] arr = new char[size];
		for (int i = 0; i < size; i++) {
			arr[i] = str.charAt(i);
		}
		return arr;
	}

	public static void printArr(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static boolean compareCharArray(char[] charArray1, char[] charArray2) {
		if (charArray1.length != charArray2.length)
			return false;
		for (int i = 0; i < charArray1.length; i++) {
			if (charArray1[i] != charArray2[i])
				return false;
		}
		return true;
	}
}
