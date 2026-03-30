package stack_queue_hashmap;

import java.util.*;

public class LongestConsecutiveSequence {
	
	public static void printLongestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			System.out.println("Array is empty.");
			return;
		}

		HashSet<Integer> set = new HashSet<>();
		for (int num : nums)
			set.add(num);

		int longestStreak = 0;
		int streakStartNode = -1;

		for (int num : set) {
			if (!set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				if (currentStreak > longestStreak) {
					longestStreak = currentStreak;
					streakStartNode = num;
				}
			}
		}

		List<Integer> sequence = new ArrayList<>();
		for (int i = 0; i < longestStreak; i++) {
			sequence.add(streakStartNode + i);
		}

		System.out.println("Longest Sequence: " + sequence);
		System.out.println("Length: " + longestStreak);
	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		printLongestConsecutive(nums);
	}
}