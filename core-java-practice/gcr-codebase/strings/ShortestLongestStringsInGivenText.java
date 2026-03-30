package level2;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestLongestStringsInGivenText {

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

	public static String[][] wordLength(String[] arr) {
		String[][] wordLengthArr = new String[arr.length][2];

		for (int i = 0; i < arr.length; i++) {
			wordLengthArr[i][0] = arr[i];
			wordLengthArr[i][1] = String.valueOf(len(arr[i]));
		}

		return wordLengthArr;

	}

	public static int[] findMinMaxStringLength(String[][] arr) {
		int minIdx = 0;
		int maxIdx = 0;

		int minLength = Integer.parseInt(arr[0][1]);
		int maxLength = Integer.parseInt(arr[0][1]);

		for (int i = 1; i < arr.length; i++) {
			int currentLength = Integer.parseInt(arr[i][1]);

			if (currentLength < minLength) {
				minLength = currentLength;
				minIdx = i;
			}

			if (maxLength < currentLength) {
				maxLength = currentLength;
				maxIdx = i;
			}
		}
		return new int[] { minIdx, maxIdx };
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
		String[] words = split(text);

		printArr(words);

		String[][] wordLengthArr = wordLength(words);
		int[] minMaxStringIndices = findMinMaxStringLength(wordLengthArr);
		System.out.println("the indices of shortest and longest words : " + minMaxStringIndices[0] + ", "
				+ minMaxStringIndices[1]);
	}

}
