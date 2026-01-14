package stack_queue_hashmap;

import java.util.HashSet;

public class TwoSum {
	public static void findAndPrintPair(int[] nums, int target) {
		HashSet<Integer> visited = new HashSet<>();
		boolean found = false;

		for (int num : nums) {
			int complement = target - num;

			if (visited.contains(complement)) {
				System.out.println("Pair found: (" + complement + ", " + num + ")");
				found = true;
				// Use 'break' if you only want the first pair found
				break;
			}

			visited.add(num);
		}

		if (!found) {
			System.out.println("No pair exists that sums to " + target);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 45, 6, 10, 8 };
		int target = 16;
		findAndPrintPair(nums, target);
	}
}