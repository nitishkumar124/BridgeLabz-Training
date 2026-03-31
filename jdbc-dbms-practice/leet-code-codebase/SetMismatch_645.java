package week9;

import java.util.*;

public class SetMismatch_645 {
	public int[] findErrorNums(int[] nums) {
		Arrays.sort(nums);

		int duplicate = -1;
		int missing = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				duplicate = nums[i];
			}
			if (nums[i] > nums[i - 1] + 1) {
				missing = nums[i - 1] + 1;
			}
		}
		if (nums[nums.length - 1] != nums.length) {
			missing = nums.length;
		}

		return new int[] { duplicate, missing };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter the elements of the array : ");
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		SetMismatch_645 solution = new SetMismatch_645();
		int[] result = solution.findErrorNums(nums);
		System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);
		sc.close();
	}
}
