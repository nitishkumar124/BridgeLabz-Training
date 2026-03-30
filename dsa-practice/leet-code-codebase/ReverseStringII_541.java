package week3;

import java.util.Scanner;

public class ReverseStringII_541 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the string s: ");
		String s = scanner.nextLine();

		System.out.print("Enter the value of k: ");
		int k = scanner.nextInt();

		String result = reverseStr(s, k);
		System.out.println("Result: " + result);

		scanner.close();
	}

	public static String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;

		for (int start = 0; start < n; start += 2 * k) {
			int i = start;

			int j = Math.min(start + k - 1, n - 1);

			while (i < j) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		return new String(arr);
	}
}