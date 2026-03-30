package linear_binary_search;

import java.util.*;

public class FindPeakElementInTheArray {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int left = 0, right = arr.length - 1;
		int mid;
		int peakElement = -1;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				peakElement = arr[mid];
				break;
			} else if (arr[mid] < arr[mid - 1])
				right = mid;
			else if (arr[mid] < arr[mid + 1])
				left = mid + 1;
		}
		System.out.println("Peak Element: " + peakElement);
	}
}
