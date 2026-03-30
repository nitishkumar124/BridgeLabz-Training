package week1;

import java.util.Scanner;
import java.util.Arrays;

public class SearchInsertPosition_35 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter sorted integers separated by spaces: ");
		String input = scanner.nextLine();
		int[] nums = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

		System.out.print("Enter the target value: ");
		int target = scanner.nextInt();

		int result = searchInsert(nums, target);
		System.out.println("The index is: " + result);

		scanner.close();
	}

	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
}