package week4.part2;

import java.util.*;

public class MissingNumber_268 {

	public static void main(String[] args) {
		int[] nums = { 3, 0, 1 };
		System.out.println("missing number: " + missingNumber(nums));
	}

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int total = n * (n + 1) / 2, sum = 0;
		for (int num : nums)
			sum += num;
		return total - sum;
	}
}
