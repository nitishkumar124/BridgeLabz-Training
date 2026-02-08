package week7;

import java.util.*;

public class LargestPerimeterTriangle_976 {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 2 };
		System.out.println("largest perimeter: " + largestPerimeter(nums));
	}

	public static int largestPerimeter(int[] nums) {
		Arrays.sort(nums);

		for (int i = nums.length - 1; i > 1; i--) {
			if (nums[i - 1] + nums[i - 2] > nums[i])
				return nums[i - 1] + nums[i - 2] + nums[i];
		}
		return 0;
	}
}
