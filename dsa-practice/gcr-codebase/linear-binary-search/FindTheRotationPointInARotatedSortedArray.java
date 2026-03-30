package linear_binary_search;

import java.util.*;

public class FindTheRotationPointInARotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else if (arr[mid] < arr[right]) {
				right = mid;
			}
		}
		int rotationPoint = arr[left];
		System.out.println("Rotation Point: " + rotationPoint);
	}
}
