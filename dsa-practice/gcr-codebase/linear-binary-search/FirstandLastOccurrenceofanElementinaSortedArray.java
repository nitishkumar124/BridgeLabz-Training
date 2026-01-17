package linear_binary_search;

import java.util.*;

public class FirstandLastOccurrenceofanElementinaSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 2, 3, 4, 5, 6 };
		int[] occurrences = { -1, -1 };
		int target = 1, i = 1;
		int left = 0, right = arr.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				occurrences[i--] = mid;
				right = mid - 1;
			} else if (arr[mid] < target) {
				left = mid;
			} else if (arr[mid] > target) {
				right = mid;
			}
		}
		System.out.println("Indices of First and Last Appearance: " + occurrences[0] + ", " + occurrences[1]);
	}
}
