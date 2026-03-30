package level2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabulateSplitText {

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
	
	public static void printArr(String[][] arr) {
		System.out.println("  word   |   length");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + "    |    " + arr[i][1]);
		}
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("enter some text : ");

		String text = sc.nextLine();
		String[] words = split(text);

		String[][] wordLengthArr = wordLength(words);
		
		printArr(wordLengthArr);
		


	}

}
