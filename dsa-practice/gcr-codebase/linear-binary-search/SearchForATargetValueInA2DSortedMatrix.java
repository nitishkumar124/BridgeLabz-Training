package linear_binary_search;

import java.util.*;

public class SearchForATargetValueInA2DSortedMatrix {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		int cols = arr[0].length;
		int target = 5;
		int left = 0, right = arr.length * cols - 1;
		boolean found = false;

		while (left < right) {
			int mid = left + (right - left) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (arr[row][col] == target) {
				found = true;
				break;
			} else if (target < arr[row][col]) {
				right = mid;
			} else if (target > arr[row][col]) {
				left = mid + 1;
			}
		}

		if (found)
			System.out.println("Found.");
		else
			System.out.println("NOT Found.");
	}
}
