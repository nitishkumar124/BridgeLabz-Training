package linear_binary_search;

import java.util.*;

public class SearchForTheFirstNegativeNumber {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, -1, 2, -5 };
		System.out.println("Index of First Negative Element: " + getFirstNegativeIndex(arr));
	}

	public static int getFirstNegativeIndex(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0)
				return i;
		}

		return -1;
	}
}
