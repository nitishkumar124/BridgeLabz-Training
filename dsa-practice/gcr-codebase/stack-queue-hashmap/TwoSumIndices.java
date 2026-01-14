package stack_queue_hashmap;

import java.util.HashMap;

public class TwoSumIndices {
	public static int[] findTwoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}

			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		try {
			int[] result = findTwoSum(nums, target);
			System.out.println("Indices: " + result[0] + ", " + result[1]);
			System.out.println("Values: " + nums[result[0]] + " + " + nums[result[1]] + " = " + target);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}